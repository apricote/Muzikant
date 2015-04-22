package com.toelle.muzikant;

import com.toelle.muzikant.database.DesktopIOHandler;
import com.toelle.muzikant.manager.MusicLibrary;
import com.toelle.muzikant.manager.Song;
import com.toelle.muzikant.playback.Deejay;
import com.toelle.muzikant.playback.DesktopPlattenspieler;


public class Main {
    public static void main(String[] args) {
        MusicLibrary ml = new MusicLibrary(new DesktopIOHandler());
        Deejay dj = new Deejay(new DesktopPlattenspieler());
        Song song = new Song(null, null, null, null);
    }

}
