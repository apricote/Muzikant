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
import java.util.stream.Collectors;

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
    public List<Song> getAll() throws IOException {
        Path musicRoot = libraryRoot.resolve("./Music/");
        File musicFile = musicRoot.toFile();

        List<Song> songList = Arrays.stream(musicFile.listFiles())
                .filter(File::isDirectory) // Stream of all Artists
                .map(File::listFiles)
                .flatMap(Arrays::stream)
                .filter(File::isDirectory) //Stream of all Albums
                .map(File::listFiles)
                .flatMap(Arrays::stream) // Stream of all Song Files
                .map(songFile -> {
                    String songString = songFile.getName();
                    Song newSong = new Song(songFile, songString);
                    Path songPath = songFile.toPath();
                    String albumString = songPath.getName(songPath.getNameCount() - 1).getFileName().toString();
                    newSong.setAlbumName(albumString);
                    String artistString = songPath.getName(songPath.getNameCount() - 2).getFileName().toString();
                    newSong.setArtistName(artistString);
                    return newSong;
                })
                .collect(Collectors.toList());

        return songList;
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
