package com.toelle.muzikant.playback;

import com.toelle.muzikant.model.Song;
import javafx.scene.media.Media;

public class DesktopPlattenspieler extends Plattenspieler {

    @Override
    public void resume() {

    }

    @Override
    public void play(Song song) {
        Media newSong = new Media(song.getFile().toURI().toString());

    }

    @Override
    public void pause() {

    }
}
