package scrabble.data;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WordListTest {

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ "just two", "ba", new String[] { "ab", "ba" },
						new String[] { "ab", "ba" },
						new String[] { "ab", "ba" } },
				{ "just two with three characters", "abc",
						new String[] { "abc", "cba" },
						new String[] { "abc", "cba" },
						new String[] { "abc", "cba" } },
				{
						"the correct number from the word list",
						"abc",
						new String[] { "abc", "cba" },
						new String[] { "ab", "bc", "abc", "cba" },
						new String[] { "ab", "bc", "ad", "abc", "cba", "asd",
								"asdfjkafs", "aa" } },
				{ "the correct number from the word list II", "abc",
						new String[] { "cab", "cba" },
						new String[] { "cab", "cba" },
						new String[] { "cab", "cba", "asd", "asdfjkafs", "aa" } },
				{
						"no permutations, but shorter suggestions",
						"abcd",
						new String[] {},
						new String[] { "cab", "cba" },
						new String[] { "cab", "cba", "asd", "axdr",
								"asdfjkafs", "aa" } },
				{ "only return suggestions that are in wordlist", "abc",
						new String[] { "abc" }, new String[] { "abc", "cb" },
						new String[] { "abc", "cb", "bcd" } } };
		return Arrays.asList(data);
	}

	String message;
	String tileRack;
	int permutationCount;
	int wordSuggestionCount;
	String[] words;
	WordList wl;

	public WordListTest(String message, String tileRack, String[] permutations,
			String[] validSuggestions, String[] wordsInWordList) {
		this.message = message;
		this.tileRack = tileRack;
		this.permutationCount = permutations.length;
		this.wordSuggestionCount = validSuggestions.length;
		this.words = wordsInWordList;
	}

	@Before
	public void createWordList() {
		wl = new SimpleWordList();
		wl.addAll(Arrays.asList(words));
	}

	@Test
	public void sizeShouldGiveTotalNumberOfStoredWords() {
		assertEquals(message, words.length, wl.size());
	}

	@Test
	public void shouldReturnCorrectAmountOfPermutations() {
		assertEquals(message, permutationCount, wl.validWordsUsingAllTiles(tileRack)
				.size());
	}

	/**
	 * This is Part of the Deluxe Version
	 */
	@Ignore
	public void shouldReturnCorrectNumberOfSuggestions() {
		assertEquals(message, wordSuggestionCount, wl.allValidWords(tileRack).size());
	}

}
