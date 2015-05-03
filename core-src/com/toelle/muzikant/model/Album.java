package com.toelle.muzikant.model;

import java.util.List;

public class Album {
    private String name;
    private Artwork artwork;
    private int year;
    private List<Song> songs;

    public Album(String name, Artwork artwork, int year, List<Song> songs) {
        this.name = name;
        this.artwork = artwork;
        this.year = year;
        this.songs = songs;
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
