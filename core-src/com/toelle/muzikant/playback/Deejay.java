package com.toelle.muzikant.playback;

import com.toelle.muzikant.model.Song;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Deejay implements Observer {

    private Plattenspieler plattenspieler;

    private List<Song> queue;
    private int currentSong;

    private boolean randomMode = false;

    public Deejay(Plattenspieler plattenspieler) {
        this.plattenspieler = plattenspieler;
        plattenspieler.addObserver(this);
    }

    public void add(List<Song> songs) {
        if(randomMode) {
            Collections.shuffle(songs);
        }
        queue.addAll(songs);
    }

    public boolean getRandom() {
        return randomMode;
    }

    public void setRandom(boolean mode) {
        this.randomMode = mode;

        if(getRandom()) {
            shuffleFutureSongs();
        }
    }

    public void toggleRandom() {
        setRandom(!getRandom());
    }

    private void shuffleFutureSongs() {
        Collections.shuffle(queue.subList(currentSong + 1, queue.size()));
    }

    public void emptyQueue() {
        queue.subList(currentSong + 1, queue.size()).clear();
    }

    protected void changeCurrentSong(int delta) throws IndexOutOfBoundsException {
        if(currentSong + delta < 0) {
            throw new IndexOutOfBoundsException("Already first song playing, cant play previous song");
        } else if(currentSong + delta >= queue.size()) {
            throw new IndexOutOfBoundsException("Already last song playing, cant play next song");
        } else {
            this.currentSong += delta;
        }
    }

    /**
     * Will only return future entries and not earlier ones
     */
    public List<Song> getQueue() {
        return queue.subList(currentSong + 1, queue.size());
    }

    public void next() {
        changeCurrentSong(1);
        play();
    }

    public void previous() {
        if(plattenspieler.getPositionInSong() < 4) {
            changeCurrentSong(-1);
        } else {
            play(); //Restart the song basically
        }
    }

    public void update(Observable o, Object arg) {
        if( arg.equals(PlaybackState.ENDED) ) {
            next();
        }
    }

    public void resume () {
        plattenspieler.resume();
    }

    public void pause() {
        plattenspieler.pause();
    }

    public void play() {
        plattenspieler.play(queue.get(currentSong));
    }

    public PlaybackState getSpielerState() {
        return plattenspieler.getState();
    }
}
