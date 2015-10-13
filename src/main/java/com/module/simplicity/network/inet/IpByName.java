package com.module.simplicity.network.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpByName {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("naver.com");
			System.out.println(address);
			
			InetAddress address2 = InetAddress.getByName("125.209.222.142");
			System.out.println(address2.getHostName());
			
			InetAddress[] addresses = InetAddress.getAllByName("naver.com");
			for(InetAddress addr : addresses) {
				System.out.println(addr);
			}
			
			InetAddress me = InetAddress.getLocalHost();
			System.out.println(me);
			
			SecurityManager sm = new SecurityManager();
			sm.checkConnect("127.0.0.1", -1);
			
		} catch(UnknownHostException e) {
			System.err.println(e);
		}
	}
}
