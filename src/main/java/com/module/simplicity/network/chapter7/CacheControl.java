package com.module.simplicity.network.chapter7;

import java.util.Date;
import java.util.Locale;

import lombok.Getter;

@Getter
public class CacheControl {
	private Date maxAge = null;					// 캐시에 저장된 항목이 만료될 때까지 남은 초시간.
	private Date sMaxAge = null;				// 공유캐시에 저장된 항목이 만료될 때 까지 남은 초시간.
	private boolean mustRevalidate = false;
	private boolean noCache = false;			// 클라이언트가 접근시 ETag, Last-modified 헤더를 사용해서 리소스 상태를 재확인 해야한다.
	private boolean noStore = false;
	private boolean proxyRevalidate = false;
	private boolean publicCache = false;		// 인증된 응답을 캐시에 저장할 수 있음을 뜻함. false일 경우 응답을 캐시에 저장 불가능
	private boolean privateCache = false;		// 단일 사용자 캐시만 해당 응답을 저장 가능
	
	public CacheControl(String s) {
		if(s == null || !s.contains(":")) {
			return;
		}
	
		String value = s.split(":")[1].trim();
		String[] components = value.split(",");
		
		Date now = new Date();
		for(String component : components) {
			component = component.trim().toLowerCase(Locale.US);
			
			if(component.startsWith("max-age=")) {
				int secondsInTheFuture = Integer.parseInt(component.substring(8));
				maxAge = new Date(now.getTime() + 1000 * secondsInTheFuture);
			} else if(component.startsWith("s-maxage=")) {
				int secondsInTheFuture = Integer.parseInt(component.substring(8));
				sMaxAge = new Date(now.getTime() + 1000 * secondsInTheFuture);
			} else if(component.contentEquals("proxy-revalidate")) {
				proxyRevalidate = true;
			} else if(component.equals("no-cache")) {
				noCache = true;
			} else if(component.equals("public")) {
				publicCache = true;
			} else if(component.equals("private")) {
				privateCache = true;
			}
		}
	}
	
	
}
