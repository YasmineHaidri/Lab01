package scrabble.data;

import scrabble.util.Permutation;

import java.io.*;
import java.util.*;
import java.util.logging.Level;

public class SimpleWordList implements WordList {

	public ArrayList<String> words = new ArrayList<String>();


	public static void main(String[] args) throws FileNotFoundException {
		WordList wl = new SimpleWordList();
		wl.initFromFile("wordlists/sowpods.txt");
		wl.validWordsUsingAllTiles("abc");
	}
	@Override
	public Set<String> validWordsUsingAllTiles(String tileRackPart) {

		int n = tileRackPart.length();
		Permutation perm= new Permutation(tileRackPart);

		Set<String> allPerms = perm.permute(tileRackPart);

		Set<String> validPerms = new HashSet<>();
		for (String p : allPerms) {
			if (words.contains(p)) {
				validPerms.add(p);
			}
		}
		return validPerms;


	}

	@Override
	public Set<String> allValidWords(String tileRack) {
		return null;
	}

	@Override
	public boolean add(String word) {
		words.add(word);

		return false;
	}

	@Override
	public boolean addAll(Collection<String> words) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {

		return words.size();
	}




	@Override
	public WordList initFromFile(String fileName) {
			WordList wl = new SimpleWordList();
			try {
				File file = new File(fileName);

				Scanner scanner = new Scanner(file);

				while (scanner.hasNextLine()){
					String line = scanner.nextLine();
					wl.add(line);
				}

			}

			catch (Exception e){
				e.printStackTrace();
			}

		return wl;
		// TODO Auto-generated method stub
	}




	//Extra



}
