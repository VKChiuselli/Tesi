package it.clever.course.j2se.stream;

import it.clever.course.j2se.collections.Customer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TryStream {


	public static void main(String[] args) {
		
		URL url = ClassLoader.getSystemResource("resources//");
		
		String sourceFile = url.getFile() + "source.txt";
		String destFile = url.getFile() + "destination.txt";
		String custFile = url.getFile() + "customers.txt";
		
		//simpleOut();
		
		try {
			//echo(sourceFile);
			//fileEcho(sourceFile, destFile);
			readData(custFile);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	private static void simpleOut(){
		String[] arg1  = {"Ciao!", "sono", "uno", "stream"};
		for(int i = 0; i < arg1.length; i++ ){
			
			synchronized (System.out){
				
				for(int j = 0; j< arg1[i].length(); j++ ){
					System.out.write(arg1[i].charAt(j));
					System.out.write('\n');
					System.out.flush();
				}
			}
		}
		
	}
	

	private static void echo(String sourceFile) throws IOException {
		
		//Stream che legge il contenuto da file
		InputStream in = new FileInputStream(sourceFile);
		boolean cont = true;
		
		int i = -1;
		while((i = in.read()) != -1) {
			//Legge un byte alla volta fino al termine del file
			 //i = in.read();
	
				System.out.print((char)i);	
					
		}
		in.close();
	}
	
	private static void fileEcho(String sourceFile, String destFile) throws IOException {
		
		//Stream che legge il contenuto da file
		
		FileReader in = new FileReader(sourceFile);

		BufferedReader br = new BufferedReader(in);
		
		FileOutputStream fos = new FileOutputStream(destFile);
		PrintStream ps = new PrintStream(fos);
		
		String line = null;
		while((line = br.readLine()) != null) {
			//out.write(line);
			ps.println(line);
		}
	
		//ps.flush();
		ps.close();
		br.close();
		
		System.out.println("Copia avvenuta");
	}
	
	private static void readData(String file) throws Exception {
		
		FileReader in = new FileReader(file);
		BufferedReader br = new BufferedReader(in);
		
		List<String[]> tokenList = new Vector<String[]>();
		
		String line = null;
		try {
			
			while((line = br.readLine()) != null) {
				//out.write(line);
				String[] tokens = line.split(";");
				tokenList.add(tokens);
			}
			
			// Stampa dei cutomer.
			for(int i = 0; i < tokenList.size(); i++) {
				System.out.println("Customer " + i);
				String[] token = tokenList.get(i);
				
				for(String t : token) {
					System.out.println(t);
				}
				System.out.println("\n");
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			throw new Exception(e);
			
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
