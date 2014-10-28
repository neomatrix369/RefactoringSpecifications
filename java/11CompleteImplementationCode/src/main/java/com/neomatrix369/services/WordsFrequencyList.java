package com.neomatrix369.services;

import com.neomatrix369.domain.WordEntity;

import java.util.ArrayList;
import java.util.List;

public class WordsFrequencyList {
    private static final String COMMA_SEPARATOR = ",";

    public List<WordEntity> calculateWordsFrequency(String wordsList) {
        String[] splitWordsList = wordsList.split(COMMA_SEPARATOR);

        List<WordEntity> wordsFrequencyList = new ArrayList<>();
        for (String word: splitWordsList) {
            word = word.trim();
            if (word.isEmpty()) {
                continue; // skip to the next word
            }
            Integer frequency = 1;
            WordEntity wordEntity = new WordEntity(word, frequency);
            upsertWordIntoWordsList(wordsFrequencyList, word, wordEntity);
        }

        return wordsFrequencyList;
    }

    // upsert means update or insert
    private void upsertWordIntoWordsList(
            List<WordEntity> wordsFrequencyList,
            String word, WordEntity wordEntity) {
        WordEntity foundWord = foundWordUsing(wordsFrequencyList, word);
        if (wordAlreadyExists(foundWord)){
            updateWordInWordsList(wordsFrequencyList, foundWord);
        } else {
            addWordToWordsList(wordsFrequencyList, wordEntity);
        }
    }

    private void addWordToWordsList(List<WordEntity> wordsFrequencyList, WordEntity wordEntity) {
        wordsFrequencyList.add(wordEntity);
    }

    private void updateWordInWordsList(List<WordEntity> wordsFrequencyList, WordEntity foundWord) {
        wordsFrequencyList.remove(foundWord);
        foundWord.incrementFrequency();
        addWordToWordsList(wordsFrequencyList, foundWord);
    }

    private boolean wordAlreadyExists(WordEntity foundWord) {
        return foundWord != null;
    }

    private WordEntity foundWordUsing(
            List<WordEntity> wordEntityList, String word) {
        for (WordEntity wordEntity: wordEntityList) {
            if (wordEntity.isTheSameAs(word)) {
                return wordEntity;
            }
        }
        return null;
    }
}