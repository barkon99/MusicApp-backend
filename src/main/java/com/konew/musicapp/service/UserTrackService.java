package com.konew.musicapp.service;

import com.konew.musicapp.entity.Track;
import com.konew.musicapp.entity.User;
import com.konew.musicapp.exception.UserAlreadySavedResourcesException;
import com.konew.musicapp.model.response.TrackResponse;
import com.konew.musicapp.repository.TrackRepository;
import com.konew.musicapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserTrackService {
    TrackRepository trackRepository;
    DeezerService deezerService;
    UserRepository userRepository;

    @Autowired
    public UserTrackService(TrackRepository trackRepository, DeezerService deezerService, UserRepository userRepository) {
        this.trackRepository = trackRepository;
        this.deezerService = deezerService;
        this.userRepository = userRepository;
    }

    public List<TrackResponse> getUserTracks(Long userId) {
        if (isUserHasTracks(userId)) {
            return trackRepository.findUserSavedTracks(userId).stream()
                    .map(track -> mapToTrackResponse(track)).collect(Collectors.toList());
        }
        return null;
    }

    public TrackResponse mapToTrackResponse(Track track) {
        TrackResponse trackResponse = TrackResponse.builder()
                .id(track.getId())
                .title(track.getTitle())
                .artist(track.getArtist())
                .deezerRanking(track.getRanking())
                .deezerLink(track.getLink())
                .releaseDate(track.getReleaseDate())
                .mp3Url(track.getMp3Url())
                .deezerId(track.getDeezerId())
                .build();
        return trackResponse;
    }

    public ResponseEntity<?> saveUserTrack(Long trackId, Long userId) throws ParseException {
        com.konew.musicapp.model.deezer.Track deezerTrack = deezerService.getTrack(trackId);
        if (!ifTrackExist(deezerTrack)) {
            Track trackEntity = new Track();
            trackEntity.setTitle(deezerTrack.getTitle());
            trackEntity.setArtist(getArtistOfTrack(deezerTrack));
            trackEntity.setRanking(deezerTrack.getRank());
            trackEntity.setLink(deezerTrack.getLink());
            trackEntity.setReleaseDate(new SimpleDateFormat("yyyy-mm-dd").parse(deezerTrack.getReleaseDate()));
            trackEntity.setMp3Url(deezerTrack.getPreview());
            trackEntity.setDeezerId(Long.valueOf(deezerTrack.getId()));

            User user = userRepository.findById(userId).orElse(null);

            if (user != null) {
                trackEntity.setUsers(Arrays.asList(user));
            }
            trackRepository.save(trackEntity);

            return ResponseEntity.ok(mapToTrackResponse(trackEntity));
        } else {
            Track track = getTracksIfExist(deezerTrack).get();
            Optional<User> optionalUserTrack = track.getUsers().stream().filter(t -> t.getId() == userId).findFirst();
            boolean ifUserHasTrackSaved = optionalUserTrack.isPresent();
            if (ifUserHasTrackSaved) throw new UserAlreadySavedResourcesException("You already saved this track");
            else {
                List<User> trackUsers = track.getUsers();
                trackUsers.add(userRepository.getOne(userId));

                track.setUsers(trackUsers);
                trackRepository.save(track);
                return ResponseEntity.ok("Track is saved for user with id " + userId);
            }
        }
    }

    private String getArtistOfTrack(com.konew.musicapp.model.deezer.Track deezerTrack) {
        return deezerTrack.getArtist().getName();
    }

    private boolean ifTrackExist(com.konew.musicapp.model.deezer.Track deezerTrack) {
        return trackRepository.ifTrackExist(deezerTrack.getId()).isPresent();
    }

    public ResponseEntity<?> deleteTrack(Long trackId, Long userId) {
        Optional<Track> optionalTrack = trackRepository.findById(trackId);
        if (optionalTrack.isPresent()) {
            Track track = optionalTrack.get();
            List<User> updatedTrackUsers = track.getUsers().stream().filter(user -> user.getId() != userId).collect(Collectors.toList());
            if (updatedTrackUsers.size() == 0) trackRepository.delete(track);
            else {
                track.setUsers(updatedTrackUsers);
                trackRepository.save(track);
            }
            return ResponseEntity.ok("Track is deleted from user with id " + userId);
        }
        return getBadRequest("Track with id " + trackId + "does not exist");
    }

    private boolean isUserHasTracks(Long userId) {
        return !trackRepository.findUserSavedTracks(userId).isEmpty();
    }

    private ResponseEntity<String> getBadRequest(String message) {
        return ResponseEntity.badRequest().body(message);
    }

    private Optional<Track> getTracksIfExist(com.konew.musicapp.model.deezer.Track deezerTrack) {
        return trackRepository.ifTrackExist(deezerTrack.getId());
    }
}
