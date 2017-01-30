package it.clever.course.j2se.collections;

import java.util.ArrayList;
import java.util.Collection;

public class ForeachTest {
	
	  public static void main(String[] args) {
	    
		
		Collection<String> coll = new ArrayList<String>();
	    
	    //utilizziamo l�array di argomenti
	    //for-in su array
	    for(String tmp:args){
	      coll.add(tmp);
	    }
	    
	    //coll.add("stringa1");
	    //coll.add("stringa2");
	    
	    
/*	    
	    for(int i =0; i < args.length; i++) {
	    	String tmp = args[i];
	    	coll.add(tmp);
	    }
*/	    
	    if(coll.isEmpty()) {
	    	coll.addAll(System.getProperties().stringPropertyNames());
	    }
	    	    
	    //stampiamo la collezione
	    //for-in su collection
	    for(String tmp:coll){
	      System.out.println(tmp);
	    }
	  }
	} 
