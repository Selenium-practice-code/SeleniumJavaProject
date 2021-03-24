package com.sumit.encodepassword;

import org.apache.commons.codec.binary.Base64;

public class EncodePassword {

	public static String decode(String encodedPassword) {

		byte[] valueDecoded = Base64.decodeBase64(encodedPassword);
		return new String(valueDecoded);

	}

	public static void main(String[] args) {

//		// encode data on your side using BASE64
//		byte[] bytesEncoded = Base64.encodeBase64("@admin@134".getBytes());
//		System.out.println("encoded value is  " + new String(bytesEncoded));
//
//		// Decode data on other side, by processing encoded data
//		byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
//		System.out.println("Decode value is " + new String(valueDecoded));
		
		System.out.println(decode("QGFkbWluQDEzNA=="));

	}

}
