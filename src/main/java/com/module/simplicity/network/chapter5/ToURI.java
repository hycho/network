package com.module.simplicity.network.chapter5;

import java.net.URI;
import java.net.URISyntaxException;

public class ToURI {
	public static void main(String[] args) {
		/**
		 * String toString() : 인코딩 되지 않은 URI를 리턴한다.
		 * String toASCIIString() : 인코딩된 URI를 리턴한다.
		 */
		try {
			URI uri = new URI("http://naver.com/image/홍길동.jpg");
			System.out.println("toString() = " + uri.toString());
			System.out.println("toASCIIString() = " + uri.toASCIIString());
		} catch (URISyntaxException e) {
			System.err.print(e);
		}
	}
}
