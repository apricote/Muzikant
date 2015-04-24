package com.toelle.muzikant.playback;

import com.toelle.muzikant.manager.Song;

import java.util.Observable;

public abstract class Plattenspieler extends Observable {

    private Song presentSong;

    private double positionInSong; // in Seconds

    private PlaybackState state;

    public abstract void resume();

    public abstract void play(Song song);

    public abstract void pause();

    protected Song getSong() {
        return presentSong;
    }

    protected void setSong(Song newSong) {
        this.presentSong = newSong;
    }

    public double getPositionInSong() {
        return positionInSong;
    }

    protected void setPositionInSong(double newPosition) throws IndexOutOfBoundsException {
        positionInSong = newPosition;
    }

    public PlaybackState getState() {
        return state;
    }

    protected void setState(PlaybackState newState) {
        this.state = newState;

        setChanged();
        notifyObservers(newState);
    }

}
