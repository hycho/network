package com.module.simplicity.network.chapter5;

import java.net.URI;
import java.net.URISyntaxException;

public class ConvURI {
	public static void main(String[] args) {
		/**
		 * URI resolve(URI uri) : 절대적 URI객체의 URI정보를 토대로 파라메터로 넘어온 상대적 uri를 절대적 uri로 변경해서 리턴한다.
		 * URI resolve(String uri) : 절대적 URI객체의 URI정보를 토대로 파라메터로 넘어온 상대적 uri String을 절대적 uri로 변경해서 리턴한다.
		 * URI relativize(URI uri) : 도메인 URI객체의 URI정보를 토대로 파라메터로 넘어온 절대적 uri를 상대적 uri로 변경해서 리턴한다.
		 */
		
		try {
			URI absoluteUri = new URI("http://naver.com/");
			URI relativeUri = new URI("images/ico.png");
			URI resolveUri = absoluteUri.resolve(relativeUri);
			System.out.println("resolveUri = " + resolveUri);
			
			System.out.println("");
			
			URI absoluteUriA = new URI("http://naver.com/");
			URI resolveUriA = absoluteUriA.resolve("images/load.png");
			System.out.println("resolveUriA = " + resolveUriA);
			
			System.out.println("");
			
			URI absoluteUriB = new URI("http://naver.com/image/july.png");
			URI domainB = new URI("http://naver.com/");
			URI resolveUriB = domainB.relativize(absoluteUriB);
			System.out.println("resolveUriB = " + resolveUriB);
			
		} catch (URISyntaxException e) {
			System.err.println(e);
		}
	}
}
