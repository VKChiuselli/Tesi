package it.clever.course.j2se.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void testRemoveAll() {
		Collection<Integer> c = new LinkedList<Integer>();
		Collection<Integer> t = new LinkedList<Integer>();

		c.add(1);
		c.add(2);
		c.add(3);
		t.add(1);
		t.add(2);
		
		System.out.println("La cllezione è cambiata? \n" + c.removeAll(t));
		
		Iterator<Integer> it = c.iterator();
		System.out.println("\nStampa elementi Collection c:\n");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	private void removeCollection(Collection<Object> coll1, Collection<Object> coll2 ) {
		
		if(coll1 != null) {
			coll1.removeAll(coll2);
		}
	}
	
	public static void main(String[] args) {
		testRemoveAll();
	}
}
