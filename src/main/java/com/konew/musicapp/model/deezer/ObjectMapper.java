package com.konew.musicapp.model.deezer;

import com.konew.musicapp.model.deezer.Track;
import com.konew.musicapp.model.deezer.artistTracks.ArtistTracks;
import com.konew.musicapp.model.deezer.artistTracks.Datum;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper
{
    public static List<Track> mapToTrackObject(List<Datum> dataList){
        return dataList.stream()
                .map(datum -> Track.builder()
                        .id(datum.getId())
                        .preview(datum.getPreview())
                        .title(datum.getTitle())
                        .artist(mapToArtistObject(datum.getArtist()))
                        .md5Image(datum.getContributors().stream().map(x -> x.getPictureMedium()).findFirst().get())
                        .build())
                .collect(Collectors.toList());
    }
    private static Artist mapToArtistObject(com.konew.musicapp.model.deezer.artistTracks.Artist artist){
        return Artist.builder()
                .id(artist.getId())
                .name(artist.getName())
                .build();
    }
}
