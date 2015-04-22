package com.toelle.muzikant.playback;

import com.toelle.muzikant.manager.Song;

public abstract class Plattenspieler {

  private Song presentSong;

  private double positionInSong;

  private PlaybackState state;

  public Plattenspieler() {
  }

  public void resume() {
  }

  public void play(Song song) {
  }

  public void pause() {
  }

  public PlaybackState getState() {
  return null;
  }

}
