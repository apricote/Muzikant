package com.toelle.muzikant.manager;

import java.io.File;

public class Song {

    private File file;

    private String title;

    private String artist;

    private String album;

    private int year;

    private int numberInAlbum;

    private int numberOfCD;

    private Artwork artwork;

    public Song(File file, String title, String artist, String album) {
        this.file = file;
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public Song(File file, String title, String artist, String album, int year, int numberInAlbum, int numberOfCD, Artwork artwork) {
        this(file, title, artist, album);
        this.year = year;
        this.numberInAlbum = numberInAlbum;
        this.numberOfCD = numberOfCD;
        this.artwork = artwork;
    }

    public File getFile() {
        return file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberInAlbum() {
        return numberInAlbum;
    }

    public void setNumberInAlbum(int noInAlbum) {
        this.numberInAlbum = noInAlbum;
    }

    public int getNumberOfCD() {
        return numberOfCD;
    }

    public void setNumberOfCD(int noOfCD) {
        this.numberOfCD = noOfCD;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

}
