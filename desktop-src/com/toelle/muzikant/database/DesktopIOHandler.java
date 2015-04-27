package com.toelle.muzikant.database;

import com.toelle.muzikant.exception.PreferenceNotSetException;
import com.toelle.muzikant.model.Song;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.Preferences;
import java.util.stream.Stream;

public class DesktopIOHandler implements IOHandler {

    Path libraryRoot;
    Preferences prefs;

    @Override
    public void put(Song song) throws IOException {
        
    }

    @Override
    public void put(List<Song> songs) throws IOException {

    }

    @Override
    public List<Song> get() throws IOException {
        Path musicRoot = libraryRoot.resolve("./Music/");
        Stream<File> artistStream = getArtistStream(musicRoot);

        return null;
    }

    private Stream<File> getArtistStream(Path musicRoot) {
        return Arrays.stream(musicRoot.toFile().listFiles()).filter(File::isDirectory);
    }

    public DesktopIOHandler() throws PreferenceNotSetException, InvalidPathException {
        prefs = Preferences.userRoot().node("com.toelle.muzikant");

        String libraryRootValueName = "libraryRootPath";
        String savedLibraryRootPath = prefs.get(libraryRootValueName, null);

        if(savedLibraryRootPath == null) {
            throw new PreferenceNotSetException();
        }

        libraryRoot = Paths.get(savedLibraryRootPath);


    }
}
