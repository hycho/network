package com.module.simplicity.network.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetObjectMethod {
	public static void main(String[] args) throws UnknownHostException {
		/**
		 * boolean equals(Object o) : 두개의 InetAddress 객체가 가르키는 IP가 동일 할 경우 TRUE 아닐 경우 FALSE를 리턴한다. 
		 * int hashCode() : InetAddress 객체가 가르키는 ip 주소로부터 계산된 int값을 반환하며, 아이피가 동일하다면 동일한 int값을 반환한다. 
		 * String toString() : 호스트네임/마침표로 구분된 네자리 IP 주소를 반환한다.
		 */
		
		InetAddress naverAddr = InetAddress.getByName("naver.com");
		InetAddress wnaverAddr = InetAddress.getByName("naver.com");
		
		System.out.println("naverAddr = " + naverAddr);
		System.out.println("wnaverAddr = " + wnaverAddr.toString());
		
		if(naverAddr.equals(wnaverAddr)) {
			System.out.println("naver.com 과 www.naver.com은 같다");
		}
		
		System.out.println("naverAddr hash is = "+naverAddr.hashCode());
	}
}
