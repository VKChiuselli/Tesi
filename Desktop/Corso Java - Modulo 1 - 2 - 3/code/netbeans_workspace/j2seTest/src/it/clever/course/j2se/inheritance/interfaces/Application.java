package it.clever.course.j2se.inheritance.interfaces;

import it.clever.course.j2se.inheritance.interfaces.classes.AbstractClass;
import it.clever.course.j2se.inheritance.interfaces.classes.ClassFactory;


public class Application implements InterfaceC {

	private ClassFactory cf = null;
	
	/**
	 * Cotruttore
	 */
	public Application() {
		this.cf = new ClassFactory();
	}
	
	/**
	 * Metodo che restituisce un array di istanze di tipo InterfaceA.
	 * @return
	 */
	private AbstractClass[] buildAcontainer() {
		
		ClassFactory cf = new ClassFactory();
		AbstractClass i1 = cf.buildClassType(CLASS_A);
		
		i1.addActionListener(new ActionListener() {
			
			@Override
			public void onPreExecute() {
				System.out.println("onPreExecute");
			}
			
			@Override
			public void onPostExecute() {
				System.out.println("onPostExecute");
			}
		});
		
		AbstractClass i2 = cf.buildClassType(CLASS_B);
		
		i2.addActionListener(new ActionListener() {
			
			@Override
			public void onPreExecute() {
				System.out.println("onPreExecute");
			}
			
			@Override
			public void onPostExecute() {
				System.out.println("onPostExecute");
			}
		});
		
		AbstractClass[] retArr = {i1, i2};
		
		return retArr;
	}
	
	@Override
	public void f() {
		
		InterfaceA[] polimorfo = buildAcontainer();
		
		for(InterfaceA ia : polimorfo) {
			
			ia.f();
		}
	}

	@Override
	public void g() {
		
		InterfaceB b = cf.buildClassTypeB(); 
		
		b.g();
	}

	/**
	 * Metodo che esegue il metodo f() per un massimo di MAX_REPEAT.
	 */
	@Override public void execute(AbstractClass toExecute) {
		
		for(int i = 0; i<= MAX_REPEAT; i++) {
			
			toExecute.execute(toExecute);
		}
	}


	public static void main(String[] args) {
		
		int operationType = -1;
		
		Application app = new Application();
		
		if(args != null && args.length > 0) {
			operationType = Integer.parseInt(args[0]);
		}
		
		operationType = -1;
		
		switch(operationType) {
			
			case 1: {
				
				System.out.println("Esecuzione 1 operationType = " + operationType);
				app.f();
				
				break;
			}
			case 2: {
				
				System.out.println("\nEsecuzione 2 operationType =  " + operationType);
				app.g();
				
				break;
			}
			default: {
				
				System.out.println("\nEsecuzione default  operationType =  " + operationType);
				
				AbstractClass[] polimorfo = app.buildAcontainer();
				
				for(AbstractClass item : polimorfo) {
					app.execute(item);
				}
			}
		}
		
	}

}
