using System;
using System.Collections.Generic;

namespace CompleteImplementationCode
{
	public class WordsFrequencyList {
		private const char COMMA_SEPARATOR = ',';

		public IList<WordEntity> CalculateWordsFrequency(string wordsList)
		{
			string[] splitWordsList = wordsList.Split(COMMA_SEPARATOR);

			var wordsFrequencyList = new List<WordEntity>();
			foreach (string word in splitWordsList)
			{
				string trimmedWord = word.Trim();
				if (string.IsNullOrEmpty(trimmedWord))
				{
					continue; // skip to the next word
				}
				int frequency = 1;
				WordEntity wordEntity = new WordEntity { Word = trimmedWord, Frequency = frequency };
				UpsertWordIntoWordsList(wordsFrequencyList, trimmedWord, wordEntity);
			}

			return wordsFrequencyList;
		}

		// upsert means update or insert
		private void UpsertWordIntoWordsList(IList<WordEntity> wordsFrequencyList, string word, WordEntity wordEntity)
		{
			WordEntity foundWord = FoundWordUsing(wordsFrequencyList, word);
			if (WordAlreadyExists(foundWord))
			{
				UpdateWordInWordsList(wordsFrequencyList, foundWord);
			}
			else
			{
				AddWordToWordsList(wordsFrequencyList, wordEntity);
			}
		}

		private void AddWordToWordsList(IList<WordEntity> wordsFrequencyList, WordEntity wordEntity) {
			wordsFrequencyList.Add(wordEntity);
		}

		private void UpdateWordInWordsList(IList<WordEntity> wordsFrequencyList, WordEntity foundWord) {
			wordsFrequencyList.Remove(foundWord);
			foundWord.IncrementFrequency();
			AddWordToWordsList(wordsFrequencyList, foundWord);
		}

		private bool WordAlreadyExists(WordEntity foundWord) {
			return foundWord != null;
		}

		private WordEntity FoundWordUsing(IList<WordEntity> wordEntityList, string word) {
			foreach (WordEntity wordEntity in wordEntityList)
			{
				if (wordEntity.isTheSameAs(word)) 
				{
					return wordEntity;
				}
			}
			return null;
		}
	}
}

