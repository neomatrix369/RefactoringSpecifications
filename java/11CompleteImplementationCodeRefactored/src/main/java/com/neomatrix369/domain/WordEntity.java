package com.neomatrix369.domain;

public class WordEntity {
    private String word;
    private int frequency;

    public WordEntity(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incrementFrequency() {
        frequency++;
    }

    public boolean isTheSameAs(String word) {
        return this.word.equals(word);
    }
}