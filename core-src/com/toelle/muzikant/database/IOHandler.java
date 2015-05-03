package com.toelle.muzikant.database;

import com.toelle.muzikant.model.Artist;
import com.toelle.muzikant.model.Song;

import java.io.IOException;
import java.util.List;

public interface IOHandler {

    void put(Song song) throws IOException;

    void put(List<Song> songs) throws IOException;

    List<Artist> get() throws IOException;
}
