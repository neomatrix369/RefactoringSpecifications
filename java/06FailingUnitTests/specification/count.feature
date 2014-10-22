Feature: Most Frequently Occurring Words
  As a web SEO admin
  I would like to see a list top frequently repeated words
  So that I can keep a tab of popular words

  Scenario: List of top repeated words sorted by frequency

    Given a list of words is available
    And N number of top repeated words to print is known
    When the frequency program is executed
    Then the top N most frequently occurring words in the list together with their frequency of occurrence are printed
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

  Scenario: List of top repeated words sorted by frequency, words with same frequencies ordered in alphabetical order

    Given a list of words is available
    And N number of top repeated words to print is known
    And two or more words have the same frequencies
    When the frequency program is executed
    Then the top N most frequently occurring words in the list together with their frequency of occurrence are printed
    And the output is sorted in descending order by frequency of occurrence
    And the words with the same frequency are further is sorted alphabetically (ascending order)

  Example:
    Input:
      N = 4
    and
      list = united, states, america, north, america, south, america, south, africa, north, korea, england, england

    Output:
      3 america
      2 england
      2 north
      2 south
