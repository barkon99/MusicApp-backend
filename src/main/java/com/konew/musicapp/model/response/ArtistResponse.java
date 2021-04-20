package com.konew.musicapp.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ArtistResponse
{
    private Long id;
    private String name;
    private String deezerLink;
    private String image;
    private List<TrackResponse> tracks;
    private Long deezerId;
}
