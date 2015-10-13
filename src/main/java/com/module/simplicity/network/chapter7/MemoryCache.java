package com.module.simplicity.network.chapter7;

import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryCache extends ResponseCache {

	private final Map<URI, NCacheResponse> responses = new ConcurrentHashMap<URI, NCacheResponse>();
	private final int maxEntries;
	
	public MemoryCache() {
		this(100);
	}
	
	public MemoryCache(int maxEntriys) {
		this.maxEntries = maxEntriys;
	}
	
	@Override
	public CacheResponse get(URI uri, String rqstMethod, Map<String, List<String>> rqstHeaders) throws IOException {
		if("GET".equals(rqstMethod)) { //Get일 때만 호출 함.
			System.out.println("################# GET CACHE #################");
			NCacheResponse response = responses.get(uri);
			
			//만료일을 통한 만료 여부 확인
			if(response != null && response.isExpired()) {
				responses.remove(uri);
				return null;
			}
			
			return response;
		} else {
			return null;
		}
	}

	@Override
	public CacheRequest put(URI uri, URLConnection conn) throws IOException {
		if(responses.size() >= maxEntries) {
			return null;
		}
		
		CacheControl control = new CacheControl(conn.getHeaderField("Cache-Control"));
		
		if(control.isNoStore()) {
			return null;
		} else if(!conn.getHeaderField(0).startsWith("GET ")) { //요청 타입이 GET일 경우만 호출한다.
			return null;
		}
		
		NCacheRequest request = new NCacheRequest();
		NCacheResponse response = new NCacheResponse(request, conn, control);
		System.out.println("################# PUT CACHE #################");
		responses.put(uri, response);
		
		return request;
	}

}
