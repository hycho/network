package com.module.simplicity.network.thread.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

//Thread를 확장한 클래스
public class DigestThread extends Thread{
	private String filename;
	
	public DigestThread(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void run() {
		try{
			FileInputStream fin = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream dis = new DigestInputStream(fin, sha);
			while(dis.read() != -1) ; 
			dis.close();
			
			byte[] digest = sha.digest();
			StringBuilder result = new StringBuilder(filename);
			result.append(": ");
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
			
		}catch (IOException | NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String filename = "C:\\analytics.txt";
		Thread t = new DigestThread(filename);
		t.start();
	}
}
