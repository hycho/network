package com.module.simplicity.network.chapter7;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Prev24ModifiedSince {
	public static void main(String[] args) {
		/**
		 * 이전 24시간 사이에 변경되지 않으면 출력을 하지 않는다.
		 */
		Date today = new Date();
		long millisecondsPerDay = 24 * 60 * 60 * 1000;
		
		try {
			URL u = new URL("http://www.elharo.com/");
			URLConnection conn = u.openConnection();
			
			System.out.println("Original ms = "+new Date(conn.getIfModifiedSince()));
			conn.setIfModifiedSince((new Date(today.getTime() - millisecondsPerDay)).getTime());
			System.out.println("this ms = "+new Date(conn.getIfModifiedSince()));
			
			try(InputStream in = new BufferedInputStream(conn.getInputStream());
				Reader r = new InputStreamReader(in);) {
				int read;
				while((read = r.read()) != -1) {
					System.out.write(read);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
