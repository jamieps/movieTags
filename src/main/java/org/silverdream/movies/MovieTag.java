package org.silverdream.movies;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.List;

/**
 * Print relevant tags for a movie.
 */
public class MovieTag {
    private Gson gson = new Gson();

    /**
     * Initial entry point.
     * @param args
     */
    public static void main(String[] args) {
        int numTags = 0;

        if (args.length > 0) {
            try {
                numTags = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid number: " + args[0] +
                        ", returning all tags");
            }
        }

        new MovieTag(numTags);
    }

    public MovieTag(int numTags) {
        String movieName    = "The Interview";
        String year         = "2014";
        List<String> tags   = getMovie(movieName, year).getTags();

        if (numTags > 0 && numTags <= tags.size()) {
            tags.subList(0, numTags).forEach(System.out::println);
        } else {
            tags.forEach(System.out::println);
        }
    }

    /**
     * Get details of a given movie.
     *
     * @param movieName     the movie to query for
     * @param year          the year of release
     * @return  a {@link Movie} object or null if no match is found
     * @throws  IllegalStateException   if the OMDB API is unavailable
     */
    public Movie getMovie(String movieName, String year) {
        // TODO: Should sanitise input
        String uri          = OmdbAPI.getMovieURI(movieName, year);
        HttpGet httpGet     = new HttpGet(uri);
        String responseBody;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                        throws IOException {
                    int statusCode = response.getStatusLine().getStatusCode();
                    if (statusCode >= 200 && statusCode < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new IllegalStateException("Unexpected " +
                                "response from OMDB API, HTTP response code: " +
                                statusCode);
                    }
                }
            };
            responseBody = httpClient.execute(httpGet, responseHandler);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to retrieve data from OMDB API: " + ioe);
        }

        return gson.fromJson(responseBody, Movie.class);
    }
}
