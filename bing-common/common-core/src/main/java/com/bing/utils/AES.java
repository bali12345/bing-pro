package com.bing.utils;


import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 使用cbc是与golang进行兼容，ecb认为是不安全的加密
 */
public class AES {
	private static final String EncryptAlg = "AES";

	private static final String Encode = "UTF-8";

	private IvParameterSpec ivSpec;
	private SecretKeySpec keySpec;

	public AES(String key) {
		try {
			byte[] keyBytes = key.getBytes();
			byte[] buf = new byte[16];

			for (int i = 0; i < keyBytes.length && i < buf.length; i++) {
				buf[i] = keyBytes[i];
			}

			this.keySpec = new SecretKeySpec(buf, "AES");
			this.ivSpec = new IvParameterSpec(keyBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AES(String key, String iv) {
		try {
			byte[] keyBytes = key.getBytes();
			byte[] buf = new byte[16];

			for (int i = 0; i < keyBytes.length && i < buf.length; i++) {
				buf[i] = keyBytes[i];
			}

			this.keySpec = new SecretKeySpec(buf, EncryptAlg);
//			System.out.println(new String(keyBytes));
			byte[] ivBytes = iv.getBytes(Encode);
			this.ivSpec = new IvParameterSpec(ivBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将16进制转换为二进制
	 *
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) {
			return null;
		}
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static String base64Encode(byte[] data) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

	public static byte[] base64Decode(String data) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(data);
	}

	public String encrypt(String content) {
		try {
			return Base64.encodeBase64String(encrypt(content.getBytes(Encode)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] encrypt(byte[] origData) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, this.keySpec, this.ivSpec);
			return cipher.doFinal(origData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String decrypt(String enStr) {
		try {
			return new String(decrypt(Base64.decodeBase64(enStr)), Encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] decrypt(byte[] crypted) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, this.keySpec, this.ivSpec);
			return cipher.doFinal(crypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
