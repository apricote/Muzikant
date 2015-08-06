package com.toelle.muzikant.manager;

import com.toelle.muzikant.database.IOHandler;
import com.toelle.muzikant.model.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class manages a List of Songs and offers methods to search through it.
 */
public class MusicLibrary {

    private List<Song> musiclibrary;

    private IOHandler ioHandler;

    /**
     * Instantiate a new MusicLibrary with the given IOHandler. The IOHandler
     * will be used to retrieve all Songs from Database.
     *
     * @param ioHandler the IOHandler that should be used
     * @throws IOException
     */
    public MusicLibrary(IOHandler ioHandler) throws IOException {
        this.ioHandler = ioHandler;
        this.musiclibrary = ioHandler.getAll();
    }

    /**
     * Lets you search through the list of Songs based on the given
     * <code>predicate</code>.
     *
     * Example:
     * <pre>
     * <code>MusicLibrary ml = new MusicLibrary(new IOHandler());
     *
     * ml.search(s -> s.getAlbumName() == "Mutter"); // Returns all Songs that are in an Album called "Mutter"
     *
     * ml.search(s -> s.getTitle().contains("Submarine")); // Returns all Songs whose title contains the String "Submarine"</code></pre>
     * @param predicate the predicate that should be used for search
     * @return a list of Songs that match the predicate
     */
    public List<Song> search(Predicate<? super Song> predicate) {
        return musiclibrary.parallelStream()
                            .filter(predicate)
                            .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Maps all the Songs into distinct tags based on the given Mapping function.
     *
     * Example:
     * <pre>
     * <code>MusicLibrary ml = new MusicLibrary(new IOHandler());
     *
     * List{@code<String>} artists = ml.getDistinctTags(s -> s.getArtistName()); // Returns a List of all Artists in the Music Library
     * </code></pre>
     *
     * <b>Warning</b>: Should not be used to get distinct lists of Songnames or
     * Albumnames as two different Songs/Albums by different Artists can be
     * named the same and still be two distinct Entities. <b>In that case this
     * method will only return one entry.</b>
     *
     * @param mapper the function to modify the Songstream (e.g. turn it into Artist Strings)
     * @param <T> The type of the resulting List (e.g. String in case of Artist)
     * @return A list of distinct tags
     */
    public <T> List<T> getDistinctTags(Function<? super Song, T> mapper) {
        return musiclibrary.parallelStream()
                            .map(mapper)
                            .distinct()
                            .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Does a full text search on all String Tags of a Song.
     *
     * @param query what should be searched for
     * @return a list of Songs whose tags contain the query string
     */
    public List<Song> searchAllTags(String query) {
        return search(s ->
            s.getTitle().contains(query)
                || s.getArtistName().contains(query)
                || s.getAlbumName().contains(query)
        );
    }

}
