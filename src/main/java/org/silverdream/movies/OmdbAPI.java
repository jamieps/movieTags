package org.silverdream.movies;

/**
 * Constants for referencing the OMDB API.
 */
public class OmdbAPI {
    /**
     * Root URL for OMDB API
     */
    public static final String OMDB_API_ROOT = "http://www.omdbapi.com/";

    /**
     * URI for movie information with full plot details.
     */
    private static String GET_MOVIE_URI = OMDB_API_ROOT + "?t=%s&y=%s&plot=full";

    /**
     * Get the URI to retrieve information on a specific movie.
     *
     * @param title the title of the movie
     * @param year  the year of release
     * @return  the URI to retrieve information using
     */
    public static final String getMovieURI(String title, String year) {
        return String.format(GET_MOVIE_URI, title.replaceAll(" ", "+"), year);
    }
}
