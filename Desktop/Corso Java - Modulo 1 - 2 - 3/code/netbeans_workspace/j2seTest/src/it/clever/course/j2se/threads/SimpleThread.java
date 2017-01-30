package it.clever.course.j2se.threads;

public class SimpleThread extends Thread {

	private int countDown = 100;
	private static int threadCount = 0;

	public SimpleThread() {
		// Assegna al thread creato il nome creato con il contatore statico.
		super("" + ++threadCount);

		// Partenza del thread
		start();
	}
	


	public String toString() {
		return "#" + getName() + ": " + countDown;
	}

	/**
	 * Metodo di partenza del thread.
	 * Esegue un count down stampando il nome del thread stesso.
	 */
	public void run() {
		while (true) {
			System.out.println(this);
			if (--countDown == 0) {
				return;
			}
			yield();
			/*
			try{
				sleep(100);
			}catch(InterruptedException e){
				throw new RuntimeException(e);
			}
			*/

		}
	}

	public static void main(String args[]) {
		for (int i = 0; i < 5; i++) {
			new SimpleThread();
		}
	}
}
