package scrabble.data;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class InitFromWordListTest {
	@Test
	public void initFromFile() throws FileNotFoundException {
		WordList wl = new SimpleWordList()
				.initFromFile("wordlists/sowpods.txt");
		assertEquals("Task1: initFromFile / words should be stored in wordlist", 267751, wl.size());
	}

}


