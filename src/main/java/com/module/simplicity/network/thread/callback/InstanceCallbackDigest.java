package com.module.simplicity.network.thread.callback;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InstanceCallbackDigest implements Runnable {

	private String filename;
	private InstanceCallbackDigestUserInterface callback;
	
	public InstanceCallbackDigest(String filename, InstanceCallbackDigestUserInterface callback) {
		this.filename = filename;
		this.callback = callback;
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
			callback.receiveDigest(digest);
		}catch (IOException | NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
	}

}
