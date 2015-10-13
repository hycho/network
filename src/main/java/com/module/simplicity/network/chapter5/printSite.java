package com.module.simplicity.network.chapter5;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class printSite {
	public static void main(String[] args) {
		GenQueryString q = new GenQueryString();
		q.add("where", "nexearch");
		q.add("query", "king");
		q.add("sm", "top_hty");
		q.add("fbm", "0");
		q.add("ie", "utf8");
		
		try {
			//URL url = new URL("https://search.naver.com/search.naver?" + q.toString());
			URL url = new URL("http://www.naver.com");
			InputStream in = new BufferedInputStream(url.openStream());
			InputStreamReader inReader = new InputStreamReader(in);
			
			int read;
			while((read = inReader.read()) != -1) {
				System.out.print((char) read);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
