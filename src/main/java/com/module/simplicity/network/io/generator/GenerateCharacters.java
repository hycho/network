package com.module.simplicity.network.io.generator;

import java.io.IOException;
import java.io.OutputStream;

public class GenerateCharacters {
	public static void main(String[] args) throws IOException{
	
		try(OutputStream out = System.out) {
			generateCharactersOne(out);
//			generateCharactersArr(System.out);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 매우 비효율적인 한번에 한바이트씩 출력하는 방식.
	 * 아스키 코드의 33 - 125까지의 값을 계속 반복하면서 찍는다.
	 * @param out
	 * @throws IOException
	 */
	public static void generateCharactersOne(OutputStream out) throws IOException{
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharactersPerLine = 72;
			
		int start = firstPrintableCharacter;
		while(true) {
			for(int i = start; i < start + numberOfCharactersPerLine; i++) {
				out.write(((i - firstPrintableCharacter) % numberOfPrintableCharacters) + firstPrintableCharacter);
			}
			out.write('\r');
			out.write('\n');
			start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
		}
	}
	
	/**
	 * 한번에 한바이트는 매우 비효율적이니 고정된 사이즈 형태의 Byte 배열에 담아서 출력을 하면 한바이트씩 보다는 매우 빨라진다.
	 * 아스키 코드의 33 - 125까지의 값을 계속 반복하면서 찍는다.
	 * @param out
	 * @throws IOException
	 */
	public static void generateCharactersArr(OutputStream out) throws IOException{
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharactersPerLine = 72;
		int start = firstPrintableCharacter;
		byte[] line = new byte[numberOfCharactersPerLine + 2];
		
		while(true) {
			for(int i = start; i < start + numberOfCharactersPerLine; i++) {
				//out.write(((i - firstPrintableCharacter) % numberOfPrintableCharacters) + firstPrintableCharacter);
				line[i-start] = (byte) ((i - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter);
			}
			line[72] = (byte) '\r';
			line[73] = (byte) '\n';
			out.write(line);
			
			start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
		}
	}
}
