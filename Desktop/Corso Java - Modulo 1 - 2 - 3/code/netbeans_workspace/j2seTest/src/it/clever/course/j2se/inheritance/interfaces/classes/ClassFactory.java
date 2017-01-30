package it.clever.course.j2se.inheritance.interfaces.classes;

import it.clever.course.j2se.inheritance.interfaces.InterfaceB;
import it.clever.course.j2se.inheritance.interfaces.InterfaceC;

public class ClassFactory {

	/**
	 * Metodo che restituisce una classe A o B a seconda del flag passato.
	 * @param var
	 * @return
	 */
	public AbstractClass buildClassType(String var) {
		
		if(InterfaceC.CLASS_A.equals(var)) {
			
			return new ClassA();
			
		} else if(InterfaceC.CLASS_B.equals(var)) {
			return new ClassB();
		}
			
		return null; 
	}

	/**
	 * Metodo che restituisce una istanza dell'interfaccia InterfaceB.
	 * @param var
	 * @return
	 */
	public InterfaceB buildClassTypeB() {
		
		return new ClassB();
	}
}
