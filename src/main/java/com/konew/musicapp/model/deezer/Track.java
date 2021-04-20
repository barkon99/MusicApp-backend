
package com.konew.musicapp.model.deezer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.konew.musicapp.model.deezer.Album;
import com.konew.musicapp.model.deezer.Artist;
import com.konew.musicapp.model.deezer.Contributor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "readable",
    "title",
    "title_short",
    "title_version",
    "isrc",
    "link",
    "share",
    "duration",
    "track_position",
    "disk_number",
    "rank",
    "release_date",
    "explicit_lyrics",
    "explicit_content_lyrics",
    "explicit_content_cover",
    "preview",
    "bpm",
    "gain",
    "contributors",
    "md5_image",
    "artist",
    "album",
    "type"
})
public class Track {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("readable")
    private Boolean readable;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_short")
    private String titleShort;
    @JsonProperty("title_version")
    private String titleVersion;
    @JsonProperty("isrc")
    private String isrc;
    @JsonProperty("link")
    private String link;
    @JsonProperty("share")
    private String share;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("track_position")
    private Integer trackPosition;
    @JsonProperty("disk_number")
    private Integer diskNumber;
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("explicit_lyrics")
    private Boolean explicitLyrics;
    @JsonProperty("explicit_content_lyrics")
    private Integer explicitContentLyrics;
    @JsonProperty("explicit_content_cover")
    private Integer explicitContentCover;
    @JsonProperty("preview")
    private String preview;
    @JsonProperty("bpm")
    private Double bpm;
    @JsonProperty("gain")
    private Double gain;
    @JsonProperty("contributors")
    private List<Contributor> contributors;
    @JsonProperty("md5_image")
    private String md5Image;
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

    @JsonProperty("readable")
    public Boolean getReadable() {
        return readable;
    }

    @JsonProperty("readable")
    public void setReadable(Boolean readable) {
        this.readable = readable;
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

    @JsonProperty("isrc")
    public String getIsrc() {
        return isrc;
    }

    @JsonProperty("isrc")
    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("share")
    public String getShare() {
        return share;
    }

    @JsonProperty("share")
    public void setShare(String share) {
        this.share = share;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("track_position")
    public Integer getTrackPosition() {
        return trackPosition;
    }

    @JsonProperty("track_position")
    public void setTrackPosition(Integer trackPosition) {
        this.trackPosition = trackPosition;
    }

    @JsonProperty("disk_number")
    public Integer getDiskNumber() {
        return diskNumber;
    }

    @JsonProperty("disk_number")
    public void setDiskNumber(Integer diskNumber) {
        this.diskNumber = diskNumber;
    }

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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

    @JsonProperty("bpm")
    public Double getBpm() {
        return bpm;
    }

    @JsonProperty("bpm")
    public void setBpm(Double bpm) {
        this.bpm = bpm;
    }

    @JsonProperty("gain")
    public Double getGain() {
        return gain;
    }

    @JsonProperty("gain")
    public void setGain(Double gain) {
        this.gain = gain;
    }

    @JsonProperty("contributors")
    public List<Contributor> getContributors() {
        return contributors;
    }

    @JsonProperty("contributors")
    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    @JsonProperty("md5_image")
    public String getMd5Image() {
        return md5Image;
    }

    @JsonProperty("md5_image")
    public void setMd5Image(String md5Image) {
        this.md5Image = md5Image;
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
