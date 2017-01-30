package it.clever.course.j2se.inheritance.counters;

public class Counter {
	
	protected int val;

	public Counter() {
		System.out.println("Counter	costruttore default!");
		val = 1;
	}

	public Counter(int v) {
		System.out.println("Counter:costruttore");
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