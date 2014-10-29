# Refactoring Specifications

## Original Specification
#### Problem: Most frequently occurring words

| |
|---|
| Given a list of words, print the list of top N most frequently occurring words in the list together with their frequency of occurrence.  The output should be sorted in descending order by frequency of occurrence. If two words occur with the same frequency then they should be ordered in alphabetical order. |

#### Example

| Input |
|-------|
| N = 3 |
| and   | 
| list = united, states, america, north, america, south, america, south, africa, north, korea |


| Output    |
|-----------|
| 3 america |
| 2 north   |
| 2 south   |

See [Original specification as a feature file (early stages)] (https://github.com/neomatrix369/RefactoringSpecifications/blob/master/java/01OriginalProblem/specification/count.feature)

---

## About this repo

This repo has been created as part of the Refactoring Specifications presentation.

Please note that commits made here do not reflect the commits that would be made in the real life. E.g. all commits starting with 1 would be part of a single commit that would contain acceptance test with minimal implementation to satisfy it. In ideal world, after every commits the entire test suite is green.

Each commit is a project by itself and as we go through to the last project where all the acceptance tests, unit tests and implementation code are fleshed out.

This is a way of illustrating how the developer would have started writing code.

Only the specification and tests are incrementally progressed from the first commit to the last - no sensible implementation is available till the last commit.

Below is a list of commits and what they mean, in the order in which they have been made (flow):

* Refactoring Specifications - 01 Saving the original problem, create f…
* Refactoring Specifications - 02 Create compact BDD / Gherkin style st…
* Refactoring Specifications - 03 Flesh out the compact BDD / Gherkin s…
* Refactoring Specifications - 04 Adding examples for each of the flesh…
* Refactoring Specifications - 05 Writing our first acceptance tests wi…
* Refactoring Specifications - 06 Writing our first failing unit test
* Refactoring Specifications - 07 Writing unit tests (edge cases)
* Refactoring Specifications - 08 Writing more tests (happy path)
* Refactoring Specifications - 09 Writing more unit tests and refactori…
* Refactoring Specifications - 10 Writing some more unit tests to help…
* Refactoring Specifications - 11 Code base with full implementation th…

---

### Hands-on-session
1. Clone this repo (git clone git@github.com:neomatrix369/RefactoringSpecifications.git)
2. Load the project (of the language of your choice) into your IDE
3. Create a new project in the language of your choice in the IDE
4. Copy the original specification (see link above) into the IDE as a file (example see Original specification... link above)
5. Let's get started (you can commit your changes as you go or commit in the end) !

**Note: to get the best out of the session, please don't look at the slides yet or the code-base. Only look at the tests after you have finished writing your own at the end of each step.**

---

####[Presentation slides available.](http://www.slideshare.net/neomatrix369/refactoring-specifications)
