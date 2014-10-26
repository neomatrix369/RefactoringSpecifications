package unit_tests;

import com.neomatrix369.WordsFrequencyReporter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordsFrequencyReporterBehaviours {
    private static final String SHOULD_HAVE_RETURNED_AN_EMPTY_LIST = "Should have returned an empty list";
    private static final String EMPTY_WORDS_LIST = "";
    private static final String NOT_ASSIGNED = null;
    private static final int ANY_VALID_TOP_N = 1;
    private StringBuilder expectedList;

    /*
        Scenario: Frequency report for an undefined list (null)
            Given an undefined list is available
            When the frequency program is executed
            Then an empty report is returned
    */
    @Test
    public void shouldReturnAnEmptyReportWhenANullWordList_With_AnyValueForTopN_IsPassedIn() {
        // Given
        String expectedListAsString = getWordFrequencyEmptyReport();

        // When
        String actualListAsString =
                getWordsFrequencyReportFrom(ANY_VALID_TOP_N, NOT_ASSIGNED);

        //Then
        assertThat(SHOULD_HAVE_RETURNED_AN_EMPTY_LIST,
                actualListAsString, is(equalTo(expectedListAsString)));
    }

    /*
        Scenario: Frequency report for an empty list
            Given an empty list is available
            When the frequency program is executed
            Then an empty report is returned
    */
    @Test
    public void shouldReturnAnEmptyReportWhenAnEmptyList_With_AnyValueForTopN_IsPassedIn() {
        // Given
        String expectedListAsString = getWordFrequencyEmptyReport();

        // When
        String actualListAsString =
                getWordsFrequencyReportFrom(ANY_VALID_TOP_N, EMPTY_WORDS_LIST);

        //Then
        assertThat(SHOULD_HAVE_RETURNED_AN_EMPTY_LIST,
                actualListAsString, is(equalTo(expectedListAsString)));
    }


    /*
        Scenario: Frequency report for a list with one word
            Given a list with one word is available
            When the frequency program is executed
            Then an a report containing one word (the same) is returned
    */
    @Test
    public void shouldReturnReportWithOneWordWhenAListWithASingleWord_With_AnyValueForTopN_IsPassedIn() {
        // Given
        String expectedListAsString = "1 united\n";
        String wordList = "united";

        // When
        String actualListAsString = getWordsFrequencyReportFrom(ANY_VALID_TOP_N, wordList);

        //Then
        assertThat("Should have returned a list with one word.",
                actualListAsString, is(equalTo(expectedListAsString)));
    }

    public String getWordFrequencyEmptyReport() {
        expectedList = new StringBuilder();
        return expectedList.toString();
    }

    private String getWordsFrequencyReportFrom(int topNFrequency, String wordsList) {
        WordsFrequencyReporter wordsFrequencyBuilder = new WordsFrequencyReporter();
        StringBuilder actualList = wordsFrequencyBuilder.parse(topNFrequency, wordsList);
        return actualList.toString();
    }
}