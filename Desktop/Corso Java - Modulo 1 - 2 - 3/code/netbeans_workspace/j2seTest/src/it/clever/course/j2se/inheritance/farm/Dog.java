package it.clever.course.j2se.inheritance.farm;

public class Dog extends Animal {

	public Pulce parassita = null;

	public Dog(String name, int zampe, String par){
		this.name = name;
		this.legs = zampe;
		this.parassita = new Pulce(par);
	}
	
	@Override
	protected String getCry() {		
		return "Bau!";
	}

/*	
	@Override
	protected  Object clone() throws CloneNotSupportedException{
		Dog newD = (Dog)super.clone();
		newD.parassita = (Dog.Pulce)this.parassita.clone();		
		return newD;
	}
*/	
	@Override
	protected  Object clone() throws CloneNotSupportedException{
		return super.clone();
	}


	public Pulce getParassita() {
		return parassita;
	}

	public void setParassita(Pulce parassita) {
		this.parassita = parassita;
	}
	
	
//	class Pulce implements Cloneable {
	class Pulce {
		 String name = null;
		 public Pulce(String name){
			 this.name = name;
		 }
		 
		 public String getName(){
			 return this.name;
		 }
		 public void setName(String newName){
			 this.name = newName;
		 }
		 
		 protected  Object clone() throws CloneNotSupportedException{
			 return super.clone();
		 }
		 
	}	
}

