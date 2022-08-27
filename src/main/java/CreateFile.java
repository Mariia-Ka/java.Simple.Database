import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CreateFile {
	static String directory = "FolderOfFiles/";
	static File direct = new File(directory);
	static int countOfPerson = 0;
	static String nameOfFile;
	
	public static void create (InfoPerson obj) {
		countOfPerson = giveCount();
		nameOfFile = "id_" + countOfPerson + "_person.txt";
		File file = new File(directory + nameOfFile);
		setCount(countOfPerson);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writeOnFile(obj, file);
	}
	private static void writeOnFile(InfoPerson obj, File file) {
		ConnectToBase.add(ConnectToBase.createInfoForBase(obj));
		try (FileWriter writer = new FileWriter (file, false)) {
			writer.write(obj.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private static int giveCount() {
		File file = new File(directory + "countOfPerson.txt");
		Scanner diskSk;
		int countOfPerson = 0;
		try {
			diskSk = new Scanner(file);
			countOfPerson = diskSk.nextInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return countOfPerson+1;
	}
	private static void setCount(Integer lastCount) {
		File file = new File(directory + "countOfPerson.txt");
		if (!direct.exists()) {
			direct.mkdir();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try (FileWriter writer = new FileWriter (file, false)) {
			writer.write(lastCount.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
