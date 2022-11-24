package scrabble.data;

import scrabble.util.Permutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class OwnHashWordList implements WordList{
    public Hashtable<String, String> wordSet = new Hashtable<>();


    public static void main(String[] args) throws FileNotFoundException {

        WordList wl = new OwnHashWordList().initFromFile();


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
        String normalizedRack = new Permutation(tileRackPart).getNormalized();
        for (String word : wordSet.keySet()) {
            if (wordSet.get(word).equals(normalizedRack)) {
                acceptedWords.add(word);
            }
        }
        return acceptedWords;

    }

    @Override
    public Set<String> allValidWords(String tileRack) {
        List<String> letterArraySub = Arrays.asList(tileRack.split(""));
        ArrayList<String> letterArray = new ArrayList<>(letterArraySub);

        Set<String> allValidPerms = new HashSet<>();
        Set<String> strings = getAllSubArrays(letterArray, new HashSet<>());

        allValidPerms.addAll(validWordsUsingAllTiles(tileRack));
        for (String currentWord : strings) {
            allValidPerms.addAll(validWordsUsingAllTiles(currentWord));
        }
        return allValidPerms;

    }

    @Override
    public boolean add(String word) {
        wordSet.put(word, new Permutation(word).getNormalized());
        return true;

    }
    @Override
    public boolean addAll(Collection<String> words) {
        for (String str : words) {
            add(str);
        }
        return true;
    }

    @Override
    public int size() {
        return wordSet.size();
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

    private Set<String> getAllSubArrays (ArrayList array, Set<String> letterSet) {

        for (int i = 0; i < array.size(); i++) {
            String letterComb = "";
            ArrayList<String> subArray = new ArrayList<>(array);
            subArray.remove(i);
            for (String letter : subArray) {
                letterComb += letter;
            }
            letterSet.add(letterComb);
            getAllSubArrays(subArray, letterSet);
        }
        return letterSet;
    }

}