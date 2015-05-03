package com.toelle.muzikant.database;

import com.toelle.muzikant.exception.PreferenceNotSetException;
import com.toelle.muzikant.model.Album;
import com.toelle.muzikant.model.Artist;
import com.toelle.muzikant.model.Song;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;
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
    public List<Artist> get() throws IOException {
        Path musicRoot = libraryRoot.resolve("./Music/");
        File musicFile = musicRoot.toFile();

        List<Artist> artistList = getTreeElement(musicFile, this::getArtist);

        return artistList;
    }

    private Song getSong(File songFile) {

    }

    private Album getAlbum(File albumFile) {
        List<Song> songList = getTreeElement(albumFile, this::getSong);

        String albumName = albumFile.getName();



        //return new Album(albumName, albumArtwork, year, songList);
    }

    private Artist getArtist(File artistFile) {
        List<Album> albumList = getTreeElement(artistFile, this::getAlbum);

        String artistName = artistFile.getName();
        return new Artist(artistName, albumList);
    }


    private <T> List<T> getTreeElement(File file, Function<? super File, ? extends T> mapper) {
        return Arrays.stream(file.listFiles())
                .filter(File::isDirectory)
                .map(mapper)
                .collect(Collectors.toList());
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
