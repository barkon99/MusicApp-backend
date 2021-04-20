package com.konew.musicapp.controller;

import com.konew.musicapp.model.response.Artist;
import com.konew.musicapp.model.response.ArtistResponse;
import com.konew.musicapp.service.UserArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserArtistController
{
    UserArtistService userArtistService;

    public UserArtistController(UserArtistService userArtistService) {
        this.userArtistService = userArtistService;
    }

    @GetMapping("/{userId}/artists")
    public List<ArtistResponse> getUserArtists(@PathVariable Long userId) {
        return userArtistService.getUserArtists(userId);
    }

    @PostMapping("/{userId}/artists")
    public ResponseEntity<?> saveArtist(@RequestBody Artist artist, @PathVariable Long userId){
        return userArtistService.saveUserArtist(artist.getArtistId(), userId);
    }
    @DeleteMapping("/{userId}/artists")
    public ResponseEntity<?> deleteArtist(@RequestParam(name = "id") Long artistId, @PathVariable Long userId){
        return userArtistService.deleteArtist(artistId, userId);
    }
}
