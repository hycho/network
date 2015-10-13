package com.module.simplicity.network.chapter6;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class TestCookieStore {
	
	public static void main(String[] args) {
		/**
		 * public void add(URI uri, HttpCookie cookie); : uri에 cookie를 넣는다.
		 * public List<HttpCookie> get(URI uri); : uri에 들어있는 모든 HttpCookie를 반환한다.
		 * public List<HttpCookie> getCookies(); : CookieStore의 모든 Cookies들을 반환한다.
		 * public List<URI> getURIs(); : CookieStore의 모든 URI를 반환한다.
		 * public boolean remove(URI uri, HttpCookie cookie); uri와 cookie를 사용하여 관련 쿠키를 삭제 한다.
		 * public boolean removeAll(); : 모든 쿠키를 삭제한다.
		 */
		try {
			URI uri = new URI("http://naver.com");
		
			CookieManager cm = new CookieManager();
			cm.setDefault(cm);	// URL 객체를 사용해서 HTTP 서버로 요청,응답 받을 경우  자동으로 쿠키를 저장하고 쿠키를 전송하도록 설정한다.
			
			CookieStore store = cm.getCookieStore();
			HttpCookie cookie1 = new HttpCookie("user", "admin");
			HttpCookie cookie2 = new HttpCookie("key", "HFe43fDF");
			HttpCookie cookie3 = new HttpCookie("code", "C3FDFE34G");
			store.add(uri, cookie1);
			store.add(uri, cookie2);
			store.add(uri, cookie3);
			
			List<HttpCookie> cookieList = store.get(uri);
			for(HttpCookie c : cookieList) {
				System.out.println(c.getName() + " = " + c.getValue());
			}
			
			System.out.println();

			List<HttpCookie> cookieList2 = store.getCookies();
			for(HttpCookie c : cookieList2) {
				System.out.println(c.getName() + " = " + c.getValue());
			}
			
			System.out.println();
			
			List<URI> uriList = store.getURIs();
			for(URI u : uriList) {
				System.out.println(u.toString());
			}
			
			store.remove(uri, cookie1);
			System.out.println();
			
			List<HttpCookie> cookieList3 = store.getCookies();
			for(HttpCookie c : cookieList3) {
				System.out.println(c.getName() + " = " + c.getValue());
			}
			
			store.removeAll();
			System.out.println();
			
			List<HttpCookie> cookieList4 = store.getCookies();
			for(HttpCookie c : cookieList4) {
				System.out.println(c.getName() + " = " + c.getValue());
			}
			
		} catch (URISyntaxException e) {
			System.err.println(e);
		}
		
	}
	
}
