package com.konew.musicapp.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class PlaylistResponse
{
    private String name;
    private String description;
    private String image;
    private List<TrackResponse> tracks;
    private Long userId;
}
