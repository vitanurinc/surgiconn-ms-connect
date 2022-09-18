package com.surgiconn.connect.media;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class MediaContainer {
    @Id
    @SequenceGenerator(
            name = "media_container_sequence",
            sequenceName = "media_container_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "media_container_sequence"
    )

    private Long id;
    private String url;
    private LocalDateTime date;
    private int type;
    private int mediaType;
    private int status;

    public MediaContainer() {
    }

    public MediaContainer(String url, LocalDateTime date, int type, int mediaType, int status) {
        this.url = url;
        this.date = date;
        this.type = type;
        this.mediaType = mediaType;
        this.status = status;
    }

    public MediaContainer(Long id, String url, LocalDateTime date, int type, int mediaType, int status) {
        this.id = id;
        this.url = url;
        this.date = date;
        this.type = type;
        this.mediaType = mediaType;
        this.status = status;
    }

    @Override
    public String toString() {
        return "MediaContainer{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", date=" + date +
                ", type=" + type +
                ", mediaType=" + mediaType +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
