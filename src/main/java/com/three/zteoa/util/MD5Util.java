package com.three.zteoa.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author chsm
 * @date 2018年6月2日
 */
public abstract class MD5Util {

	private static final String SALT_VALUE = "CHSM";
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F' };

	/**
	 * 按照MD5加盐值加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encrypt(String str) {
		str += SALT_VALUE;
		byte[] bt = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			bt = messageDigest.digest(str.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteToHex(bt);
	}

	/**
	 * 将二进制转换为十六进制
	 * 
	 * @param bt
	 * @return
	 */
	private static String byteToHex(byte[] bt) {
		StringBuffer stringBuffer = new StringBuffer();
		/*
		 * new一个字符数组，这个就是用来组成结果字符串的 解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
		 * 这里看了我很久，大概三小时终于明白了,主要还是由于自己的基本功不扎实 首先一个byte占8位，一个十六进制占4位，所以一个byte需要用两个十六进制来表示
		 * 例： 数字100 二进制：0110 0100 高四位：0110 即 6 低四位：0100 即 4 十六进制：64
		 */
		char[] resultCharArray = new char[bt.length * 2];
		int index = 0;
		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		for (byte b : bt) {
			// 取高四位，例数字100 二进制：0110 0100，无符号右移4位即0110
			resultCharArray[index++] = HEX_DIGITS[b >>> 4 & 0xf];
			// 取低四位，例数字100 二进制：0110 0100 & 1111 按照计算规则结果为 0000 0100去掉多余的0即为 0100
			resultCharArray[index++] = HEX_DIGITS[b & 0xf];
		}
		return stringBuffer.append(resultCharArray).toString();
	}

}
