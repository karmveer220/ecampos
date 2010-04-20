package org.cnl.digemin.utiles;

import java.security.*;

public class Encriptador {

	private MessageDigest md = null;
	static private Encriptador md5 = null;
	private static final char[] hexChars = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * Constructor is private so you must use the getInstance method
	 */
	private Encriptador() throws NoSuchAlgorithmException {
		md = MessageDigest.getInstance("MD5");
	}

	/**
	 * This returns the singleton instance
	 */
	public static Encriptador getInstance() throws NoSuchAlgorithmException {

		if (md5 == null) {
			md5 = new Encriptador();
		}
		return (md5);
	}

	public String hashData(byte[] dataToHash){
		return hexStringFromBytes((calculateHash(dataToHash)));
	}

	private byte[] calculateHash(byte[] dataToHash){
		md.update(dataToHash, 0, dataToHash.length);
		return (md.digest());
	}

	public String hexStringFromBytes(byte[] b){

		String hex = "";
		int msb;
		int lsb = 0;
		int i;
		// MSB maps to idx 0

		for (i = 0; i < b.length; i++){
			msb = ((int) b[i] & 0x000000FF) / 16;
			lsb = ((int) b[i] & 0x000000FF) % 16;
			hex = hex + hexChars[msb] + hexChars[lsb];
		}
		return (hex);
	}

	public static void main(String[] args) {
		try {
			Encriptador md = Encriptador.getInstance();
			System.out.println(md.hashData("hello".getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(System.out);
		}
	}
	
}