package org.silverdream.movies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Utility methods and constants
 */
public class Util {
    /**
     * Regular expression to match most punctuation characters
     */
    public static final String PUNCTUATION_REGEX = "[,\\\\.;:\\\\\\(\\\\)\\\\[\\\\]\\\\\"]+";

    /**
     * Words to exclude
     */
    public static final List<String> STOP_WORDS = new ArrayList<String>() {
        {
            add("a");
            add("about");
            add("above");
            add("after");
            add("again");
            add("against");
            add("all");
            add("am");
            add("an");
            add("and");
            add("any");
            add("are");
            add("aren't");
            add("as");
            add("at");
            add("be");
            add("because");
            add("been");
            add("before");
            add("being");
            add("below");
            add("between");
            add("both");
            add("but");
            add("by");
            add("can't");
            add("cannot");
            add("could");
            add("couldn't");
            add("did");
            add("didn't");
            add("do");
            add("does");
            add("doesn't");
            add("doing");
            add("don't");
            add("down");
            add("during");
            add("each");
            add("few");
            add("for");
            add("from");
            add("further");
            add("had");
            add("hadn't");
            add("has");
            add("hasn't");
            add("have");
            add("haven't");
            add("having");
            add("he");
            add("he'd");
            add("he'll");
            add("he's");
            add("her");
            add("here");
            add("here's");
            add("hers");
            add("herself");
            add("him");
            add("himself");
            add("his");
            add("how");
            add("how's");
            add("i");
            add("i'd");
            add("i'll");
            add("i'm");
            add("i've");
            add("if");
            add("in");
            add("into");
            add("is");
            add("isn't");
            add("it");
            add("it's");
            add("its");
            add("itself");
            add("let's");
            add("me");
            add("more");
            add("most");
            add("mustn't");
            add("my");
            add("myself");
            add("no");
            add("nor");
            add("not");
            add("of");
            add("off");
            add("on");
            add("once");
            add("only");
            add("or");
            add("other");
            add("ought");
            add("our");
            add("ours");
            add("ourselves");
            add("out");
            add("over");
            add("own");
            add("same");
            add("shan't");
            add("she");
            add("she'd");
            add("she'll");
            add("she's");
            add("should");
            add("shouldn't");
            add("so");
            add("some");
            add("such");
            add("than");
            add("that");
            add("that's");
            add("the");
            add("their");
            add("theirs");
            add("them");
            add("themselves");
            add("then");
            add("there");
            add("there's");
            add("these");
            add("they");
            add("they'd");
            add("they'll");
            add("they're");
            add("they've");
            add("this");
            add("those");
            add("through");
            add("to");
            add("too");
            add("under");
            add("until");
            add("up");
            add("very");
            add("was");
            add("wasn't");
            add("we");
            add("we'd");
            add("we'll");
            add("we're");
            add("we've");
            add("were");
            add("weren't");
            add("what");
            add("what's");
            add("when");
            add("when's");
            add("where");
            add("where's");
            add("which");
            add("while");
            add("who");
            add("who's");
            add("whom");
            add("why");
            add("why's");
            add("with");
            add("won't");
            add("would");
            add("wouldn't");
            add("you");
            add("you'd");
            add("you'll");
            add("you're");
            add("you've");
            add("your");
            add("yours");
            add("yourself");
            add("yourselves");
        }
    };

    /**
     * Do not allow construction.
     */
    private Util() {
    }

    /**
     * Sort a map by its values, using those values comparator.
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>>
            entriesSortedByValues(Map<K,V> map) {
        List<Map.Entry<K, V>> sortedEntries = new ArrayList<>(map.entrySet());

        // Sort in descending order
        Collections.sort(sortedEntries,
                (Map.Entry<K, V> entry1, Map.Entry<K, V> entry2) ->
                        entry2.getValue().compareTo(entry1.getValue()));

        return sortedEntries;
    }
}
