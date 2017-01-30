package it.clever.course.j2se.base;

public class StringUtil {

	/**
	 * Metodo che restituisce la lunghezza di una stringa passata come parametro.
	 * @param str
	 * @return
	 */
	public static int getStringLenght(String str) {
		
		if(str == null || str.isEmpty()) {
			return 0;
		}
		
		return str.length();
	}
	
	/**
	 * Metodo che restituisce la composizione tra due stringhe.
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String getStringComposition(String str1, String str2) {
		
		String retString = "stringhe vuote";
		
		if(str1 != null && !str1.isEmpty()) {
			
			retString = str1;
		}
		
		if(str2 != null && !str2.isEmpty()) {
			
			retString += str2;
		}
		return retString;
		
	}
	
	public static void main(String[] args) {
		System.out.println(getStringComposition("str1", "str2"));
	}
}
