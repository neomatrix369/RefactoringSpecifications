using NUnit.Framework;
using System;
using System.Text;

namespace UnitTestsRefactoredToParamTests.Tests
{
	[TestFixture()]
	public class WordsFrequencyReporterBehaviours
	{
		private const string EMPTY_REPORT = "";

		//        word list          expected count             expected result
		[TestCase(null,              1,                Result = EMPTY_REPORT)]
		[TestCase("",                2,                Result = EMPTY_REPORT)]
		[TestCase("united",          1,                Result = "1 united\n")]
		[TestCase("united, kingdom", 2,                Result = "1 kingdom\n"
		                                                      + "1 united\n")]
		[TestCase("united, kingdom, "
		        + "united, states",  3,                Result = "2 united\n"
		                                                      + "1 kingdom\n"
		                                                      + "1 states\n")]
		public string ShouldReturnReportWhen_AWordList_With_AValueForTopN_IsPassedIn(string wordsList, int topNFrequency)
		{
			// Given
			// Refer to table above for all combination and permutation
			// of topNFrequency and wordsList

			// When
			WordsFrequencyReporter wordsFrequencyBuilder = new WordsFrequencyReporter();
			StringBuilder actualList = wordsFrequencyBuilder.Parse(topNFrequency, wordsList);

			// Then
			return actualList.ToString();
		}
	}
}
