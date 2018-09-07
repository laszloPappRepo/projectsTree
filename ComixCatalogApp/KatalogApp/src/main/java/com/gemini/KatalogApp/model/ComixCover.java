package com.gemini.KatalogApp.model;

import javax.persistence.*;

@Entity
public class ComixCover {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(name="COVER", nullable=false, columnDefinition = "LONGBLOB")
    private byte[] cover;
    private String publisher = "unknown";
    public Boolean done = false;

    public ComixCover(String title, byte[] cover, String publisher, Boolean done) {
        this.title = title;
        this.cover = cover;
        this.publisher = publisher;
        this.done = done;
    }

    public ComixCover() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public Long getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
