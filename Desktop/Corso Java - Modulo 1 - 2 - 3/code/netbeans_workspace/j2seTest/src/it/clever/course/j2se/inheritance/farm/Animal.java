package it.clever.course.j2se.inheritance.farm;

public abstract class Animal implements Cloneable {

	protected int legs;
	protected String name = null;
	
	protected abstract String getCry();
	
	protected  Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int zampe) {
		this.legs = zampe;
	}
	
	
}
