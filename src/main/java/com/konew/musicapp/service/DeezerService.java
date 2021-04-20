package com.konew.musicapp.service;

import com.konew.musicapp.model.deezer.Artist;
import com.konew.musicapp.model.deezer.ObjectMapper;
import com.konew.musicapp.model.deezer.Track;
import com.konew.musicapp.model.deezer.artistTracks.ArtistTracks;
import com.konew.musicapp.model.deezer.popularResources.Chart;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DeezerService
{
    private static final String DEEZER_URL = "https://api.deezer.com/";
    private RestTemplate restTemplate = new RestTemplate();


    public Track getTrack(Long id){
        return callGetMethod("track/" + id, Track.class);
    }
    public Artist getArtist(Long id){
        return callGetMethod("artist/" + id, Artist.class);
    }
    private <T> T callGetMethod(String endOfUrl, Class<T> responseType){
        return restTemplate.exchange(DEEZER_URL + endOfUrl,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                responseType).getBody();
    }

    public Chart getTracks(int limit){
        ResponseEntity<Chart> responseEntity = restTemplate.exchange("https://api.deezer.com/chart/?limit="+ limit,
                HttpMethod.GET, null, Chart.class);


        return responseEntity.getBody();
    }

    @Async
    public <T> CompletableFuture<T> getResources(String type, ParameterizedTypeReference<T> responseType){
        return CompletableFuture.completedFuture(restTemplate.exchange("https://api.deezer.com/chart/0/"+type+"/?limit=5",
                HttpMethod.GET, null, responseType).getBody());

    }

    public Track getSearchedTrack(String title, int limit){
        return callGetMethod("search/track?q=" + title + "&limit=" + limit, Track.class);
    }


    public Artist getSearchedArtist(String name, int limit)
    {
        return callGetMethod("search/artist?q=" + name + "&limit=" + limit, Artist.class);
    }
    public List<Track> getArtistTracks(Long artistId, int limit)
    {
        ArtistTracks artistTracks = callGetMethod("artist/" + artistId + "/top?limit=" + limit, ArtistTracks.class);
        List<Track> mappedArtistTracks = ObjectMapper.mapToTrackObject(artistTracks.getData());
        return mappedArtistTracks;
    }
}
