package com.bing.utils;


import com.bing.sign.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class SecureUtils {
	public static String encrypt(String phoneNumber) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		String time = format.format(Calendar.getInstance().getTime());
		String result = encrypt(phoneNumber, "hwd" + time);
		return result;
	}

	public static String encrypt(String phoneNumber, String key) {
		try {
			byte[] bytesPhoneNumber = phoneNumber.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytesKey = Arrays.copyOf(md.digest(key.getBytes("UTF-8")), 24);
			for (int j = 0, k = 16; j < 8; ) {
				bytesKey[k++] = bytesKey[j++];
			}
			KeySpec keySpec = new DESedeKeySpec(bytesKey);
			SecretKey key1 = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key1);
			byte[] buf = cipher.doFinal(bytesPhoneNumber);
			return Base64.encode(buf);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public static String decrypt(String str) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		String time = format.format(Calendar.getInstance().getTime());
		String  key = "hwd" + time;
		byte[] buf = Base64.decode(str);

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bytesKey = Arrays.copyOf(md.digest(key.getBytes("UTF-8")), 24);
		for (int j = 0, k = 16; j < 8; ) {
			bytesKey[k++] = bytesKey[j++];
		}
		KeySpec keySpec = new DESedeKeySpec(bytesKey);
		SecretKey key1 = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.DECRYPT_MODE, key1);

		byte[] buf2 = cipher.doFinal(buf);
		return  new String(buf2,"UTF-8");
	}

}
