package com.gemini.KatalogApp.model;

public class NotFoundException {

    private String error;

    public NotFoundException() {
    }

    public NotFoundException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
