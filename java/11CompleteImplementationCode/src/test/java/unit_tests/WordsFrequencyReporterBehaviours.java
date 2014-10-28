package unit_tests;

import com.neomatrix369.services.WordsFrequencyReporter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class WordsFrequencyReporterBehaviours {

    private static final String EMPTY_REPORT = "";
    private static final String SHOULD_HAVE_RETURNED_AN_EMPTY_LIST =
            "Should have returned an empty list.";
    private static final String SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST =
            "Should have returned a list with one item at least.";
    private static final String SHOULD_HAVE_RETURNED_A_LIST_WITH_TWO_ITEMS_AT_LEAST =
            "Should have returned a list with two items at least.";
    private static final String SHOULD_HAVE_RETURNED_A_LIST_WITH_ONLY_THREE_ITEMS =
            "Should have returned a list with only three items.";

    private static final String NEWLINE = System.getProperty("line.separator");

    private String wordsList;
    private int topNFrequency;

    private String expectedReport;
    private String reasonForTestFailure;

    @Parameterized.Parameters
    public static Collection tableOfWordsListAndReports() {
        return getActualExpectedResultsTable();
    }

    private static List<Object[]> getActualExpectedResultsTable() {
        return Arrays.asList(new Object[][]{
                // List of words,   Top N words, Expected Result,  Reason message
                {null,              1,           EMPTY_REPORT,     SHOULD_HAVE_RETURNED_AN_EMPTY_LIST},                   // 1
                {"",                2,           EMPTY_REPORT,     SHOULD_HAVE_RETURNED_AN_EMPTY_LIST},                   // 1
                {"united",          1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 2
                {"united ",         1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 3
                {" united",         1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 4
                {" united ",        1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 5
                {" united, ",       1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 6
                {" united, ,",      1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 7
                {" \tunited, ,",    1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 8
                {" \tunited, ,\t",  1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 9
                {"united\n",        1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 10
                {"\nunited\n",      1,           "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 11
                {"united, kingdom", 2,           "1 kingdom\n" +
                                                 "1 united\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_TWO_ITEMS_AT_LEAST},  // 12
                {"united, " +
                 "kingdom, " +
                 "russia",          2,           "1 kingdom\n" +
                                                 "1 russia\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_TWO_ITEMS_AT_LEAST},  // 13
                {"united, " +
                 "kingdom, " +
                 "russia",          1,           "1 kingdom\n",    SHOULD_HAVE_RETURNED_A_LIST_WITH_ONE_ITEM_ATLEAST  },  // 14
                {"united, " +
                 "kingdom, " +
                 "russia",          0,           EMPTY_REPORT,     SHOULD_HAVE_RETURNED_AN_EMPTY_LIST                 },  // 15
                {"united, " +
                 "kingdom, " +
                 "russia",         -1,           EMPTY_REPORT,     SHOULD_HAVE_RETURNED_AN_EMPTY_LIST                 },  // 16
                {"united, " +
                 "kingdom, " +
                 "united, " +
                 "states",          3,           "2 united\n" +
                                                 "1 kingdom\n" +
                                                 "1 states\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONLY_THREE_ITEMS  },  // 17
                {"united, " +
                "kingdom, " +
                "united, " +
                "states",           4,           "2 united\n" +
                                                 "1 kingdom\n" +
                                                 "1 states\n",     SHOULD_HAVE_RETURNED_A_LIST_WITH_ONLY_THREE_ITEMS  }  // 18
        });
    }

    public WordsFrequencyReporterBehaviours(String wordsList,
                                            int topNFrequency,
                                            String expectedReport,
                                            String reasonForTestFailure) {
        this.wordsList = wordsList;
        this.topNFrequency = topNFrequency;
        this.expectedReport = expectedReport;
        this.reasonForTestFailure = reasonForTestFailure;
    }

    @Test
    public void shouldReturnReportWhen_AWordList_With_AValueForTopN_IsPassedIn() {
        // Given
        // Refer to table above for all combination and permutation
        // of topNFrequency and wordsList

        // When
        String actualListAsString =
                getWordsFrequencyReportFrom(topNFrequency, wordsList);

        // Then
        assertThat(reasonForTestFailure,
                actualListAsString, is(equalTo(expectedReport)));
    }

    private String getWordsFrequencyReportFrom(int topNFrequency, String wordsList) {
        WordsFrequencyReporter wordsFrequencyBuilder = new WordsFrequencyReporter();
        StringBuilder actualList = wordsFrequencyBuilder.parse(topNFrequency, wordsList);
        return actualList.toString();
    }
}