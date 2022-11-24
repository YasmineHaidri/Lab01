package scrabble.data;

import scrabble.util.Permutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class HashWordList implements WordList{
    public HashMap<String,String> words = new HashMap();


    public static void main(String[] args) throws FileNotFoundException {
        WordList wl = new HashWordList().initFromFile("wordlists/sowpods.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your word: ");
        System.out.println("Type close to exit");
        String input ="";
        try{
        while(!input.equals("close")){
        input = reader.readLine();
        System.out.println(wl.validWordsUsingAllTiles(input));
        }}
        catch (Exception e){
            System.out.println(e);
        }

    }
    @Override
    public Set<String> validWordsUsingAllTiles(String tileRackPart) {

        Set<String> acceptedWords = new HashSet<>();
        String normalized = new Permutation(tileRackPart).getNormalized();
        for(String word: words.keySet()){
            if (words.get(word).equals(normalized)){
                acceptedWords.add(word);
            }

        }
        return acceptedWords;
    }

    @Override
    public Set<String> allValidWords(String tileRack) {
        return null;
    }

    @Override
    public boolean add(String word) {
        words.put(word, new Permutation(word).getNormalized());

        return false;
    }

    @Override
    public boolean addAll(Collection<String> words) {

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



}
