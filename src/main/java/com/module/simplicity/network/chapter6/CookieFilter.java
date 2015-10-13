package com.module.simplicity.network.chapter6;

import java.net.CookieManager;
import java.net.CookiePolicy;

public class CookieFilter {
	public static void main(String[] args) {
		/**
		 * Java6부터는 CookieManager클래스를 통해서 쿠키를 관리 할 수 있다.
		 * 상세 쿠키 설정을 위해서 CookiePolicy를 설정 할 수 있다.
		 * CookiePolicy.ACCEPT_ALL : 모든 쿠키 허용
		 * CookiePolicy.ACCEPT_NONE : 모든 쿠키 차단
		 * CookiePolicy.ACCEPT_ORIGINAL_SERVER : 서드파티 쿠키를 차단 (직접 접속한 서버에 대한 쿠키만을 허용하며 다른 서버로부터 온 쿠키는 허용하지 않는다)
		 */
		CookieManager cm = new CookieManager();
		cm.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER); //서드파티 쿠키 허용 하지 않음.
		cm.setDefault(cm);	// URL 객체를 사용해서 HTTP 서버로 요청,응답 받을 경우  자동으로 쿠키를 저장하고 쿠키를 전송하도록 설정한다.
	}
}
