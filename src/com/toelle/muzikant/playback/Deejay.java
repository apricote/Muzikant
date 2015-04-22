package com.toelle.muzikant.playback;

import com.toelle.muzikant.manager.Song;

import java.util.List;
import java.util.Observable;

public class Deejay {

    private Plattenspieler plattenspieler;

    private List<Song> queue;

    private boolean randomMode = false;

    public Deejay(Plattenspieler plattenspieler) {
    }

    public void resume() {
    }

    public void pause() {
    }

    public PlaybackState getSpielerState() {
        return null;
    }

    public void add(List<Song> songs) {
    }

    public boolean getRandomMode() {
        return false;
    }

    public void setRandomMode(boolean mode) {
    }

    /**
     * Will only return future entries and not earlier ones
     */
    public void emptyQueue() {
    }

    public List<Song> getQueue() {
        return null;
    }

    public void newOperation() {
    }

    public void next() {
    }

    public void previous() {
    }

    public void update(Observable o, Object arg) {
    }

}
