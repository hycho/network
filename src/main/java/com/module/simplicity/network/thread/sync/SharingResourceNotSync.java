package com.module.simplicity.network.thread.sync;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class SharingResourceNotSync implements Runnable {

	private String filename;
	
	public SharingResourceNotSync(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void run() {
		try{
			FileInputStream fin = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream dis = new DigestInputStream(fin, sha);
			while(dis.read() != -1) ; //파일 끝까지 읽기
			dis.close();
			
			byte[] digest = sha.digest();
			
			synchronized(System.out) {
				System.out.print(DatatypeConverter.printHexBinary(digest));
				System.out.println();
			}
			
		}catch (IOException | NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String filename1 = "C:\\analytics.txt";
		String filename2 = "C:\\VrInfo.log";
		
		SharingResourceNotSync dr1 = new SharingResourceNotSync(filename1);
		SharingResourceNotSync dr2 = new SharingResourceNotSync(filename2);
		SharingResourceNotSync dr3 = new SharingResourceNotSync(filename1);
		SharingResourceNotSync dr4 = new SharingResourceNotSync(filename2);
		
		Thread t1 = new Thread(dr1);
		Thread t2 = new Thread(dr2);
		Thread t3 = new Thread(dr3);
		Thread t4 = new Thread(dr4);
		
		t2.setPriority(10); //1-10 중에 8이면 꽤높은 우선순위.
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
