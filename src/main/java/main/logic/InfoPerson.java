package main.logic;

import java.util.Scanner;

public class InfoPerson {
	private String name;
	private String family;
	private int age;
	
	public InfoPerson() {
		
	}
	public InfoPerson(String name, String family, int age) {
		this.name = name;
		this.family = family;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public String getFamily() {
		return family;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return String.format("%s\r\n%s\r\n%s\r\n", name, family, age);	
	}
	
	public void showInfo() {
		System.out.println(name);
		System.out.println(family);
		System.out.println(age);
	}
	
	public void readPerson (Scanner fileSk) {
		name = fileSk.nextLine();
		family = fileSk.nextLine();
		age = fileSk.nextInt();
		fileSk.nextLine();
	}
	
	public void savePerson () {
		
	}
}
