package com.module.simplicity.network.chapter6;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

/**
 * CookiePolicy를 확장하여 Defaul로 제공해주는 ACCEPT_ALL, ACCEPT_NONE, ACCEPT_ORIGINAL_SERVER를 제외한 커스텀 정책을 만들 수 있다.
 * shouldAccept(URI uri, HttpCookie cookie)를 구현하고 false는 접근 불가, true는 접근 허용이니 관련 로직을 만들어주면 된다.
 */
public class CookieCustomFilter implements CookiePolicy{
	
	@Override
	public boolean shouldAccept(URI uri, HttpCookie cookie) { //모든 .gov도메인에 대한 쿠키를 차단 한다.
		if(uri.getAuthority().toLowerCase().endsWith(".gov") || cookie.getDomain().toLowerCase().endsWith(".gov")) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		CookieManager cm = new CookieManager();
		cm.setCookiePolicy(new CookieCustomFilter()); // CookiePolicy를 구현한 객체를 통해서 정책을 설정 할 수 있다.
		cm.setDefault(cm);	// URL 객체를 사용해서 HTTP 서버로 요청,응답 받을 경우  자동으로 쿠키를 저장하고 쿠키를 전송하도록 설정한다.
	}
	
}
