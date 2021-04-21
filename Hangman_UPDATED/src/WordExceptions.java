public class WordExceptions extends WordChecker {
	
	private final String WORD;
	private double FREQUENCY_CHANGE;
	private final int WORD_LENGTH;
	
	WordExceptions(String word) {
		this.WORD = word;
		this.WORD_LENGTH = word.length();
	}
	
	private String rootWord() {
		
		String WORD_NESS;
		String WORD_ING;
		String WORD_ED;
		String WORD_S;
		
		try {
			WORD_NESS = WORD.substring(0, WORD_LENGTH - 4);
		} catch (Exception exception) {
			//System.out.println("error");
			WORD_NESS = WORD;
			//System.out.println(WORD_NESS);
		}
		
		try {
			WORD_ING = WORD.substring(0, WORD_LENGTH - 3);
		} catch (Exception exception) {
			//System.out.println("error");
			WORD_ING = WORD;
			//System.out.println(WORD_ING);
		}
		
		try {
			WORD_ED = WORD.substring(0, WORD_LENGTH - 2);
		} catch (Exception exception) {
			//System.out.println("error");
			WORD_ED = WORD;
			//System.out.println(WORD_ED);
		}
		
		try {
			WORD_S = WORD.substring(0, WORD_LENGTH - 1);
		} catch (Exception exception) {
			//System.out.println("error");
			WORD_S = WORD;
			//System.out.println(WORD_ED);
		}
		
		String rootWord = "*not applicable*";
		
		try {
			if (WORD.lastIndexOf("ness") == (WORD.length() - 4)) { //&& Objects.equals(WORD_NESS, super.getDICTIONARY().get(WORD_NESS).getWORD())) {
				System.out.println("\n\t\t-NESS: ADJECTIVE to NOUN\n");
				
				rootWord = super.getLevenshteinComparison(WORD_NESS);
				FREQUENCY_CHANGE = 0.02;
				
			} else if (WORD.lastIndexOf("ing") == (WORD_LENGTH - 3)) { //&& (Objects.equals(WORD_ING, super.getDICTIONARY().get(WORD_ING).getWORD()))) {
				System.out.println("\n\t\t-ING: CONTINUOUS\n");
				
				rootWord = super.getLevenshteinComparison(WORD_ING);
				FREQUENCY_CHANGE = 0.02;
				
			} else if (WORD.lastIndexOf("ed") == (WORD.length() - 2)) { //&& Objects.equals(WORD_ED, super.getDICTIONARY().get(WORD_ED).getWORD())) {
				System.out.println("\n\t\t-ED: PAST (generalized)\n");
				
				rootWord = super.getLevenshteinComparison(WORD_ED);
				FREQUENCY_CHANGE = 0.02;
				
			} else if (WORD.lastIndexOf("s") == (WORD.length() - 1)) { //&& Objects.equals(WORD_ED, super.getDICTIONARY().get(WORD_ED).getWORD())) {
				System.out.println("\n\t\t-S: PLURAL\n");
				
				rootWord = super.getLevenshteinComparison(WORD_S);
				FREQUENCY_CHANGE = 0.02;
/*			} else if (WORD.lastIndexOf("s") == (WORD.length() - 1) && WORD_S.equals(super.getDICTIONARY().get(WORD_S).getWORD())) {
				System.out.println("\t\nPLURAL WORD");
				
				this.FREQUENCY_CHANGE = 0.02;**/
			} else {
				//System.out.println("else");
				FREQUENCY_CHANGE = 0D;
			}
		} catch (Exception ignored) {}
		
		//System.out.println(rootWord);
		return rootWord;
	}
	
	public double getFrequencyChange() {
		return FREQUENCY_CHANGE;
	}
	
	public String getRootWord() {
		return rootWord();
	}
}
