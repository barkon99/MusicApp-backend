
package com.konew.musicapp.model.deezer.popularResources;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "title_short",
    "title_version",
    "link",
    "duration",
    "rank",
    "explicit_lyrics",
    "explicit_content_lyrics",
    "explicit_content_cover",
    "preview",
    "md5_image",
    "position",
    "artist",
    "album",
    "type"
})
public class Track {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_short")
    private String titleShort;
    @JsonProperty("title_version")
    private String titleVersion;
    @JsonProperty("link")
    private String link;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("explicit_lyrics")
    private Boolean explicitLyrics;
    @JsonProperty("explicit_content_lyrics")
    private Integer explicitContentLyrics;
    @JsonProperty("explicit_content_cover")
    private Integer explicitContentCover;
    @JsonProperty("preview")
    private String preview;
    @JsonProperty("md5_image")
    private String md5Image;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("artist")
    private Artist artist;
    @JsonProperty("album")
    private Album album;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("title_short")
    public String getTitleShort() {
        return titleShort;
    }

    @JsonProperty("title_short")
    public void setTitleShort(String titleShort) {
        this.titleShort = titleShort;
    }

    @JsonProperty("title_version")
    public String getTitleVersion() {
        return titleVersion;
    }

    @JsonProperty("title_version")
    public void setTitleVersion(String titleVersion) {
        this.titleVersion = titleVersion;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("explicit_lyrics")
    public Boolean getExplicitLyrics() {
        return explicitLyrics;
    }

    @JsonProperty("explicit_lyrics")
    public void setExplicitLyrics(Boolean explicitLyrics) {
        this.explicitLyrics = explicitLyrics;
    }

    @JsonProperty("explicit_content_lyrics")
    public Integer getExplicitContentLyrics() {
        return explicitContentLyrics;
    }

    @JsonProperty("explicit_content_lyrics")
    public void setExplicitContentLyrics(Integer explicitContentLyrics) {
        this.explicitContentLyrics = explicitContentLyrics;
    }

    @JsonProperty("explicit_content_cover")
    public Integer getExplicitContentCover() {
        return explicitContentCover;
    }

    @JsonProperty("explicit_content_cover")
    public void setExplicitContentCover(Integer explicitContentCover) {
        this.explicitContentCover = explicitContentCover;
    }

    @JsonProperty("preview")
    public String getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(String preview) {
        this.preview = preview;
    }

    @JsonProperty("md5_image")
    public String getMd5Image() {
        return md5Image;
    }

    @JsonProperty("md5_image")
    public void setMd5Image(String md5Image) {
        this.md5Image = md5Image;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("artist")
    public Artist getArtist() {
        return artist;
    }

    @JsonProperty("artist")
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @JsonProperty("album")
    public Album getAlbum() {
        return album;
    }

    @JsonProperty("album")
    public void setAlbum(Album album) {
        this.album = album;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
