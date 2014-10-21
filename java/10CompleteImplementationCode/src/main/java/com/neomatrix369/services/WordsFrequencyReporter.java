package com.neomatrix369.services;

import com.neomatrix369.domain.WordEntity;
import com.neomatrix369.sorter.SortByFrequencyDescAndByWordAlphabetically;

import java.util.Collections;
import java.util.List;

public class WordsFrequencyReporter {
    private static final String EACH_LINE_REPORT_FORMAT = "%d %s" + "\n";

    public StringBuilder parse(int topNFrequency, String wordsList) {
        StringBuilder report = new StringBuilder();

        if ( checkIfWordsListIsNotAssignedOrEmpty(wordsList) ) {
            return report;
        }

        WordsFrequencyList wordsFrequencyHelper = new WordsFrequencyList();
        List<WordEntity> wordsFrequencyList =
                wordsFrequencyHelper.calculateWordsFrequency(wordsList);

        Collections.sort(
                wordsFrequencyList, new SortByFrequencyDescAndByWordAlphabetically());

        return generateReportToReturn(report, wordsFrequencyList, topNFrequency);
    }

    private boolean wordsListIsNotAssigned(String wordsList) {
        return wordsList == null;
    }

    private StringBuilder generateReportToReturn(
            StringBuilder report,
            List<WordEntity> wordsFrequencyList,
            int topNFrequency) {
        if (topNFrequency <= 0) {
            return report;
        }

        topNFrequency = keepTopNFrequencyWithinRange(wordsFrequencyList, topNFrequency);

        List<WordEntity> filteredList = wordsFrequencyList.subList(0, topNFrequency);
        for(WordEntity wordEntity: filteredList) {
            report.append(String.format(EACH_LINE_REPORT_FORMAT,
                    wordEntity.getFrequency(),
                    wordEntity.getWord()));
        }

        return report;
    }

    private int keepTopNFrequencyWithinRange(List<WordEntity> wordsFrequencyList, int topNFrequency) {
        if (topNFrequency > wordsFrequencyList.size()) {
            topNFrequency = wordsFrequencyList.size();
        }
        return topNFrequency;
    }

    private boolean checkIfWordsListIsNotAssignedOrEmpty(String wordsList) {
        return wordsListIsNotAssigned(wordsList) || wordsList.isEmpty();
    }
}