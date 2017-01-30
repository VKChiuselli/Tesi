package it.clever.course.j2se.inheritance.interfaces.classes;

import it.clever.course.j2se.inheritance.interfaces.InterfaceB;

class ClassB extends AbstractClass implements InterfaceB {

	
	@Override public void f() {
		System.out.println("ClassB.f()");		
	}

	@Override public void g() {
		System.out.println("ClassB.g()");		
	}

}
