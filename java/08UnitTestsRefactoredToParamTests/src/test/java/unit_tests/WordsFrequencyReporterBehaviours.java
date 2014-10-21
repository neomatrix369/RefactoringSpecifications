package unit_tests;

import com.neomatrix369.services.WordsFrequencyReporter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class WordsFrequencyReporterBehaviours {

    private static final String SHOULD_HAVE_RETURNED_A_REPORT= "Should have returned a report";
    private static final String EMPTY_REPORT = "";
    private String wordsList;
    private int topNFrequency;
    private String expectedReport;

    @Parameterized.Parameters
    public static Collection tableOfWordsListAndReports() {
        return Arrays.asList(new Object[][]{
              // Word list,    count, expected result
                {null,              1, EMPTY_REPORT                },  // 0
                {"",                2, EMPTY_REPORT                },  // 1
                {"united",          1, "1 united\n"                },  // 2
                {"united, kingdom", 2, "1 kingdom\n" +
                                       "1 united\n"                },  // 3
                {"united, kingdom,"+
                 "united, states",  3, "1 united\n" +                  // 4
                                       "1 kingdom\n" +
                                       "1 states\n"                }
        });
    }

    public WordsFrequencyReporterBehaviours(String wordsList, 
                                            int topNFrequency,
                                            String expectedReport) {
        this.wordsList = wordsList;
        this.topNFrequency = topNFrequency;
        this.expectedReport = expectedReport;
    }

    @Test
    public void shouldReturnReportWhen_AWordList_With_AValueForTopN_IsPassedIn() {
        // Given
        // Refer to table above for all combination and permutation
        // of topNFrequency and wordsList

        // When
        String actualListAsString =
                getWordsFrequencyReportFrom(topNFrequency, wordsList);

        //Then
        assertThat(SHOULD_HAVE_RETURNED_A_REPORT,
                actualListAsString, is(equalTo(expectedReport)));
    }

    private String getWordsFrequencyReportFrom(int topNFrequency, String wordsList) {
        WordsFrequencyReporter wordsFrequencyBuilder = new WordsFrequencyReporter();
        StringBuilder actualList = wordsFrequencyBuilder.parse(topNFrequency, wordsList);
        return actualList.toString();
    }
}