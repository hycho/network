package com.module.simplicity.network.chapter5;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class LoadUrl {
	public static void main(String[] args) {
		/**
		 * InputStream openStream() : [대표적으로 사용된다.] URL에 의해 참조된 리소스에 연결하고 그다음 3 way handshaking을 처리한 후 리소스 원본 데이터를 읽을 수 있는 InputStream객체를 리턴한다.
		 * URLConnection openConnection()
		 * URLConnection openConnection(Proxy proxy)
		 * Object getContent()
		 * Object getContent(Class[] classes)
		 */
		try{
			URL url = new URL("http://naver.com");
			try(InputStream in = new BufferedInputStream(url.openStream());
				Reader r = new InputStreamReader(in);) {
				int read;
				while((read = r.read()) != -1) {
					System.out.write(read);
				}
			}
		} catch(IOException e) {
			System.err.println(e);
		}
	}
}
