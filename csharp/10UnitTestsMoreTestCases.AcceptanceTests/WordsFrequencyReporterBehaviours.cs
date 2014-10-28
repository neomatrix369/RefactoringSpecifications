using NUnit.Framework;
using System;
using System.Text;

namespace UnitTestsMoreTestCases.AcceptanceTests
{
	[TestFixture()]
	public class WordsFrequencyReporterBehaviours
	{
			/*
	        Scenario: List of top repeated words sorted by frequency
	            Given a list of words is available
	            And N number of top repeated words to print is known
	            When the frequency program is executed
	            Then the top N most frequently occurring words in the list together with their frequency of
	            occurrence are printed
	            And the output is sorted in descending order by frequency of occurrence.

	        Example:
	            Input:
	                N = 3
	                    and
	                list = united, states, america, north, america, south, america, africa, north, korea

	            Output:
	                3 america
	                2 north
	                1 south
	    */
		[Test()]
		public void ShouldReturn_A_ListOf_UniqueWordFrequencies()
		{
			// Given a list of words is available
			// And N number of top repeated words to print is known
			string expectedListAsString =
				  "3 america" + "\n"
				+ "2 north" + "\n"
				+ "1 south" + "\n";
			int topNumberOfWords = 3;
			String wordsList = "united, states, america, north, america, south, america, africa, north, korea";

			// When the frequency program is executed
			WordsFrequencyReporter wordsFrequencyReporter = new WordsFrequencyReporter();
			StringBuilder actualList = wordsFrequencyReporter.Parse(topNumberOfWords, wordsList);
			string actualListAsString = actualList.ToString();

			// Then the top N most frequently occurring words in the list together with their frequency of
			// occurrence are printed
			// And the output is sorted in descending order by frequency of occurrence.
			Assert.AreEqual(expectedListAsString, actualListAsString);
		}

		/*
	        Scenario: List of top repeated words sorted by frequency,
	        words with same frequencies ordered in alphabetical order

	            Given a list of words is available
	            And N number of top repeated words to print is known
	            And two or more words have the same frequencies

	            When the frequency program is executed

	            Then the top N most frequently occurring words in the list together with their frequency of
	            occurrence are printed
	            And the output is sorted in descending order by frequency of occurrence
	            And the words with the same frequency are further is sorted alphabetically (ascending order)

	        Example:
	            Input:
	                N = 3
	                    and
	                list = united, states, america, north, america, south, america, south, africa,
	                north, korea, united kingdom, united kingdom

	            Output:
	                3 america
	                2 north
	                2 united kingdom
	                2 south
	    */
		[Test()]
		public void ShouldReturn_A_ListOfWordFrequencies_OrderedByAlpha_WhenFrequenciesRepeat() {
			// Given a list of words is available
			// And N number of top repeated words to print is known
			// And two or more words have the same frequencies
			string expectedListAsString =
				  "3 america" + "\n"
				+ "2 england" + "\n"
				+ "2 north" + "\n"
				+ "2 south" + "\n";
			int topNumberOfWords = 4;
			String wordsList = "united, states, america, north, america, south, america, south, africa, north, korea, england, england";

			// When the frequency program is executed
			WordsFrequencyReporter wordsFrequencyReporter = new WordsFrequencyReporter();
			StringBuilder actualList = wordsFrequencyReporter.Parse(topNumberOfWords, wordsList);
			string actualListAsString = actualList.ToString();

			// Then the top N most frequently occurring words in the list together with their frequency
			// of occurrence are printed
			// And the output is sorted in descending order by frequency of occurrence
			// And the words with the same frequency are further is sorted alphabetically (ascending order)
			Assert.AreEqual(expectedListAsString, actualListAsString);
		}
	}
}
