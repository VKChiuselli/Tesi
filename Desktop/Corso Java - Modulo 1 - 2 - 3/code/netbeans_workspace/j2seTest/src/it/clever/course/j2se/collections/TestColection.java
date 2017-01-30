package it.clever.course.j2se.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class TestColection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		String[] strArray = new String[10];
		
		for(int i =0; i < strArray.length; i++) {
			System.out.println("Inserisci il successivo valore.");
			String str = scanner.next();
			strArray[i] = str;
		}
		
		Collection<String> collection = fromArrayToCollection(strArray);
		
		printCollection(collection);
	}
	
	public static Collection<String> fromArrayToCollection(String[] array) {
		
		Collection<String> retColl = new ArrayList<String>();
		
		for(String s : array) {
			retColl.add(s);
		}
		return retColl;
	}
	
	public static void printCollection(Collection<String> collToPrint) {
		
		for(String str : collToPrint) {
			System.out.println(str);
		}
	}

}
