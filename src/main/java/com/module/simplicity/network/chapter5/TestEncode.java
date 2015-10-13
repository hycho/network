package com.module.simplicity.network.chapter5;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TestEncode {
	public static void main(String[] args) {
		/**
		 * String encode(String s, String enc) : 비아스키 문자를 enc로 인코딩 하며 '/','&','=',':'등의 문자를 퍼센트인코딩 하며 띄어쓰기는 '+'로 인코딩한 결과를 리턴한다.
		 */
		try {
			System.out.println(URLEncoder.encode("Encode String*Test%One+Two/Three\"Four:Five~Six(Teen)Seven.Eight=Nine&Ten킹", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			System.err.println(e);
		}
	}
}
