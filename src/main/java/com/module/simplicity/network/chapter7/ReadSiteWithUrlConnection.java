package com.module.simplicity.network.chapter7;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadSiteWithUrlConnection {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://naver.com");	// 1. URL생성
			URLConnection conn = url.openConnection();	// 2. URLConnection객체 생성 
			try(InputStream in = new BufferedInputStream(conn.getInputStream())){	//3. getInputStream을 사용해서 서버와 연결 및 InputStream을 구함.
				InputStreamReader inReader = new InputStreamReader(in);
				int read;
				while((read = inReader.read()) != -1) {
					System.out.print((char) read);	//4. 스트림 api들을 사용해서 각 항목을 출력
				}
			}catch(IOException e) {
				System.err.println(e);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
