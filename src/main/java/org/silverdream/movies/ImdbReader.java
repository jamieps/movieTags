package org.silverdream.movies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamie on 02/05/17.
 */
public class ImdbReader {
    private String movieName = "";
    private String lastMovie = "";
    private Pattern pattern = Pattern.compile("^MV: (.*)");
    private List<String> input = new ArrayList<>();

    public ImdbReader(String movie) {
        this.movieName = movie;
    }

    public void readData(String line) {
        Matcher matcher = pattern.matcher(line);
        if (line.startsWith("MV:")) {
            if (matcher.find()) {
                lastMovie = matcher.group(1);
            }
        }
        if (lastMovie.equals(movieName) && line.startsWith("PL:")) {
            input.addAll(Arrays.asList(line.substring(4).split(" ")));
        }
    }

    public List<String> getResults() {
        return this.input;
    }
}
