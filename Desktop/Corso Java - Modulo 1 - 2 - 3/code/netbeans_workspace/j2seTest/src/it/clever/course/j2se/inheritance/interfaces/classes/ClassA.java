package it.clever.course.j2se.inheritance.interfaces.classes;


class ClassA extends AbstractClass {

	@Override public void f() {
		
		System.out.println("ClassA.f()");
	}

	public void f1() {
		
		System.out.println("ClassA.f1()");
	}

	@Override
	public void g() {
		System.out.println("ClassA.g()");		
	}

}
