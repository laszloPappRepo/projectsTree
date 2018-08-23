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

    public ComixCover(String title, byte[] cover) {
        this.title = title;
        this.cover = cover;
    }

    public ComixCover() {
    }

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
}
