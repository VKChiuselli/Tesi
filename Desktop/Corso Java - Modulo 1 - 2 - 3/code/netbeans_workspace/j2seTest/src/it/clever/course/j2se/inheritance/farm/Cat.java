package it.clever.course.j2se.inheritance.farm;


public class Cat extends Animal {

	
	public Cat(String name, int zampe){
		this.name = name;
		this.legs = zampe;
	}
	
	public Cat(Cat catToclone){
		this.name = catToclone.getName();
		this.legs = catToclone.getLegs();
	}
	
	@Override
	protected String getCry() {		
		return "Miao!";
	}
	
	protected  Object clone() throws CloneNotSupportedException{
		return super.clone();		
	}

	
}
