package com.bing.utils;

/**
 * @author benkangchen
 */
public class ByteUtils {
	/**
	 * byte装成int
	 * @param value
	 * @return
	 */
	public static int bytesToInt(byte[] value) {
		int ret = 0;
		for (int i = 0; i < value.length; i++) {
			ret += (value[value.length - i - 1] & 0xFF) << (i * 8);
		}
		return ret;
	}

	/**
	 * 转成字节长度
	 * @param iSource 原数据
	 * @param iArrayLen 输出数据
	 * 只能转整形最多4个字节
	 * @return
	 */
	public static byte[] toByteArray(int iSource, int iArrayLen) {
		byte[] bLocalArr = new byte[iArrayLen];
		for (int i = 0; (i < 4) && (i < iArrayLen); i++) {
			bLocalArr[i] = (byte) (iSource >> 8 * i & 0xFF);
		}
		byte temp;
		int len = bLocalArr.length;
		for (int i = 0; i < len / 2; i++) {
			temp = bLocalArr[i];
			bLocalArr[i] = bLocalArr[len - 1 - i];
			bLocalArr[len - 1 - i] = temp;
		}
		return bLocalArr;
	}

	/**
	 * byte[] 转 Long
	 * @return
	 */
	public static long bytesToLong(byte[] value) {
		long ret = 0;
		for (int i = 0; i < value.length; i++) {
			ret += (long) (value[value.length - i - 1] & 0xFF) << (long) (i * 8);
		}
		return ret;
	}

	/**
	 * Long 转 byte[]
	 * @return
	 */
	public static byte[] longTobytes(long val) {
		int length = 8;
		byte[] value = new byte[length];
		for (int i = 0; i < length; i++) {
			value[length - i - 1] = (byte) (val >> i * 8);
		}

		return value;
	}
	/**
	 * 16进制字符串转byte
	 * @param strIn
	 * @return
	 * @throws Exception
	 */
	public static byte[] hexStr2ByteArr(String strIn) {
		try {
			if (strIn==null)return null;
			byte[] arrB = strIn.getBytes();
			int iLen = arrB.length;
			byte[] arrOut = new byte[iLen/2];
			for (int i = 0; i < iLen; i = i + 2) {
				String strTmp = new String(arrB, i, 2);
				arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
			}
			return arrOut;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 16进制的形式输出
	 * @param b
	 * @return
	 */
	public static String byte2HexStr(byte[] b){
		String stmp="";
		StringBuilder sb = new StringBuilder("");

		try {
			for (int n=0;n<b.length;n++)
			{
				stmp = Integer.toHexString(b[n] & 0xFF);
				sb.append((stmp.length()==1)? "0"+stmp : stmp);
				//sb.append(" ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString().toUpperCase().trim();
	}

	public static byte[] byteMerger(byte[] bt1, byte[] bt2){
		byte[] bt3 = new byte[bt1.length+bt2.length];
		System.arraycopy(bt1, 0, bt3, 0, bt1.length);
		System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
		return bt3;
	}

	public static byte[] byteMergerAll(byte[]... values) {
		int length_byte = 0;
		for (int i = 0; i < values.length; i++) {
			if (null != values[i]) {
				length_byte += values[i].length;
			}
		}
		byte[] all_byte = new byte[length_byte];
		int countLength = 0;
		for (int i = 0; i < values.length; i++) {
			if (null != values[i]) {
				byte[] b = values[i];
				System.arraycopy(b, 0, all_byte, countLength, b.length);
				countLength += b.length;
			}
		}
		return all_byte;
	}
}
