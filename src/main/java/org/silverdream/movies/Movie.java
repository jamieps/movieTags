package org.silverdream.movies;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Represents a movie and contains summary information, e.g. the title and plot.
 */
public class Movie {
    private String Title;
    private String Plot;

    /**
     * The title of the movie.
     *
     * @return  the movie title
     */
    public String getTitle() {
        return this.Title;
    }

    /**
     * A full plot summary.
     *
     * @return  the plot
     */
    public String getPlot() {
        return this.Plot;
    }

    /**
     * The relevant phrases for this movie.
     *
     * @return  a list of tags, in descending order of importance
     */
    public List<String> getTags() {
        // Convert to lowercase, remove most punctuation
        Stream<String> wordStream = Stream.of(getPlot()
                .toLowerCase()
                .replaceAll(Util.PUNCTUATION_REGEX, "")
                .split(" "))
                .parallel();

        // Count the number of times each keyword appears
        TreeMap<String, Long> keywordCounts = wordStream
                .filter(word -> !Util.STOP_WORDS.contains(word))
                .parallel()
                .collect(groupingBy(identity(), TreeMap::new, counting()));

        // Sort by counts
        List<Map.Entry<String, Long>> sortedEntries =
                Util.entriesSortedByValues(keywordCounts);

        // Return just the tags, in descending order
        return sortedEntries.stream().map(Map.Entry::getKey)
                .parallel()
                .collect(Collectors.toList());
    }
}
