package it.clever.course.j2se.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TrySerialization {

	public static void main(String[] args) {
		
		
		try {
			//Serializzazione della data corrente.
			Date today = new Date();
			serializeObj(today, "today.ser");
			Date date = (Date)deserializeObj("today.ser");			
			System.out.println("Oggi è il: " + date.toString());
			
			
			SimpleUser su = new SimpleUser("user", "pwd");
			serializeObj(su, "suuser.ser" );
			SimpleUser su2 = (SimpleUser)deserializeObj("suuser.ser");
			System.out.println("Username: " + su2.getUsername() + " - password: " + su2.getPassword());
			
			//Serializzazione di un bean con un campo di tipo oggetto protetto.
			User user = new User("user", "pwd");
			serializeObj(user, "user.ser" );
			User us = (User)deserializeObj("user.ser");
			System.out.println("Username: " + us.getUsername() + " - password: " + us.getPassword());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void serializeObj(Object toserialObj, String fileName) throws IOException{
		FileOutputStream out = new FileOutputStream(fileName);
		ObjectOutputStream s = new ObjectOutputStream(out);	
		s.writeObject(toserialObj);
		s.flush();
	}
	
	private static Object deserializeObj(String filename) throws IOException, ClassNotFoundException{
		FileInputStream in = new FileInputStream(filename);
			ObjectInputStream s = new ObjectInputStream(in);
			return s.readObject();
	}
}
