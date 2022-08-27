import java.io.File;
import java.io.IOException;

public class testCreateFile {
	static String directory = "FolderOfFiles/";
	File direct = new File(directory);
	static int countOfPerson = 0;
	static String nameOfFile;

	public static void main(String[] args) {
		String name = "Ann";
		String family = "Hallo";
		int age = 15;
		final String sp = System.getProperty("line.separator");
		System.out.println(String.format("%s\r\n%s\r\n%s", age, name, family));

	}
	public static void create2 () {
		countOfPerson ++;
		nameOfFile = "id_" + countOfPerson + "_person.txt";
		File file = new File(directory + nameOfFile);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}

}
