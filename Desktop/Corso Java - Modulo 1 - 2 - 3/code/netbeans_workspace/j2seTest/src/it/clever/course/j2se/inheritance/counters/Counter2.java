package it.clever.course.j2se.inheritance.counters;

public class Counter2 {
	protected int val;

/*
	public Counter2() {
		System.out.println("Counter	costruttore default!");
		val = 1;
	}
*/
	public Counter2(int v) {
		System.out.println("Counter2:costruttore");
		val = v;
	}

	public void reset() {
		val = 0;
	}

	public void inc() {
		val++;
	}

	public int getValue() {
		return val;
	}
}