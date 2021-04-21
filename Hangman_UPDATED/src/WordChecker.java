import java.util.*;

public class WordChecker {
	private final static Map<String, Word> DICTIONARY = new LinkedHashMap<>();
	
	private final static Map<String, ComputeWordDifficulty> USED_WORD = new LinkedHashMap<>();
	
	public static void main(String[] args) throws Exception {
		
		setDICTIONARY();
		String word = getWord();
		
		System.out.print("\n\tDictionary size: " + DICTIONARY.size() + " words\n\n");
		
		System.out.println("\tWORD: " + DICTIONARY.get(word).getWORD());
		System.out.println("\tROOT WORD: " + getRootWord(word));
		System.out.println("\tLETTER COUNT: " + DICTIONARY.get(word).getWORDLength());
		System.out.println("\tFREQUENCY VALUE: " + DICTIONARY.get(word).getFREQUENCY());
		
		System.out.println("\tDIFFICULTY: " + usedWords(word).getWordDifficulty());
		
		//setFileRevisions(word, "TEST2");
	}
	
	public static void setDICTIONARY() throws Exception {
		GetDictionary getDictionary = new GetDictionary();
		getDictionary.getWord();
	}
	
	public Map<String, Word> getDICTIONARY() {
		return DICTIONARY;
	}
	
	private static ComputeWordDifficulty usedWords(String word) {
		
		USED_WORD.put(word, new ComputeWordDifficulty(word.length(), DICTIONARY.get(word).getFREQUENCY(), word));
		
		return USED_WORD.get(word);
	}
	
	private static String getWord() {
		String inputWord;
		String properWord;
		
		System.out.print("\n\tSearch for a word: ");
		
		inputWord = new Scanner(System.in).next();
		
		try {
			properWord = DICTIONARY.get(inputWord).getWORD();
			return properWord;
			
		} catch (NullPointerException e) {
			properWord = levenshteinComparison(inputWord);
			
			System.out.println("_____________________\n" +
					                   "*WORD NOT FOUND. THE CLOSEST WORD WAS: " + properWord + "*\n" +
					                   "_____________________");
			return properWord;
		}
	}
	
	private static String levenshteinComparison(String word) {
		final Map<String, Integer> costForAllWords = new LinkedHashMap<>();
		
		//double startN = System.nanoTime();
		
		for (String DICTIONARY_WORD :
				DICTIONARY.keySet()) {

			costForAllWords.put(DICTIONARY_WORD, new LevenshteinDistance(word, DICTIONARY_WORD).returnCost());
		}
		
		Map.Entry<String, Integer> minEntry = null;
		
		for (Map.Entry<String, Integer> entry : costForAllWords.entrySet()) {
			if (minEntry == null ||
					    entry.getValue().compareTo(minEntry.getValue()) < 0) {
				minEntry = entry;
				//System.out.println(minEntry);
			} else if (entry.getValue().compareTo(minEntry.getValue()) == 0 &&
					    DICTIONARY.get(entry.getKey()).getFREQUENCY() > DICTIONARY.get(minEntry.getKey()).getFREQUENCY()) {
				minEntry = entry;
			}
		}
/*		System.out.println();
		
		System.out.println("\t\tThe minimum cost was: " + minEntry.getValue());
		
		double endN = System.nanoTime();
		
		System.out.println("\t\tElapsed time (ms): " + ((endN - startN) / 1000000) + "\n");*/
		assert minEntry != null;
		return minEntry.getKey();
	}
	
	public String getLevenshteinComparison(String word) {
		return levenshteinComparison(word);
	}
	
/*	private static void getLetter() {
		boolean validInput;
		do {
			System.out.print("Enter a new letter: ");
			String letter = new Scanner(System.in).next().toUpperCase();
			
			validInput = checkLetterInput(letter);
			
		} while (!validInput);
	}
	
	private static boolean usedLetters(char letter) {
		for (char c :
				USED_LETTER) {
			if (letter == c)
				return false;
		}
		USED_LETTER.add(letter);
		
		return true;
	}
	
	private static boolean checkLetterInput(String letter) {
		if (letter.length() > 1) {
			System.out.println("*Enter a single letter*");
			return false;
		}
		
		if (!Character.isLetter(letter.charAt(0))) {
			System.out.println("*Solely enter an alphabetical character*");
			return false;
		}
		
		if (!usedLetters(letter.charAt(0))) {
			System.out.println("*Letter used. Choose a different letter*");
			return false;
		}
		return true;
	}*/
	
	private static String getRootWord(String word) {
		return new WordExceptions(word).getRootWord();
	}
	
	private static void setFileRevisions(String word, String revision) {
		WriteToFileRevisions fileRevisions = new WriteToFileRevisions(word, revision);
		
		fileRevisions.writeToFile();
	}
	
	private static void reviseWord() {
		System.out.println("\n\tWas the word suggestion accurate?\n" +
				                   "\tENTER a replacement [WORD] or PRESS [ENTER] to continue.");
	}
}
