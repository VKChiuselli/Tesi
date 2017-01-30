package it.clever.course.j2se.inheritance.farm;

import java.sql.Timestamp;
import java.util.Date;

public class Farm {

	
	private static Animal[] animals = null; 
	
	public static void main(String[] args) {
		
		animals = new Animal[2];
		
		Dog dog = new Dog("Billy", 4, "Zac");
		animals[0] = dog;
		Cat cat = new Cat("Fuffy", 4);
		animals[1] = cat;
		
		for(int i = 0; i< animals.length; i++){
			System.out.println(animals[i].getCry());
		}
		
		//Clonazione di un Cane
		try {
			
			Dog cloneD = (Dog)tryClone(dog);
			cloneD.getParassita().setName("ZacZac");
						
			System.out.println("Il cane " + dog.getName() + " ha una pulce di nome " + dog.parassita.getName());
			System.out.println("Il cane clonato" + cloneD.getName() + " ha una pulce di nome " + cloneD.parassita.getName());
			
			System.out.println("Le due pulci sono uguali = " + (dog.parassita == cloneD.parassita));
			
			System.out.println("Nuovo nome assegnato alla pulce clonata:");
			cloneD.getParassita().setName("Zac2");

			System.out.println("Il cane " + dog.getName() + " ha una pulce di nome " + dog.parassita.getName());
			System.out.println("Il cane clonato" + cloneD.getName() + " ha una pulce di nome " + cloneD.parassita.getName());
			
			//Clacolo tempi e performances
			
			System.out.println("\nClacolo tempi e performances:\n");
			System.out.println("Start creating.. " + (new Timestamp(new Date().getTime()).toString()));
			Cat clone = new Cat(cat);
			System.out.println("Stop creating.. " + (new Timestamp(new Date().getTime()).toString()));
			
			System.out.println("Start cloning.. " + (new Timestamp(new Date().getTime()).toString()));
			Cat clone2 = (Cat)cat.clone();
			System.out.println("Stop cloning.. " + (new Timestamp(new Date().getTime()).toString()));
			
			
			
			
		} catch (CloneNotSupportedException e) {
			System.err.println("Errore nella clonazione");
			e.printStackTrace();
		}
	}

	private static Object tryClone(Object objToclone) throws CloneNotSupportedException{
		
		if (objToclone instanceof Dog) {
			return ((Dog)objToclone).clone();
			
		}else {
			return ((Cat)objToclone).clone();
		}
		
	}
}

