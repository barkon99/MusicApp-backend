package com.konew.musicapp.controller;

import com.konew.musicapp.model.deezer.Track;
import com.konew.musicapp.model.deezer.popularResources.Chart;
import com.konew.musicapp.service.DeezerService;
import com.konew.musicapp.service.StartedResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DeezerController
{
    DeezerService deezerService;
    StartedResourceService startedResourceService;

    @Autowired
    public DeezerController(DeezerService deezerService, StartedResourceService startedResourceService) {
        this.deezerService = deezerService;
        this.startedResourceService = startedResourceService;
    }

    @GetMapping("/tracks/{id}")
    public Track getTrack(@PathVariable Long id) {
        return deezerService.getTrack(id);
    }

    @GetMapping("/tracks/chart/{limit}")
    public Chart getTracks(@PathVariable int limit) {
        return deezerService.getTracks(limit);
    }

    @GetMapping("/artist/{artistId}/tracks")
    public List<Track> getArtistTracks(@PathVariable Long artistId, @RequestParam(name = "limit") int limit) {
        return deezerService.getArtistTracks(artistId, limit);
    }
    @GetMapping("/tracks/chart")
    public Map<String, Object> getResources() {
        return startedResourceService.getStartedResource();
    }
}
