package scrabble.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class validWordsUsingAllTilesTest {
    @Test
    public void validWordsUsingAllTiles() {
        WordList wl = new SimpleWordList()
                .initFromFile("wordlists/sowpods.txt");
                wl.validWordsUsingAllTiles("abc");
        assertEquals("blabla", 26, wl.validWordsUsingAllTiles("abc"));
    }
}
