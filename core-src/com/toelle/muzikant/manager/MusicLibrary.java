package com.toelle.muzikant.manager;

import com.toelle.muzikant.database.IOHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MusicLibrary {

    private List<Song> musiclibrary;

    private IOHandler ioHandler;

    public MusicLibrary(IOHandler ioHandler) throws IOException {
        this.ioHandler = ioHandler;
        this.musiclibrary = ioHandler.get();
    }

    public List<Song> search(Predicate<? super Song> predicate) {
        return musiclibrary.parallelStream()
                            .filter(predicate)
                            .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<TagElement> getDistinctTags(Function<? super Song, TagElement> mapper) {
        return musiclibrary.parallelStream()
                            .map(mapper)
                            .distinct()
                            .collect(Collectors.toCollection(ArrayList::new));
    }

}
