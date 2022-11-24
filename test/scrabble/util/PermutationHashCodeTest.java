package scrabble.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PermutationHashCodeTest {

	String string1, string2;
	 @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 { "hallo", "lloha" }, { "otto", "toto" }, { "imi", "mii" },
	                 { "a","a" }, { "","" }, { "ab","ba" }, { "wundertuete","ertuetwunde" }, { "","" }
	           });
	    }

	public PermutationHashCodeTest(String string1, String string2) {
		this.string1 = string1; 
		this.string2 = string2
				;}
	@Test
	public void hashCodeForPermutationsShouldBeTheSame() {
			Permutation permutation1 = new Permutation(string1);
			Permutation permutation2 = new Permutation(string2);
			assertEquals(permutation1, permutation2);
			assertEquals(permutation1.hashCode(), permutation2.hashCode());
		}
}
