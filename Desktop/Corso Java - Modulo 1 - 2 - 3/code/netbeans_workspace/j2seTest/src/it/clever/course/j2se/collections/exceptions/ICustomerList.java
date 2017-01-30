package it.clever.course.j2se.collections.exceptions;

public interface ICustomerList {

	public static final int CUSTOMER_MAX_LIST = 3;
	public static final String CUSTOMER_SOURCE_FILE = "resurces//customers.txt";

	public abstract void populateCustomerList(int streamType);

}