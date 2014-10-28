using NUnit.Framework;
using System;
using System.Text;

namespace UnitTestsOneHappyPath.Tests
{
	[TestFixture()]
	public class WordsFrequencyReporterBehaviours
	{
		private const string SHOULD_HAVE_RETURNED_AN_EMPTY_LIST = "Should have returned an empty list";
		private const string EMPTY_WORDS_LIST = "";
		private const string NOT_ASSIGNED = null;
		private const int ANY_VALID_TOP_N = 1;

		/*
	        Scenario: Frequency report for an undefined list (null)
	            Given an undefined list is available
	            When the frequency program is executed
	            Then an empty report is returned
	    */
		[Test()]
		public void ShouldReturnAnEmptyReportWhenANullWordList_With_AnyValueForTopN_IsPassedIn() {
			// Given
			string expectedListAsString = GetWordFrequencyEmptyReport();

			// When
			string actualListAsString =
				GetWordsFrequencyReportFrom(ANY_VALID_TOP_N, NOT_ASSIGNED);

			//Then
			Assert.AreEqual(expectedListAsString, actualListAsString);
		}

		/*
	        Scenario: Frequency report for an empty list
	            Given an empty list is available
	            When the frequency program is executed
	            Then an empty report is returned
	    */
		[Test()]
		public void ShouldReturnAnEmptyReportWhenAnEmptyListAndForAnyValidTopNIsPassedIn()
		{
			// Given
			string expectedListAsString = GetWordFrequencyEmptyReport();

			// When
			string actualListAsString =
				GetWordsFrequencyReportFrom(ANY_VALID_TOP_N, EMPTY_WORDS_LIST);

			//Then
			Assert.AreEqual(expectedListAsString, actualListAsString);
		}

		/*
	        Scenario: Frequency report for a list with one word
	            Given a list with one word is available
	            When the frequency program is executed
	            Then an a report containing one word (the same) is returned
	    */
		[Test()]
		public void ShouldReturnReportWithOneWordWhenAListWithASingleWord_With_AnyValueForTopN_IsPassedIn() {
			// Given
			String expectedListAsString = "1 united\n";
			String wordList = "united";

			// When
			String actualListAsString = GetWordsFrequencyReportFrom(ANY_VALID_TOP_N, wordList);

			//Then
			Assert.AreEqual(expectedListAsString, actualListAsString);
		}


		public string GetWordFrequencyEmptyReport() 
		{
			return "";
		}

		private string GetWordsFrequencyReportFrom(int topNFrequency, String wordsList) 
		{
			WordsFrequencyReporter wordsFrequencyBuilder = new WordsFrequencyReporter();
			StringBuilder actualList = wordsFrequencyBuilder.Parse(topNFrequency, wordsList);
			return actualList.ToString();
		}
	}
}
