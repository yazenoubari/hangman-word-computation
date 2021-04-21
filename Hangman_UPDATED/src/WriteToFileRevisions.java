import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileRevisions {
	
	private final String REVISION;
	private final String WORD;
	
	WriteToFileRevisions(String word, String revision) {
		this.WORD = word;
		this.REVISION = revision;
		
		newFile();
	}
	
	public void newFile() {
		try {
			File myObj = new File("word_revisions.txt");
			if (myObj.createNewFile())
				System.out.println("\n\tFile created: " + myObj.getName() + "\n");
			else
				System.out.println("file already made");
		} catch (IOException ioException) {
			System.out.println("\n\t*ERROR: IOException*\n");
			ioException.printStackTrace();
		}
	}
	
	public void writeToFile() {
		try {
			FileWriter revisions = new FileWriter("word_revisions.txt", true);
			revisions.write(WORD + " " + REVISION + "\n");
			revisions.close();
		} catch (IOException ioException) {
			System.out.println("\n\t*ERROR: IOException*\n");
			ioException.printStackTrace();
		}
	}
}
