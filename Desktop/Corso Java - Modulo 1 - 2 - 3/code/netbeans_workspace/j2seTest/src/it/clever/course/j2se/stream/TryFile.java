package it.clever.course.j2se.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryFile {

	public static final String CUSTOMER_SOURCE_FILE = "customers.txt";
	public static final String CUSTOMER_DEST_FILE = "customers_dest.txt";
	
	/**
	 * Classe che espone metodi per lettura/scrittura ed utilizzo di files.
	 */
	public static void main(String[] args) {
		
		try {
			
			listDir(".");
			makeDir("prova");
			String sourceFile = ClassLoader.getSystemResource("resources//").getFile() + CUSTOMER_SOURCE_FILE;
			String destFile = ClassLoader.getSystemResource("resources//").getFile() + CUSTOMER_DEST_FILE;
			
			copy(sourceFile, destFile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	
	/**
	 * Metodo che stampa tutte le sottodirectory e file di una directory
	 * passata come parametro.
	 * @throws IOException 
	 */
	private static void listDir(String dirName) throws IOException{
		
		File dirTolist = null;
		if(dirName == null){
			//Se il nome inserito è null viene considerato acome default la directory corrente.
			dirTolist = new File(".");
			dirName = dirTolist.getCanonicalPath();
		}else{
			dirTolist = new File(dirName);
		}		
		if(dirTolist.isDirectory()){
			System.out.println("Directory contenute in " + dirName + "\n");
			String[] dirlist = dirTolist.list();
			for(int i = 0; i < dirlist.length; i++){				
				System.out.println(dirlist[i]);
			}
		}else{
			System.out.println("Il nome inserito non è riconducibile ad una directory!");
		}
	}

	/**
	 * Metodo che crea una directory il cui nome viene passato come parametro.
	 * Se essa esiste, la rinomina e ne crea una nuova.
	 * @throws IOException 
	 *
	 */
	private static void makeDir(String dirName) throws IOException{

		File dirToreanme = null;
		if(dirName == null){
			//Se il nome inserito è null viene considerato acome default la directory corrente.
			dirToreanme = new File(".");
			dirName = dirToreanme.getCanonicalPath();
		}else{
			dirToreanme = new File(dirName);
		}
		if(dirToreanme.exists()){
			dirToreanme.renameTo(new File(dirToreanme.getName()+ "_old"));
			dirToreanme.mkdir();
		}else{
			dirToreanme.mkdir();
		}
	}
	
	private static void copy(String sourceFile, String destFile) throws IOException {
		try {
			FileInputStream in = new FileInputStream(sourceFile);
			FileOutputStream out = new FileOutputStream(destFile);
			while(true) {
				int data = in.read();
				if(data == -1){
					break;	
				}else{
					out.write(data);
				}
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
