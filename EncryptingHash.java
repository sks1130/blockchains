/**
 * 
 */
package com.blockchains;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Sachin.Srivastava
 * @github - https://github.com/sks1130
 * {@code} - MessageDigest to prepare the 
 * required algoritm byte array and finally converting 
 * it into hexadecimal string of the converted signum data
 * {@link} - https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest
 *
 */
public class EncryptingHash {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println("MD2 hash : " + getHash("","MD2"));
		System.out.println("MD5 hash : " + getHash("","MD5"));
		System.out.println("SHA-1 hash : " + getHash("","SHA-1"));
		System.out.println("SHA-224 hash : " + getHash("","SHA-224"));
		System.out.println("SHA256 hash : " + getHash("","SHA-256"));
		System.out.println("SHA-384 hash : " + getHash("","SHA-384"));
		System.out.println("SHA-512 hash : " + getHash("","SHA-512"));
	}

	static String getHash(String input,String algorithm) throws NoSuchAlgorithmException {
		try {
			// Static getInstance method is called with hashing algorithm
			MessageDigest md = MessageDigest.getInstance(algorithm);
			// digest() method called
			// to calculate message digest of an input
			// and return array of byte
			byte[] messageDigest = md.digest(input.getBytes());
			// Convert byte array into signum representation
			BigInteger number = new BigInteger(1, messageDigest);
			// Convert message digest into hex value
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (Exception e) {
			System.out.println("Exception thrown : " +  e);
		}
		return null;
	}
}
