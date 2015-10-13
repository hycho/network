package com.module.simplicity.network.inet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;

public class ConvIpToHostByWebLog {
	public static void main(String[] args) {
		String logFilePath = "C:\\access.log";
		
		try(
			FileInputStream fin = new FileInputStream(logFilePath);
			Reader in = new InputStreamReader(fin);	//지정된 인코딩이 없으면 byte코드를 Host의 인코딩에 따라 Unicode로 변환한다.
			BufferedReader bin = new BufferedReader(in);) {
			for(String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
				int index = entry.indexOf(' ');
				String ip = entry.substring(0, index);
				String afterInfo = entry.substring(index);
				
				// DNS에 HostName 쿼리 그리고 출력
				InetAddress inetAddr = InetAddress.getByName(ip);
				System.out.println(inetAddr.getHostName() + afterInfo);	//만약 hostname을 가져올 수 없다면 ip주소를 보여준다.
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
