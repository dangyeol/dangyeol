package com.test.dangyel.common;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {

	private Key pubKey = null;
	private Key privKey = null;
	
	public static RSA getEncKey() throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException,
			InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		{
			Cipher cipher = Cipher.getInstance("RSA/None/NoPadding", "BC");
			SecureRandom random = new SecureRandom();
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");

			generator.initialize(512, random); // 512 bit 키를 생성하였음 RSA BC 키 생성
			KeyPair pair = generator.generateKeyPair();
			Key pubKey = pair.getPublic(); // Kb(pub) 공개키
			Key privKey = pair.getPrivate();// Kb(pri) 개인키

			RSA test = new RSA();
			test.setPrivateKey(privKey);
			test.setPublicKey(pubKey);
			return test;
		}

	}

	public static byte[] encryptRsa(Key pubKey, byte[] input) throws NoSuchAlgorithmException, NoSuchProviderException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("RSA/None/NoPadding", "BC");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		byte[] cipherText = cipher.doFinal(input);
		return cipherText;
	}

	public static String decryptRsa(Key privateKey, byte[] cipherText) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA/None/NoPadding", "BC");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] plainText = cipher.doFinal(cipherText);

		return new String(plainText);
	}

	public Key getPublicKey() {
		return pubKey;
	}

	public Key getPrivKey() {
		return privKey;
	}

	public void setPublicKey(Key publicKey) {
		this.pubKey = publicKey;
	}

	public void setPrivateKey(Key privateKey) {
		this.privKey = privateKey;
	}

}
