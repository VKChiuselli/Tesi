package it.clever.course.j2se.threads;

class CanStop extends Thread {

	private volatile boolean stop = false;
	private static int counter = 0;

	public void run() {
		while (!stop && counter < 1000) {
			System.out.println(counter++);
		}
		
		/*
		 * In alcune situazioni un thread rimane bloccato e non può verificare il flag di terminazione.
		 * 
		 
		try {
			sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
		if (stop) {
			System.out.println("Detected stop");
		}			
	}

	public void requestStop() {
		stop = true;
	}
}

 class Stopping {
	 
	public static void main(String args[]) {
		
		final CanStop stoppable = new CanStop();
		
		stoppable.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Requesting stop");
		stoppable.requestStop();
	}
}
