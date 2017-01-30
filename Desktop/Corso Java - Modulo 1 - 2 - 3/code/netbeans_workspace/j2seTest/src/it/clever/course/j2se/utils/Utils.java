/**
 * <b> Utils.java</b>
 * 
 * <br/>
 * 
 * Classe con metodi di utilità.
 * 
 */
package it.clever.course.j2se.utils;

import java.util.Collection;
import java.util.Iterator;

/**      
 * @author 2Clever
 *
 */
public class Utils {

	/**
	 * Metodo per operazionhi di filtro ed eliminazione su elementi null di una collezione.
	 * @param c
	 */
	public static void filter(Collection c) {
		
		for(Iterator i = c.iterator(); i.hasNext();) {
			if(i.next() == null) {
				i.remove();
			}
		}
	}
}
