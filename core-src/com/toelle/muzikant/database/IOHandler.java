package com.toelle.muzikant.database;

import com.toelle.muzikant.model.Song;

import java.io.IOException;
import java.util.List;

/**
 * Provides accesss to all Song files that are in the current Song Database. It
 * is up to the implementation of this interface how exactly this database
 * should look like and how it is implemented.
 */
public interface IOHandler {

    /**
     * Inserts the given Song into the database and writes it to disk.
     *
     * @param song the song to be saved
     * @throws IOException
     */
    void put(Song song) throws IOException;

    /**
     * Inserts the given list of Songs into the database and writes all of them
     * to the disk.
     *
     * @param songs a list of songs to be saved
     * @throws IOException
     */
    void put(List<Song> songs) throws IOException;

    /**
     * Returns a List of all Songs that are in the current database.
     * The meta information of every song is included as much as possible.
     *
     * @return all Songs in database
     * @throws IOException
     */
    List<Song> getAll() throws IOException;
}
