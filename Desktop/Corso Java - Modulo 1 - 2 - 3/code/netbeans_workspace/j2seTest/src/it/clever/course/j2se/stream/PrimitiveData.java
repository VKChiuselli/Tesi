package it.clever.course.j2se.stream;

import java.io.*;
public class PrimitiveData {
	
		public static void main(String[] args) throws IOException {
			File file = new File("prova.dat");
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
			ps.println("Stringa");
			ps.println(100);
			ps.println(3 / 4.0);
			ps.println('q');
			ps.println((byte) 128);
			ps.println(new char[] { 'C', 'I', 'A', 'O' });
			ps.println(true && false);
			ps.close();
		}
}