package com.neomatrix369.sorter;

import com.neomatrix369.domain.WordEntity;

import java.util.Comparator;

public class SortByFrequencyDescAndByWordAlphabetically implements Comparator<WordEntity> {

    private static final int THAT_THE_FIRST_WORD_HAS_LOWER_FREQUENCY = 1;
    private static final int THAT_THE_FIRST_WORD_HAS_HIGHER_FREQUENCY = -1;

    @Override
    public int compare(WordEntity firstWordEntity, WordEntity secondWordEntity) {
        // Sort Frequency in DESC order
        if (firstTheWordIsLessFrequentlyRepeatedThanTheSecond(
                firstWordEntity, secondWordEntity))
            return THAT_THE_FIRST_WORD_HAS_LOWER_FREQUENCY; // greater than

        if (firstTheWordIsMoreFrequentlyRepeatedThanTheSecond(
                firstWordEntity, secondWordEntity))
            return THAT_THE_FIRST_WORD_HAS_HIGHER_FREQUENCY; // less than

        // equal to
        // same frequency
        // sort alphabetically
        return frequenciesAreSameLetsSortThemByWordsAlphabetically(
                firstWordEntity, secondWordEntity);
    }

    private int frequenciesAreSameLetsSortThemByWordsAlphabetically(
            WordEntity firstWordEntity, WordEntity secondWordEntity) {
        return firstWordEntity.getWord()
                .compareTo(secondWordEntity.getWord());
    }

    private boolean firstTheWordIsMoreFrequentlyRepeatedThanTheSecond(
            WordEntity firstWordEntity, WordEntity secondWordEntity) {
        if (firstWordEntity.getFrequency() >
                secondWordEntity.getFrequency()) {
            return true;
        }
        return false;
    }

    private boolean firstTheWordIsLessFrequentlyRepeatedThanTheSecond(
            WordEntity firstWordEntity, WordEntity secondWordEntity) {
        if (firstWordEntity.getFrequency() <
                secondWordEntity.getFrequency()) {
            return true;
        }
        return false;
    }
}