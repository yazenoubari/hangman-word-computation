public class ComputeWordDifficulty extends WordChecker {
	private final int wordLength;
	private final double frequency;
	private final String WORD;

	
	public ComputeWordDifficulty(int wordLength, double frequency, String word) {
		this.wordLength = wordLength;
		this.frequency = frequency;
		this.WORD = word;
	}
	
	public difficulty_Enum getWordDifficulty() {
		
		double difficulty = (Math.sqrt(Math.log10(frequency + 5) - (Math.sqrt((double)wordLength / 50)) + 0.31)) / 1.03175323946D;
		
		difficulty += new WordExceptions(WORD).getFrequencyChange();
		
		if (frequency == 0D)
			difficulty -= 0.15;
		
		System.out.println("\n\t" + "Computed difficulty: " + difficulty);
		
		if (difficulty >= 0.798)
			return difficulty_Enum.EASY;
		else if (difficulty < 0.798 && difficulty >= 0.745)
			return difficulty_Enum.MEDIUM;
		else
			return difficulty_Enum.HARD;
	}
	
	private enum difficulty_Enum {
		EASY,
		MEDIUM,
		HARD
	}
}
