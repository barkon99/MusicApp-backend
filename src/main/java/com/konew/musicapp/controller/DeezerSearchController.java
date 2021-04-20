package com.konew.musicapp.controller;

import com.konew.musicapp.model.deezer.Artist;
import com.konew.musicapp.model.deezer.Track;
import com.konew.musicapp.service.DeezerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DeezerSearchController
{
    private DeezerService deezerService;

    public DeezerSearchController(DeezerService deezerService) {
        this.deezerService = deezerService;
    }

    @GetMapping("/track/{limit}")
    public Track getSearchedTracks(@RequestParam(name = "title") String title, @PathVariable int limit) {
        return deezerService.getSearchedTrack(title, limit);
    }
    @GetMapping("/artist/{limit}")
    public Artist getSearchedArtists(@RequestParam(name = "name") String name, @PathVariable int limit) {
        return deezerService.getSearchedArtist(name, limit);
    }
}
