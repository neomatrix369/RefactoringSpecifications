using NUnit.Framework;
using System;

namespace FailingUnitTests.Tests
{
	[TestFixture()]
	public class WordsFrequencyReporterBehaviours
	{
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
			string expectedList = "";
			string wordsList = "";
			int topN = 3;

			// When
			WordsFrequencyReporter wordsFrequencyBuilder = new WordsFrequencyReporter();
			string actualList = wordsFrequencyBuilder.Parse(topN, wordsList).ToString();

			//Then
			Assert.AreEqual(expectedList, actualList);
		}
	}
}
