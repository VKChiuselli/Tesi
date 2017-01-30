package it.clever.course.j2se.base;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(GregorianCalendar.DATE, -800);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy – HH:mm:ss");
		System.out.println(sdf.format(gc.getTime())); 
		
		//System.err.println(new Date(1290100788999l));
		
		 String[] stringList = null;
		 stringList = new String[10];
		 
		 for(int i = 0; i < stringList.length; i++) {
			 
			 stringList[i] = "elemento_" + (i+1);
		 }
		 
		 for(int i = 0; i < stringList.length; i++) {
			 
			 System.out.println(stringList[i]);
		 }
	}

}
