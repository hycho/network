package com.module.simplicity.network.chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import com.module.simplicity.network.chapter5.GenQueryString;

public class SendFormPost {
	private URL url;
	private GenQueryString query = new GenQueryString();
	
	public SendFormPost(URL url) {
		if(!url.getProtocol().toLowerCase().startsWith("http")) {	//http 프로토콜을 통한 요청이 아닐경우 오류 발생
			throw new IllegalArgumentException("Posting only works for http URLs");
		}
		this.url = url;
	}
	
	public void add(String name, String value) {
		query.add(name, value);
	}
	
	public URL getURL() {
		return url;
	}
	
	public InputStream post() throws IOException {
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		
		try (OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8")) {
			out.write(query.toString());
			out.write("\r\n");
			out.flush();
		}
		
		return conn.getInputStream();
	}
	
	public static void main(String[] args) {
		try {
			URL url;
			url = new URL("http://krdic.naver.com/search.nhn");
			SendFormPost post = new SendFormPost(url);
			
			post.add("query", "111");
			post.add("kind", "all");
			
			try(InputStream in = post.post()) {
				Reader r = new InputStreamReader(in);
				int c;
				while((c = r.read()) != -1) {
					System.out.print((char) c);
				}
				System.out.println("");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
