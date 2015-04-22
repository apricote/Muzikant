package com.toelle.muzikant.manager;

import com.toelle.muzikant.database.IOHandler;

import java.util.List;
import java.util.function.Predicate;

public class MusicLibrary {

    private List<Song> musiclibrary;

    private IOHandler ioHandler;

    public List<Song> search(Predicate<? super Song> predicate) {
        return null;
    }

    public MusicLibrary(IOHandler ioHandler) {
    }

}
