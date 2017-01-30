package it.clever.course.j2se.inheritance.interfaces;

import it.clever.course.j2se.inheritance.interfaces.classes.AbstractClass;

public interface InterfaceC extends InterfaceA, InterfaceB {

	public static final int MAX_REPEAT = 2;
	public static final String CLASS_A = "A";
	public static final String CLASS_B = "B";
	
	public void execute(AbstractClass toExecute);
}
