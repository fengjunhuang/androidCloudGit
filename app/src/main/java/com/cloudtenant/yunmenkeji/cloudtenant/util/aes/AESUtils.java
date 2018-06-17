package com.cloudtenant.yunmenkeji.cloudtenant.util.aes;

import com.cloudtenant.yunmenkeji.cloudtenant.util.base64.AESType;
import com.cloudtenant.yunmenkeji.cloudtenant.util.base64.Base64;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



/*******************************************************************************
 * AES�ӽ����㷨
 * 
 * 
 */

public class AESUtils {

	// ������Ϣ

	private static String WAYS = "AES";
	private static String MODE = "";
	private static String IV = "1234567890123456";
	private static int AES_SIZE = 128;
	private static int pwdLength = 16;
	private static String defaultPwd = null;
	private static boolean isPwd = false;
	private static String ModeCode = "PKCS5Padding";

	private static int type = 0;// Ĭ��

	public static String selectMod(int type) {
		// ECB("ECB", "0"), CBC("CBC", "1"), CFB("CFB", "2"), OFB("OFB", "3");
		switch (type) {
		case 0:
			isPwd = false;
			MODE = WAYS + "/" + AESType.ECB.key() + "/" + ModeCode;

			break;
		case 1:
			isPwd = true;
			MODE = WAYS + "/" + AESType.CBC.key() + "/" + ModeCode;
			break;
		case 2:
			isPwd = true;
			MODE = WAYS + "/" + AESType.CFB.key() + "/" + ModeCode;
			break;
		case 3:
			isPwd = true;
			MODE = WAYS + "/" + AESType.OFB.key() + "/" + ModeCode;
			break;

		}

		return MODE;

	}

	/**
	 * ����һ���̶���Կ
	 * 
	 * @param password
	 *            ���ȱ�����16�ı���
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static SecretKeySpec toKey(String password)
			throws UnsupportedEncodingException {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(WAYS);

			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();

			System.out.println(new String(enCodeFormat).getBytes("UTF-8"));
			return new SecretKeySpec(enCodeFormat, WAYS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ����
	public static String Encrypt(String content) throws Exception {

		SecretKeySpec skeySpec = toKey(defaultPwd);
		Cipher cipher = Cipher.getInstance(selectMod(type));// "�㷨/ģʽ/���뷽ʽ"//
		IvParameterSpec iv = new IvParameterSpec(IV.getBytes());// ʹ��CBCģʽ����Ҫһ������iv�������Ӽ����㷨��ǿ��
		if (isPwd == false) {
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		} else {
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		}

		byte[] encrypted = cipher.doFinal(content.getBytes());

		return Base64.encode(new String(encrypted));// �˴�ʹ��BASE64��ת�빦�ܣ�ͬʱ����2�μ��ܵ����á�
	}

	// ����
	public static String Decrypt(String content) throws Exception {
		try {

			SecretKeySpec skeySpec = toKey(defaultPwd);
			Cipher cipher = Cipher.getInstance(selectMod(type));
			IvParameterSpec iv = new IvParameterSpec(IV.getBytes());
			if (isPwd == false) {
				cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			} else {
				cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			}

			byte[] encrypted1 = Base64.decode(content, "UTF-8").getBytes();
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original);
				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}

	/**
	 * ��������ת����ʮ������
	 * 
	 * @param buf
	 * @return
	 */
	private static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * ��ʮ������ת��Ϊ������
	 * 
	 * @param hexStr
	 * @return
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) {
			return null;
		} else {
			byte[] result = new byte[hexStr.length() / 2];
			for (int i = 0; i < hexStr.length() / 2; i++) {
				int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1),
						16);
				int low = Integer.parseInt(
						hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
				result[i] = (byte) (high * 16 + low);
			}
			return result;
		}
	}

	public static void main(String[] args) throws Exception {
		/*
		 * �����õ�Key ������26����ĸ��������ɣ���ò�Ҫ�ñ����ַ�����Ȼ�����������ô�þ������˿��������
		 * �˴�ʹ��AES-128-CBC����ģʽ��key��ҪΪ16λ��
		 */

		isPwd = false;
		defaultPwd = "admin";
		String resultString = AESUtils.Encrypt("HelloWrod");

		System.out.println(resultString);
		System.out.println(AESUtils.Decrypt(resultString));
	}
}