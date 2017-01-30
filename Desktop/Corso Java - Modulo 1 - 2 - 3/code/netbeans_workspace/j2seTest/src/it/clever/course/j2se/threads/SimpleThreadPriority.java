package it.clever.course.j2se.threads;

public class SimpleThreadPriority extends Thread {

	private int countDown = 50;
	private static int threadCount = 0;

	public SimpleThreadPriority(int priority) {
		setPriority(priority);
		start();
	}

	public String toString() {
		return super.toString() + ": " + countDown;
	}

	public void run() {
		while (true) {
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String args[]) {
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				new SimpleThreadPriority(Thread.MAX_PRIORITY);
			}
			if (i != 0) {
				new SimpleThreadPriority(Thread.MIN_PRIORITY);
			}
		}
	}
}
