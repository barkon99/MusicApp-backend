package com.konew.musicapp.service;

import com.konew.musicapp.entity.Artist;
import com.konew.musicapp.entity.User;
import com.konew.musicapp.exception.ResourceNotFoundException;
import com.konew.musicapp.exception.UserAlreadySavedResourcesException;
import com.konew.musicapp.model.response.ArtistResponse;
import com.konew.musicapp.repository.ArtistRepository;
import com.konew.musicapp.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserArtistService {
    ArtistRepository artistRepository;
    DeezerService deezerService;
    UserRepository userRepository;

    public UserArtistService(ArtistRepository artistRepository, DeezerService deezerService, UserRepository userRepository) {
        this.artistRepository = artistRepository;
        this.deezerService = deezerService;
        this.userRepository = userRepository;
    }

    public List<ArtistResponse> getUserArtists(Long userId) {
        if (isUserHasSavedArtist(userId)) {
            return artistRepository.findUserSavedArtists(userId).stream()
                    .map(artist -> mapToArtistResponse(artist)).collect(Collectors.toList());
        }
        return null;
    }

    public ArtistResponse mapToArtistResponse(Artist artist) {
        ArtistResponse artistResponse = ArtistResponse.builder()
                .id(artist.getId())
                .name(artist.getName())
                .tracks(null)
                .deezerLink(artist.getLink())
                .image(artist.getImage())
                .deezerId(artist.getDeezerId())
                .build();
        return artistResponse;
    }

    public ResponseEntity<?> saveUserArtist(Long artistId, Long userId) {
        com.konew.musicapp.model.deezer.Artist deezerArtist = deezerService.getArtist(artistId);

        if (!getArtistIfExist(deezerArtist).isPresent()) {
            Artist artistEntity = new Artist();
            artistEntity.setName(deezerArtist.getName());
            artistEntity.setTracks(null);
            artistEntity.setLink(deezerArtist.getLink());
            artistEntity.setImage(deezerArtist.getPicture());
            artistEntity.setTrackList(null);
            artistEntity.setDeezerId(Long.valueOf(deezerArtist.getId()));

            User user = userRepository.findById(userId).orElse(null);

            if (user != null) {
                artistEntity.setUsers(Arrays.asList(user));
            }
            artistRepository.save(artistEntity);
            return ResponseEntity.ok(mapToArtistResponse(artistEntity));
        }
        else{
            Artist artist = getArtistIfExist(deezerArtist).get();
            Optional<User> optionalUserArtist = artist.getUsers().stream().filter(a -> a.getId() == userId).findFirst();
            boolean ifUserHasArtistSaved = optionalUserArtist.isPresent();
            if(ifUserHasArtistSaved) throw new UserAlreadySavedResourcesException("You already saved this artist");
            else{
                List<User> artistUsers = artist.getUsers();
                artistUsers.add(userRepository.getOne(userId));

                artist.setUsers(artistUsers);
                artistRepository.save(artist);
                return ResponseEntity.ok("Artist is saved for user with id "+ userId);
            }
        }
    }

    public ResponseEntity<?> deleteArtist(Long artistId, Long userId) {
        Optional<Artist> optionalArtist = artistRepository.findById(artistId);
        if(optionalArtist.isPresent())
        {
            Artist artist = optionalArtist.get();
            List<User> updatedArtistUsers = artist.getUsers().stream().filter(user -> user.getId() != userId).collect(Collectors.toList());
            if(updatedArtistUsers.size() == 0) artistRepository.delete(artist);
            else {
                artist.setUsers(updatedArtistUsers);
                artistRepository.save(artist);
            }
            return ResponseEntity.ok("Artist is deleted from user with id " + userId);
        }
        return getBadRequest("Artist with id " + artistId + " does not exist");
    }

    private boolean isUserHasSavedArtist(Long userId) {
        return !artistRepository.findUserSavedArtists(userId).isEmpty();
    }

    private ResponseEntity<String> getBadRequest(String message) {
        return ResponseEntity.badRequest().body(message);
    }

    private Optional<Artist> getArtistIfExist(com.konew.musicapp.model.deezer.Artist deezerArtist) {
        return artistRepository.ifArtistExist(deezerArtist.getId());
    }
}
