package com.toelle.muzikant.model;

import java.io.File;

public class Song {

    private File file;
    private String title;
    private int numberInAlbum;
    private int numberOfCD;

    private String albumName;
    private Artwork artwork;
    private int albumYear;

    private String artistName;

    public Song(File file, String title) {
        this.file = file;
        this.title = title;
    }

    public Song(File file, String title, int numberInAlbum, int numberOfCD) {
        this(file, title);
        this.numberInAlbum = numberInAlbum;
        this.numberOfCD = numberOfCD;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

    public int getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(int albumYear) {
        this.albumYear = albumYear;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
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
}
