package com.module.simplicity.network.thread.callback;

import javax.xml.bind.DatatypeConverter;

public class CallbackDigestUserInterface {
	public static void receiveDigest(byte[] digest, String filename) {
		StringBuilder result = new StringBuilder(filename);
		result.append(": ");
		result.append(DatatypeConverter.printHexBinary(digest));
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		String filename = "C:\\analytics.txt";
		CallbackDigest cd = new CallbackDigest(filename);
		Thread t = new Thread(cd);
		t.start();
	}
}
