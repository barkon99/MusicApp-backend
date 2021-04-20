package com.konew.musicapp.model.deezer.popularResources;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"user"})
@JsonPropertyOrder({
        "id",
        "title",
        "public",
        "nb_tracks",
        "link",
        "picture",
        "picture_small",
        "picture_medium",
        "picture_big",
        "picture_xl",
        "checksum",
        "tracklist",
        "creation_date",
        "md5_image",
        "type"
})
public class Playlist {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("nb_tracks")
    private Integer nbTracks;
    @JsonProperty("link")
    private String link;
    @JsonProperty("picture")
    private String picture;
    @JsonProperty("picture_small")
    private String pictureSmall;
    @JsonProperty("picture_medium")
    private String pictureMedium;
    @JsonProperty("picture_big")
    private String pictureBig;
    @JsonProperty("picture_xl")
    private String pictureXl;
    @JsonProperty("checksum")
    private String checksum;
    @JsonProperty("tracklist")
    private String tracklist;
    @JsonProperty("creation_date")
    private String creationDate;
    @JsonProperty("md5_image")
    private String md5Image;
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

    @JsonProperty("public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    @JsonProperty("nb_tracks")
    public Integer getNbTracks() {
        return nbTracks;
    }

    @JsonProperty("nb_tracks")
    public void setNbTracks(Integer nbTracks) {
        this.nbTracks = nbTracks;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("picture")
    public String getPicture() {
        return picture;
    }

    @JsonProperty("picture")
    public void setPicture(String picture) {
        this.picture = picture;
    }

    @JsonProperty("picture_small")
    public String getPictureSmall() {
        return pictureSmall;
    }

    @JsonProperty("picture_small")
    public void setPictureSmall(String pictureSmall) {
        this.pictureSmall = pictureSmall;
    }

    @JsonProperty("picture_medium")
    public String getPictureMedium() {
        return pictureMedium;
    }

    @JsonProperty("picture_medium")
    public void setPictureMedium(String pictureMedium) {
        this.pictureMedium = pictureMedium;
    }

    @JsonProperty("picture_big")
    public String getPictureBig() {
        return pictureBig;
    }

    @JsonProperty("picture_big")
    public void setPictureBig(String pictureBig) {
        this.pictureBig = pictureBig;
    }

    @JsonProperty("picture_xl")
    public String getPictureXl() {
        return pictureXl;
    }

    @JsonProperty("picture_xl")
    public void setPictureXl(String pictureXl) {
        this.pictureXl = pictureXl;
    }

    @JsonProperty("checksum")
    public String getChecksum() {
        return checksum;
    }

    @JsonProperty("checksum")
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    @JsonProperty("tracklist")
    public String getTracklist() {
        return tracklist;
    }

    @JsonProperty("tracklist")
    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    @JsonProperty("creation_date")
    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty("creation_date")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @JsonProperty("md5_image")
    public String getMd5Image() {
        return md5Image;
    }

    @JsonProperty("md5_image")
    public void setMd5Image(String md5Image) {
        this.md5Image = md5Image;
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
