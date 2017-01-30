package it.clever.course.j2se.base;

public class Switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int control = 4;
		System.out.println("control = "+ control + "\n");
		
		System.out.println("\nInizio verifica condizionale tramite costrutto switch\n");
		
		switch(control) {
		
			case 1: {
				System.out.println(1);
				break;
			}
			
			case 2: {
				System.out.println(2);
				
			}
			case 3: {
				System.out.println(3);
				break;
			}
			case 4: {
				System.out.println(4);
			}
			case 5: {
				System.out.println(5);
			}
			case 6: {
				System.out.println(6);
			}
			default: {
				System.out.println("def");
			}
		}
		
		System.out.println("\nInizio verifica condizionale tramite if\n");
		if(control == 1) {
			System.out.println(1);
		} else if(control == 2) {
			System.out.println(2);
		} else {
			System.out.println("def");
		}

	}

}
