package it.clever.course.j2se.threads;

public class SimpleJoin extends Thread {
	private int flag;
	private SimpleJoin dormiente;

	public SimpleJoin(int i, String name) {
		super(name);
		flag = i;
		start();
	}

	public SimpleJoin(int i, String name, SimpleJoin j) {
		super(name);
		flag = i;
		dormiente = j;
		start();
	}

	public void run() {
		if (flag == 1) {
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(getName() + " si sveglia");
		}
		if (flag == 2) {
			try {
				dormiente.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(getName() + " riprende l'esecuzione");
		}
	}

	public static void main(String args[]) {
		SimpleJoin Dormiente = new SimpleJoin(1, "Dormiente");
		SimpleJoin Paziente = new SimpleJoin(2, "Paziente", Dormiente);
	}
}
