package com.konew.musicapp.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class TrackResponse
{
    private Long id;
    private String title;
    private String artist;
    private int deezerRanking;
    private String deezerLink;
    private Date releaseDate;
    private String mp3Url;
    private Long deezerId;
}
