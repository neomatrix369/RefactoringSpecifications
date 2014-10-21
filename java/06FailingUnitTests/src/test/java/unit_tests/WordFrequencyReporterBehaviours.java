package unit_tests;

import com.neomatrix369.WordsFrequencyReporter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordFrequencyReporterBehaviours {
    /*
        Scenario: Frequency report for an empty list
            Given an empty list is available
            When the frequency program is executed
            Then an empty report is returned
    */
    @Test
    public void shouldReturnAnEmptyReportWhenAnEmptyListAndForAnyValidTopNIsPassedIn() {
        // Given
        StringBuilder expectedList = new StringBuilder();
        String wordsList = "";
        int topN = 3;

        // When
        WordsFrequencyReporter wordsFrequencyBuilder = new WordsFrequencyReporter();
        StringBuilder actualList = wordsFrequencyBuilder.parse(topN, wordsList);

        //Then
        assertThat("Should have returned an empty list", actualList,
                is(equalTo(expectedList)));
    }

}
