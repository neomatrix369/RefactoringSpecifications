using System;
using System.Collections.Generic;

namespace CompleteImplementationCode
{
	public class SortByFrequencyDescAndByWordAlphabetically : IComparer<WordEntity> {

		private const int THAT_THE_FIRST_WORD_HAS_LOWER_FREQUENCY = 1;
		private const int THAT_THE_FIRST_WORD_HAS_HIGHER_FREQUENCY = -1;

		public int Compare(WordEntity firstWordEntity, WordEntity secondWordEntity) {
			// Sort Frequency in DESC order
			if (FirstTheWordIsLessFrequentlyRepeatedThanTheSecond(
				firstWordEntity, secondWordEntity))
				return THAT_THE_FIRST_WORD_HAS_LOWER_FREQUENCY; // greater than

			if (FirstTheWordIsMoreFrequentlyRepeatedThanTheSecond(
				firstWordEntity, secondWordEntity))
				return THAT_THE_FIRST_WORD_HAS_HIGHER_FREQUENCY; // less than

			// equal to
			// same frequency
			// sort alphabetically
			return FrequenciesAreSameLetsSortThemByWordsAlphabetically(
				firstWordEntity, secondWordEntity);
		}

		private int FrequenciesAreSameLetsSortThemByWordsAlphabetically(
			WordEntity firstWordEntity, WordEntity secondWordEntity) {
			return firstWordEntity.Word
				.CompareTo(secondWordEntity.Word);
		}

		private bool FirstTheWordIsMoreFrequentlyRepeatedThanTheSecond(
			WordEntity firstWordEntity, WordEntity secondWordEntity) {
			if (firstWordEntity.Frequency >
				secondWordEntity.Frequency) {
				return true;
			}
			return false;
		}

		private bool FirstTheWordIsLessFrequentlyRepeatedThanTheSecond(
			WordEntity firstWordEntity, WordEntity secondWordEntity) {
			if (firstWordEntity.Frequency <
				secondWordEntity.Frequency) {
				return true;
			}
			return false;
		}
	}
}

