package com.konew.musicapp.controller;

import com.konew.musicapp.model.response.TrackResponse;
import com.konew.musicapp.model.response.Track;
import com.konew.musicapp.service.UserTrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserTrackController {
    UserTrackService userTrackService;

    public UserTrackController(UserTrackService userTrackService) {
        this.userTrackService = userTrackService;
    }

    @GetMapping("/{userId}/tracks")
    public List<TrackResponse> getUserTracks(@PathVariable Long userId) {
        return userTrackService.getUserTracks(userId);
    }

    @PostMapping("/{userId}/tracks")
    public ResponseEntity<?> saveTrack(@RequestBody Track track, @PathVariable Long userId) throws ParseException {
        return userTrackService.saveUserTrack(track.getTrackId(), userId);
    }

    @DeleteMapping("/{userId}/tracks")
    public ResponseEntity<?> deleteTrack(@RequestParam(name = "id") Long trackId, @PathVariable Long userId){
        return userTrackService.deleteTrack(trackId, userId);
    }
}
