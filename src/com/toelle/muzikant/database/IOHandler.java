package com.toelle.muzikant.database;

import com.toelle.muzikant.manager.Song;

import java.util.List;

public interface IOHandler {

    void put(Song song);

    void put(List<Song> songs);

    List<Song> get();

}
