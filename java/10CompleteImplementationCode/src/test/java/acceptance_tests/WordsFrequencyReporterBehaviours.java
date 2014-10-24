package acceptance_tests;
/*
    Feature: Most Frequently Occurring Words
      As a web SEO admin
      I would like to see a list top frequently repeated words
      So that I can keep a tab of popular words
*/

import com.neomatrix369.services.WordsFrequencyReporter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordsFrequencyReporterBehaviours {

    private StringBuilder expectedList;
    private String expectedListAsString;
    private int topNumberOfWords;
    private String wordsList;

    @Test
    public void shouldReturn_A_ListOf_UniqueWordFrequencies() {
        // Given a list of words is available
        // And N number of top repeated words to print is known
        givenWordListAndTopN_is_Known(expectedList, expectedListAsString, topNumberOfWords,
                "united, states, america, north, america, south, america, africa, " +
                        "north, korea");

        // When the frequency program is executed
        String actualListAsString = whenFrequencyParseIsInvoked(topNumberOfWords, wordsList);

        // Then the top N most frequently occurring words in the list together with their frequency of
        // occurrence are printed
        // And the output is sorted in descending order by frequency of occurrence.
        assertThat("Expected a list of words with their frequency they are repeated at.",
                actualListAsString, is(equalTo(expectedListAsString)));
    }

    private void givenWordListAndTopN_is_Known(StringBuilder inExpectedList, String inExpectedListAsString, int inTopNumberOfWords, String inWordsList) {
        inExpectedList = new StringBuilder()
                .append("3 america" + "\n")
                .append("2 north" + "\n")
                .append("1 africa" + "\n");
        inExpectedListAsString = expectedList.toString();
        inTopNumberOfWords = 3;
        wordsList = inWordsList;
    }

    private String whenFrequencyParseIsInvoked(int topNumberOfWords, String wordsList) {
        WordsFrequencyReporter wordsFrequencyReporter = new WordsFrequencyReporter();
        StringBuilder actualList = wordsFrequencyReporter.parse(topNumberOfWords, wordsList);
        return actualList.toString();
    }

    /*
        Scenario: List of top repeated words sorted by frequency,
        words with same frequencies ordered in alphabetical order

            Given a list of words is available
            And N number of top repeated words to print is known
            And two or more words have the same frequencies

            When the frequency program is executed

            Then the top N most frequently occurring words in the list together with their frequency of
            occurrence are printed
            And the output is sorted in descending order by frequency of occurrence
            And the words with the same frequency are further is sorted alphabetically (ascending order)

        Example:
            Input:
                N = 3
                    and
                list = united, states, america, north, america, south, america, south, africa,
                north, korea, united kingdom, united kingdom

            Output:
                3 america
                2 north
                2 united kingdom
                2 south
    */

    @Test
    public void shouldReturn_A_ListOfWordFrequencies_OrderedByAlpha_WhenFrequenciesRepeat() {
        // Given a list of words is available
        // And N number of top repeated words to print is known
        // And two or more words have the same frequencies
        StringBuilder expectedList = new StringBuilder()
                .append("3 america" + "\n")
                .append("2 england" + "\n")
                .append("2 north" + "\n")
                .append("2 south" + "\n");
        String expectedListAsString = expectedList.toString();
        int topNumberOfWords = 4;
        String wordsList = "united, states, america, north, america, south, america, south, africa," +
                "north, korea, england, england";

        // When the frequency program is executed
        String actualListAsString = whenFrequencyParseIsInvoked(topNumberOfWords, wordsList);

        // Then the top N most frequently occurring words in the list together with their frequency
        // of occurrence are printed
        // And the output is sorted in descending order by frequency of occurrence
        // And the words with the same frequency are further is sorted alphabetically (ascending order)
        assertThat("Expected a list of words with their frequency they are repeated at.",
                actualListAsString, is(equalTo(expectedListAsString)));
    }
}