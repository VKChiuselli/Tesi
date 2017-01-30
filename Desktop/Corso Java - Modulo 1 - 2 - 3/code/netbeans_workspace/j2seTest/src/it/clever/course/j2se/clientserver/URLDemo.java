package it.clever.course.j2se.clientserver;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo{
	
	public static void main(String args[])throws MalformedURLException{
		URL hp  = new  URL("http://www.2clever.it/");
		System.out.println("Protocal:" +  hp.getProtocol());
		System.out.println("Port:" +  hp.getPort());
		System.out.println("Host:" +  hp.getHost());
		System.out.println("File:" +  hp.getFile());
		System.out.println("Ext:" + hp.toExternalForm());
	}
}
