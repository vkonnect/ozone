package com.vkonnect.ozone.utils;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;
 
public class CipherUtil {
 
//    private static SecretKeySpec secretKey;
    private static byte[] key;
 
//    public static void setKey(String myKey) 
//    {
//        MessageDigest sha = null;
//        try {
//            key = myKey.getBytes("UTF-8");
//            sha = MessageDigest.getInstance("SHA-1");
//            key = sha.digest(key);
//            key = Arrays.copyOf(key, 16); 
//            secretKey = new SecretKeySpec(key, "AES");
//        } 
//        catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } 
//        catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
 
    public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
        	  if(strToEncrypt==null)
        	  {
        		  strToEncrypt = "";
        	  }
//            setKey(secret);
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        	byte[] message = strToEncrypt.getBytes("UTF-8");
        	String encoded = DatatypeConverter.printBase64Binary(message);
        	return encoded;
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
	public static String decrypt(String strToDecrypt, String secret) {
		// try
		// {
		// setKey(secret);
		// Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		// cipher.init(Cipher.DECRYPT_MODE, secretKey);
		// return new
		// String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		// }
		// catch (Exception e)
		// {
		// System.out.println("Error while decrypting: " + e.toString());
		// }
		// return null;
		byte[] decoded;
		String decodedstr = "";
		try {
			decoded = DatatypeConverter.parseBase64Binary(strToDecrypt);
			decodedstr = new String(decoded, "UTF-8");
			System.out.println("decoded = " + decodedstr);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decodedstr;
	}
}