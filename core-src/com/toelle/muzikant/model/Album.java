package com.toelle.muzikant.model;

import com.toelle.muzikant.manager.Artwork;

public class Album {
    private String name;
    private Artwork artwork;
    private int year;

    public Album(String name, Artwork artwork, int year) {
        this.name = name;
        this.artwork = artwork;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
