using System;

namespace CompleteImplementationCode
{
	public class WordEntity
	{
		public string Word { get; set; }

		public int Frequency { get; set; }

		public void IncrementFrequency() {
			Frequency++;
		}

		public bool isTheSameAs(String word) {
			return Word == word;
		}
	}
}
