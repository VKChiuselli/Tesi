package it.clever.course.j2se.exceptions;

public class MultiCatch {

	public static void main(String args[]) {
		
		int array[] = { 20, 10, 30 };
		
		int num1 = 15, num2 = 1;
		int res = 0;
		
		try {
			// Esecuzione della divisione.
			res = num1 / num2;
			System.out.println("The result is" + res);
			
			// Stampa al contrario degli elementi dell'array.
			for (int ct = 5; ct >= 0; ct--) {
				System.out.println("value index " + ct + ": " + array[ct]);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Errore. Array is out of Bounds");
		} catch (ArithmeticException e) {
			System.out.println("Can't be divided by Zero");
		}
	}
}
