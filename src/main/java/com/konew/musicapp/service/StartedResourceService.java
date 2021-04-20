package com.konew.musicapp.service;

import com.konew.musicapp.model.deezer.popularResources.Album;
import com.konew.musicapp.model.deezer.popularResources.Artist;
import com.konew.musicapp.model.deezer.popularResources.Playlist;
import com.konew.musicapp.model.deezer.popularResources.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class StartedResourceService implements CommandLineRunner
{
    private Map<String, Object> startedResource;
    private DeezerService deezerService;

    @Autowired
    public StartedResourceService(DeezerService deezerService) {
        this.deezerService = deezerService;
    }

    public Map<String, Object> getStartedResource() {
        return startedResource;
    }

    @Override
    public void run(String... args) throws Exception {
        startedResource = new HashMap<>();
        long start = System.currentTimeMillis();
        CompletableFuture<Track> tracks = deezerService.getResources("tracks", new ParameterizedTypeReference<Track>() {
        });
        CompletableFuture<Artist> artists = deezerService.getResources("artists", new ParameterizedTypeReference<Artist>(){});
        CompletableFuture<Album> albums = deezerService.getResources("albums", new ParameterizedTypeReference<Album>(){});
        CompletableFuture<Playlist> playlists = deezerService.getResources("playlists", new ParameterizedTypeReference<Playlist>(){});
        CompletableFuture.allOf(tracks,artists,albums, playlists).join();
        startedResource.put("tracks", tracks.get());
        startedResource.put("artists", artists.get());
        startedResource.put("albums", albums.get());
        startedResource.put("playlists", playlists.get());
        System.out.println((System.currentTimeMillis() - start));
    }
}
