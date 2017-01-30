package it.clever.course.j2se.clientserver;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class InterfaceLister {
	public static void main(String[] args) throws Exception {
		Enumeration enu = NetworkInterface.getNetworkInterfaces();
		while (enu.hasMoreElements()) {
			NetworkInterface net = (NetworkInterface) enu.nextElement();
			System.out.println(net);               
		}
	}
}