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

    public Song(File file, String title, String artist, String Album) {
    }

    public Song(File file, String title, String artist, String Album, int Year, int numberInAlbum, int numberOfCD, Artwork artwork) {
    }

    public File getFile() {
        return null;
    }

    public String getTitle() {
        return null;
    }

    public void setTitle(String title) {
    }

    public String getArtist() {
        return null;
    }

    public void setArtist(String artist) {
    }

    public String getAlbum() {
        return null;
    }

    public void setAlbum(String album) {
    }

    public int getYear() {
        return 0;
    }

    public void setYear(int year) {
    }

    public int getNumberInAlbum() {
        return 0;
    }

    public void setNumberInAlbum(int noInAlbum) {
    }

    public int getNumberOfCD() {
        return 0;
    }

    public void setNumberOfCD(int noOfCD) {
    }

    public Artwork getArtwork() {
        return null;
    }

    public void setArtwork(Artwork artwork) {
    }

}
