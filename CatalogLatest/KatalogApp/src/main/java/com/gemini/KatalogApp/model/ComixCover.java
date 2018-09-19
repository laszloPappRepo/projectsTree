package com.gemini.KatalogApp.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class ComixCover {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    public String title;
    @Column(name="COMICCOVER", nullable=false, columnDefinition = "LONGBLOB")
    public byte[] comicCover;
    public String publisher;
    public Boolean readed = false;
    @Column(name = "description")
    @Type(type="text")
    public String description;

    public ComixCover(Long id, String title, byte[] comicCover, String description) {
        this.id = id;
        this.title = title;
        this.comicCover = comicCover;
        this.publisher = "unknown";
        this.description = description;
    }

    public ComixCover() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getComicCover() {
        return comicCover;
    }

    public void setComicCover(byte[] comicCover) {
        this.comicCover = comicCover;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
