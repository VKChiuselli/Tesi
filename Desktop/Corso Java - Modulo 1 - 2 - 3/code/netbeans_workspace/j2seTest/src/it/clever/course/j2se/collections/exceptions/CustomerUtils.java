package it.clever.course.j2se.collections.exceptions;

import it.clever.course.j2se.collections.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CustomerUtils {

	
	public static final int CUSTOMER_MAX_LIST = 3;
	public static final int STREAM_TYPE_STANDARD_INPUT = 0;
	public static final int STREAM_TYPE_FILE = 1;
	public static final String CUSTOMER_SOURCE_FILE = "customers.txt";

	
	public static List<Customer> readCustomer(int streamType) {
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		if(streamType == STREAM_TYPE_STANDARD_INPUT) {
			
			boolean continueAsking = true;
			while(continueAsking) {
					
					try {
						
							customerList.add(readCustomerFromStream());
							if(Customer.getCounter() == CUSTOMER_MAX_LIST) {
								continueAsking = false;
							}
						
					} catch (Exception e) {
						
						System.err.println("\nErrore durante la creazione del customer: " + e + "\n");
						continueAsking = true;
					}
			}
			
		} else if(streamType == STREAM_TYPE_FILE) {
			
			try {
				customerList = readCustomerFromfile();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return customerList;
	}
	
	/**
	 * Metodo per la lettura dei dati del nuovo customer.
	 * @return
	 * @throws IOException
	 */
	private static Customer readCustomerFromStream() throws IOException, Exception{
		
		Customer newOne = null;
		
		// Lettura dello stream.
		BufferedReader msgStream = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nInserisci il nome del cliente:\n");
		
		String name = msgStream.readLine();		
		if(name.equalsIgnoreCase("Pippo")) {
			newOne.toString();
		}
		System.out.print("\nInserisci il cognome del cliente:\n");			
		String surname = msgStream.readLine();
		
		
		newOne = new Customer(name, surname);
		
		return newOne;
	}
	
	
	/**
	 * @throws Exception 
	 * Legge la lista di customer da file.
	 * @return
	 * @throws  
	 */
	public static List<Customer> readCustomerFromfile() throws Exception  {
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		String sourceFile = ClassLoader.getSystemResource("resources//").getFile() + CUSTOMER_SOURCE_FILE;
		FileReader in = new FileReader(sourceFile);
		BufferedReader br = new BufferedReader(in);
		
		String line = null;
		try {
			
			while((line = br.readLine()) != null) {
				//out.write(line);
				String[] tokens = line.split(";");
				Customer c = new Customer(tokens[0], tokens[1]);
				customerList.add(c);
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
		
		return customerList;
	}



}
