package com.test.dangyel.common;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

public class example {
   
   private String publicKeyModulus = "";
   private String publicKeyExponent = "";
   private PrivateKey privateKey = null; 
   
   public static example getEncKey() {
	  SecureRandom rand = new SecureRandom();

      KeyPairGenerator generator;
      try {
         generator = KeyPairGenerator.getInstance("RSA");
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
         return null;
      } //RSAŰ ���׷����� ����
      generator.initialize(1024); //Ű ������ rand�ٿ�
      
      KeyPair keyPair = generator.genKeyPair();
      
      KeyFactory keyFactory;
      try {
         keyFactory = KeyFactory.getInstance("RSA");
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
         return null;
      }
      
      PublicKey publicKey = keyPair.getPublic(); //����Ű
      PrivateKey privateKey = keyPair.getPrivate(); //����Ű
      
      RSAPublicKeySpec publicSpec;
      try {
         publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
      } catch (InvalidKeySpecException e) {
         e.printStackTrace();
         return null;
      }
      String publicKeyModulus = publicSpec.getModulus().toString(16);
       String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
       
       example rsa = new example();
       rsa.setPrivateKey(privateKey);
       rsa.setPublicKeyExponent(publicKeyExponent);
       rsa.setPublicKeyModulus(publicKeyModulus);
       
       return rsa;
   }
   
   public static boolean dec(PrivateKey privateKey, String encString) throws Exception{
      boolean result = false;
      
      if (privateKey == null) {
            throw new RuntimeException("��ȣȭ ���Ű ������ ã�� �� �����ϴ�.");
        }
      try {
         decryptRsa(privateKey, encString);
         result = true;
      } catch (Exception e) {
         e.printStackTrace();
         result = false;
      }
        
      return result;
   }
   
   public static String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
        //System.out.println("will decrypt : " + securedValue);
        Cipher cipher = Cipher.getInstance("RSA");
        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedValue = new String(decryptedBytes, "utf-8"); // ���� ���ڵ� ����.
        return decryptedValue;
    }
   
   public static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() % 2 != 0) {
            return new byte[]{};
        }

        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            byte value = (byte)Integer.parseInt(hex.substring(i, i + 2), 16);
            bytes[(int) Math.floor(i / 2)] = value;
        }
        return bytes;
    }


   public String getPublicKeyModulus() {
      return publicKeyModulus;
   }
   public void setPublicKeyModulus(String publicKeyModulus) {
      this.publicKeyModulus = publicKeyModulus;
   }
   public String getPublicKeyExponent() {
      return publicKeyExponent;
   }
   public void setPublicKeyExponent(String publicKeyExponent) {
      this.publicKeyExponent = publicKeyExponent;
   }
   public PrivateKey getPrivateKey() {
      return privateKey;
   }
   public void setPrivateKey(PrivateKey privateKey) {
      this.privateKey = privateKey;
   }
}