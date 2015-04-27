package com.toelle.muzikant.model;

import com.toelle.muzikant.manager.Artwork;

import java.io.File;

public class Song {

    private File file;
    private String title;
    private int numberInAlbum;
    private int numberOfCD;

    public Song(File file, String title) {
        this.file = file;
        this.title = title;
    }

    public Song(File file, String title, int numberInAlbum, int numberOfCD) {
        this(file, title);
        this.numberInAlbum = numberInAlbum;
        this.numberOfCD = numberOfCD;
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
