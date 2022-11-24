package scrabble.util;


import java.util.*;

public class Permutation {
	String word;

	public Permutation(String word) {
		this.word = word;
	}

	@Override
	public int hashCode() {
		// TBD: implement this method
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			String word1 = getNormalized();
			String word2 = ((Permutation)obj).getNormalized();

			if (Objects.equals(word1, word2))
				return true;
			else
				return false;
		}
		catch (ClassCastException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return getWord() + " / " + getNormalized();
	}

	public String getNormalized() {
		char[] charArray = word.toLowerCase().toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public String getWord() {
		return word;
	}

	public int length() {
		// TBD: implement this method
		return 0;
	}
	public Set<String> permute(String str)
	{
		Set<String> perm = new HashSet<String>();
		//Handling error scenarios
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		Set<String> words = permute(rem);
		for (String strNew : words) {
			for (int i = 0;i<=strNew.length();i++){
				perm.add(charInsert(strNew, initial, i));
			}
		}
		return perm;
	}


	public static String charInsert(String str, char c, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}

}
