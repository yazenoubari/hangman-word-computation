public class Word {
	private final double FREQUENCY;
	private final String WORD;
	
	public Word(double frequency, String word){
		this.FREQUENCY = frequency;
		this.WORD = word;
	}
	
	public double getFREQUENCY() {
		return FREQUENCY;
	}
	
	public String getWORD() {
		return WORD;
	}
	
	public int getWORDLength() {
		return WORD.length();
	}
}
