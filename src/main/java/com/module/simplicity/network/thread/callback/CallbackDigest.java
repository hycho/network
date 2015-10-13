package com.module.simplicity.network.thread.callback;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CallbackDigest implements Runnable {

	private String filename;
	
	public CallbackDigest(String filename) {
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
			CallbackDigestUserInterface.receiveDigest(digest, filename);
		}catch (IOException | NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
	}

}
