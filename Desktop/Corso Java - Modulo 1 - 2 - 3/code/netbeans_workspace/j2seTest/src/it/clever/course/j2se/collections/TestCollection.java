package it.clever.course.j2se.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestCollection {

	public static void main(String[] args) {
		
		Collection coll = buildCollection();
		
		Iterator iter = coll.iterator();
		while(iter.hasNext()) {
			Object o = iter.next();
			
			System.out.println(o.toString());
		}
		
		for(Object o : coll) {
			if(o instanceof Integer) {
				Integer i = (Integer)o;
				System.out.println(i.intValue());
			}
			System.out.println(o);
		}
	}
	
	public static Collection buildCollection() {
		
		Collection retColl = new ArrayList();
		
		Integer i = new Integer(1);
		retColl.add("Ciao");
		retColl.add(i);
		retColl.add(Boolean.TRUE);
		
		return retColl;
	}
}
