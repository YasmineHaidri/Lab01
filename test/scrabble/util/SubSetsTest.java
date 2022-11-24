package scrabble.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SubSetsTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ "a", new String[] {} },
				{ "ab", new String[] { "ab" } },
				{
						"java",
						new String[] { "aajv", "ajv", "aaj", "aav", "aa", "aj",
								"av", "jv" } },
				{
						"abcd",
						new String[] { "ab", "ac", "ad", "bc", "bd", "cd",
								"abc", "abd","bcd","acd","abcd" } } });
	}

	String str;
	Set<String> expected;

	public SubSetsTest(String str, String[] list) {
		this.str = str;
		this.expected = new HashSet<String>(Arrays.asList(list));
	}

	@Ignore
	public void testComputeSubSets() {
		Set<String> actual = SubSets.getSubSets(str);
		assertEquals(expected, actual);
	}
	@Test
	public void testNothing() {
		// just to avoid to get the No runnable methods error, can be deleted
		// if the @Ignore above is changed to @Test
	}

}
