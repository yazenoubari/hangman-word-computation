import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GetDictionary extends WordChecker {
	
	public void getWord() throws Exception {
		
		File dictionaryByFrequency = new File("dictionaryByFrequency.txt");
		BufferedReader readDictionaryWithFrequency = new BufferedReader(new FileReader(dictionaryByFrequency));
		
		String lineWithFrequency;
		
		while ((lineWithFrequency = readDictionaryWithFrequency.readLine()) != null) {
			String[] dataInString = lineWithFrequency.split(" ");
			
			String word = dataInString[0];
			double frequency = Double.parseDouble(dataInString[1]);
			
			super.getDICTIONARY().put(word, new Word(frequency, word));
		}
		
		File dictionary = new File("dictionary.txt");
		BufferedReader readDictionary = new BufferedReader(new FileReader(dictionary));
		
		String word;
		while ((word = readDictionary.readLine()) != null) {
			if (!super.getDICTIONARY().containsKey(word))
				super.getDICTIONARY().put(word, new Word(0D, word));
		}
	}
}
