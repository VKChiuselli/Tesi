package it.clever.course.j2se.inheritance.interfaces.classes;

import it.clever.course.j2se.inheritance.interfaces.ActionListener;
import it.clever.course.j2se.inheritance.interfaces.InterfaceA;
import it.clever.course.j2se.inheritance.interfaces.InterfaceC;

public abstract class AbstractClass implements InterfaceC {

	private ActionListener actionListener; 
	

	public void addActionListener(ActionListener al) {
		this.actionListener = al;
	}


	@Override
	public void execute(AbstractClass toExecute) {
		
		this.actionListener.onPreExecute();
		
		f();
		
		this.actionListener.onPostExecute();
	}
	
	
}
