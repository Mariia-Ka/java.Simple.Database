//package write.read;
//
//import user.interf.MainOfFrame;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class SearchFile {
//	static String directory = "FolderOfFiles/";
//	File direct = new File(directory);
//	static int countOfPerson = 1;
//	static String nameOfFile;
//	static Scanner fileSk;
//
//	public static void search (int id) {
//		countOfPerson = id;
//		nameOfFile = "id_" + countOfPerson + "_person.txt";
//		File file = new File(directory + nameOfFile);
//		try {
//			fileSk = new Scanner(file);
//			System.out.println("FILE FOUND");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("NO FOUND");
//		}
//		System.out.println(directory + nameOfFile);
//		InfoPerson person = new InfoPerson();
//		person.readPerson(fileSk);
//		person.showInfo();
//		saveInfoInLabel(person);
//		}
//
//	private static void saveInfoInLabel(InfoPerson obj) {
//		MainOfFrame.labelFoundName.setText("Имя: " + obj.getName());
//		MainOfFrame.labelFoundFamily.setText("Фамилия: " + obj.getFamily());
//		MainOfFrame.labelFoundAge.setText("Возраст: " + obj.getAge());
//	}
//
//}
