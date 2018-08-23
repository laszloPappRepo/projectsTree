package com.gemini.KatalogApp.model;

import java.awt.*;

public class CollectionEntity {

    String title;
    Image cover;

    public CollectionEntity() {
    }

    public CollectionEntity(String title, Image cover) {
        this.title = title;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getCover() {
        return cover;
    }

    public void setCover(Image cover) {
        this.cover = cover;
    }
}
