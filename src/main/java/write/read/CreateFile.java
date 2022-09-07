package write.read;

import main.logic.InfoPerson;

import java.io.*;
import java.util.Scanner;

public class CreateFile implements WriteAndRead { // шаблон FactoryMethod + Singleton
	private static final CreateFile instance = new CreateFile();
	private final String directory = "FolderOfFiles/";
	private final File direct = new File(directory);
	int countOfPerson = 0;
	private String nameOfFile;
	private Scanner fileSk;

	public static CreateFile getInstance () {
		return instance;
	}
	@Override
	public void write (InfoPerson obj) {
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
	private void writeOnFile(InfoPerson obj, File file) {
		try (FileWriter writer = new FileWriter (file, false)) {
			writer.write(obj.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private int giveCount() {
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
	private void setCount(Integer lastCount) {
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
	@Override
	public void read (int id) {
		countOfPerson = id;
		nameOfFile = "id_" + countOfPerson + "_person.txt";
		File file = new File(directory + nameOfFile);
		try {
			fileSk = new Scanner(file);
			System.out.println("FILE FOUND");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("NO FOUND");
		}
		System.out.println(directory + nameOfFile);
		InfoPerson person = new InfoPerson();
		person.readPerson(fileSk);
		person.showInfo();
//		saveInfoInLabel(person);
	}

//	private static void saveInfoInLabel(InfoPerson obj) {
//		MainOfFrame.labelFoundName.setText("Имя: " + obj.getName());
//		MainOfFrame.labelFoundFamily.setText("Фамилия: " + obj.getFamily());
//		MainOfFrame.labelFoundAge.setText("Возраст: " + obj.getAge());
//	}
}
