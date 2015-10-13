package com.module.simplicity.network.chapter5;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodeXxx {
	public static void main(String[] args) {
		/**
		 * String decode(String s, String enc) : encode된 string을 decode해서 결과를 리턴한다. +는 스페이스로, %16진수는 원래 값으로 디코드 한다.
		 */
		try {
			String encodeUrl = "https://www.youtube.com/watch?&v=UhC7M8KF7AE&list=RDpIw7RAfYgI8&index=2&line=I%2FO";
			String decodeUrl = URLDecoder.decode(encodeUrl, "UTF-8");
			System.out.println("decodeUrl is " + decodeUrl);
		} catch (UnsupportedEncodingException e) {
			System.err.println(e);
		}
	}
}
