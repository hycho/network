package com.module.simplicity.network.thread.callback;

import javax.xml.bind.DatatypeConverter;

public class InstanceCallbackDigestUserInterface {
	
	private String filename;
	private byte[] digest;
	
	public InstanceCallbackDigestUserInterface(String filename) {
		this.filename = filename;
	}
	
	public void calculateDigest() {
		InstanceCallbackDigest icd = new InstanceCallbackDigest(filename, this);
		Thread t = new Thread(icd);
		t.start();
	}
	
	public void receiveDigest(byte[] digest) {
		this.digest = digest;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String result = filename + ": ";
		if(digest != null) {
			result += DatatypeConverter.printHexBinary(digest);
		} else {
			result += "digest not available";
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		String filename = "C:\\analytics.txt";
		InstanceCallbackDigestUserInterface icadui = new InstanceCallbackDigestUserInterface(filename);
		icadui.calculateDigest();
	}
}
