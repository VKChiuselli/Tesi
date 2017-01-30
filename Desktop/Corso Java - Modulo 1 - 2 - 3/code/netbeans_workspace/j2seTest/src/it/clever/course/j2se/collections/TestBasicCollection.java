package it.clever.course.j2se.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.text.html.InlineView;

public class TestBasicCollection {

	public static void main(String[] args) {
		
		Collection<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(4);
		intList.add(3);
		intList.add(5);
		
		
		Collection<Integer> intList2 = new ArrayList<Integer>();
		intList2.add(1);
		intList2.add(2);
		intList2.add(3);
		intList2.add(4);
		

		System.err.println(intList.containsAll(intList2));
		
/*
		// Aggiunge elementi ad una collezione
 
	    addAll(intList, intList2);
	    printCollection(intList);
*/		
/*		
 		// Rimuove elemento da una collezione
*/
		removeElementByCollection(intList, new Integer(1));
	    printCollection(intList);


/*
		intList.retainAll(intList2);
		printCollection(intList);
*/	
/*		
		Object[] retArray = toArray(intList);
		for(Object o : retArray) {
			System.out.println(o);
		}
*/		
		
	}

	/**
	 * Metodo che permette la stampa a video di 
	 * tutti gli elementi di una collection.
	 * 
	 * @param collectionToPrint
	 */
	private static void printCollection(Collection<? extends Object> collectionToPrint) {
		
		for(Object o : collectionToPrint ) {
			System.out.println(o);
		}
	}
	
	
	/**
	 * Metodo che permette di aggiungere gli elementi di una collection
	 * coll2 alla collection coll1.
	 * @param coll1
	 * @param coll2
	 */
	private static void addAll(Collection  coll1, Collection  coll2) {
		
		coll1.addAll(coll2);
	}
	
		
		
	/**
	 * Metodo che rimuove un oggetto se presente nella collezione
	 * @param collection
	 * @param toRemove
	 */
	private static void removeElementByCollection(Collection<? extends Object> collection, Object toRemove) {
		
/*		
		// Si pu� direttamente rimuovere da una collezione.
		if(collection.contains(toRemove)) {
			collection.remove(toRemove);
		}
*/		
		// Oppure iterare per le verifiche nel caso di una iterazione.
		Iterator<? extends Object> iterator = collection.iterator();
		while(iterator.hasNext()) {
			Object i = iterator.next();
			if(i.equals(toRemove)) {
				iterator.remove();
			}
		}		
	}
	
	/**
	 * 
	 * @param collection
	 * @return
	 */
	private static Object[] toArray(Collection<? extends Object> collection) {
		
		Object[] retArray = new Object[collection.size()];
		
		Object[] tempArray = collection.toArray(retArray);
		for(Object o : tempArray) {
			System.out.println("Array temporaneo: " + o);
		}
		
		return retArray;
	}
	
}
