using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CompleteImplementationCode
{
	public class WordsFrequencyReporter
	{
		private const string EACH_LINE_REPORT_FORMAT = "{0} {1}\n";

		public StringBuilder Parse(int topNFrequency, String wordsList) {
			StringBuilder report = new StringBuilder();

			if (CheckIfWordsListIsNotAssignedOrEmpty(wordsList))
			{
				return report;
			}

			WordsFrequencyList wordsFrequencyHelper = new WordsFrequencyList();
			var wordsFrequencyList = wordsFrequencyHelper.CalculateWordsFrequency(wordsList)
				.OrderBy(word => word, new SortByFrequencyDescAndByWordAlphabetically())
				.ToList();

			return GenerateReportToReturn(report, wordsFrequencyList, topNFrequency);
		}

		private StringBuilder GenerateReportToReturn(StringBuilder report, ICollection<WordEntity> wordsFrequencyList, int topNFrequency)
		{
			if (topNFrequency <= 0)
			{
				return report;
			}

			topNFrequency = KeepTopNFrequencyWithinRange(wordsFrequencyList, topNFrequency);

			var filteredList = wordsFrequencyList.Take(topNFrequency);
			foreach (WordEntity wordEntity in filteredList)
			{
				report.AppendFormat(EACH_LINE_REPORT_FORMAT, wordEntity.Frequency, wordEntity.Word);
			}

			return report;
		}

		private int KeepTopNFrequencyWithinRange(ICollection<WordEntity> wordsFrequencyList, int topNFrequency)
		{
			return Math.Min(topNFrequency, wordsFrequencyList.Count);
		}

		private bool CheckIfWordsListIsNotAssignedOrEmpty(String wordsList) 
		{
			return WordsListIsNotAssigned(wordsList) || wordsList.Length == 0;
		}

		private bool WordsListIsNotAssigned(String wordsList) 
		{
			return wordsList == null;
		}
	}
}
