package com.module.simplicity.network.chapter5;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GenQueryString {
	private final String ENCODE = "UTF-8";
	private StringBuilder query = new StringBuilder();
	
	
	public GenQueryString() {}
	
	public synchronized void add(String name, String value) {
		query.append('&');
		encode(name, value);
	}
	
	private synchronized void encode(String name, String value) {
		try {
			query.append(URLEncoder.encode(name, ENCODE));
			query.append('=');
			query.append(URLEncoder.encode(value, ENCODE));
			
		} catch (UnsupportedEncodingException e) {
			System.err.println(e);
		}
	}
	
	public synchronized String getQuery() {
		return query.toString();
	}
	
	@Override
	public String toString() {
		return getQuery();
	}
	
	public static void main(String[] args) {
		//https://www.youtube.com/watch?v=UhC7M8KF7AE&list=RDpIw7RAfYgI8&index=2&line=I/O 변환
		GenQueryString qs = new GenQueryString();
		qs.add("v", "UhC7M8KF7AE");
		qs.add("list", "RDpIw7RAfYgI8");
		qs.add("index", "2");
		qs.add("line", "I/O");
		String url = "https://www.youtube.com/watch?" + qs;
		System.out.println(url);
	}
}
