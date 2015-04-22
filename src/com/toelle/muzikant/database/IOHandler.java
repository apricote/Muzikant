package com.toelle.muzikant.database;

import com.toelle.muzikant.manager.Song;

import java.util.List;

public interface IOHandler {

  public void put(Song song);

  public void put(List<Song> songs);

  public List<Song> get();

}
