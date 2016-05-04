package scxd.jcz.ajlw.android.Activity.Common;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class DESUtil {

	/**
	 * DES�㷨��Կ
	 */
	private static final byte[] DES_KEY = new String("9ce84a1f").getBytes();

	/**
	 * ���ݼ��ܣ��㷨��DES��
	 * 
	 * @param data
	 *            Ҫ���м��ܵ�����
	 * @return ���ܺ������
	 */
	public static String encryptBasedDes(String str) {
		String encryptedData = null;
		String data = "";
		try {
			// DES�㷨Ҫ����һ�������ε������Դ
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			// ����һ���ܳ׹�����Ȼ��������DESKeySpecת����һ��SecretKey����
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			// ���ܶ���
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
			// ���ܣ������ֽ����������ַ���
			encryptedData = new BASE64Encoder().encode(cipher.doFinal(data
					.getBytes("UTF8")));
		} catch (Exception e) {
			throw new RuntimeException("���ܴ��󣬴�����Ϣ��", e);
		}
		return encryptedData;
	}

	/**
	 * ���ݽ��ܣ��㷨��DES��
	 * 
	 * @param cryptData
	 *            ��������
	 * @return ���ܺ������
	 */
	public static String decryptBasedDes(String cryptData) {
		String decryptedData = null;
		try {
			// DES�㷨Ҫ����һ�������ε������Դ
			SecureRandom sr = new SecureRandom();
			DESKeySpec deskey = new DESKeySpec(DES_KEY);
			// ����һ���ܳ׹�����Ȼ��������DESKeySpecת����һ��SecretKey����
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(deskey);
			// ���ܶ���
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
			// ���ַ�������Ϊ�ֽ����飬������
			decryptedData = new String(cipher.doFinal(new BASE64Decoder()
					.decodeBuffer(cryptData)), "UTF8");
		} catch (Exception e) {
			throw new RuntimeException("���ܴ��󣬴�����Ϣ��", e);
		}
		return decryptedData;
	}

	public static String encrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		return toHexString(cipher.doFinal(message.getBytes("UTF-8")));
	}

	public static String decrypt(String message, String key) throws Exception {

		byte[] bytesrc = convertHexString(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}

	public static byte[] convertHexString(String ss) {
		byte digest[] = new byte[ss.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = ss.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}

		return digest;
	}

	public static String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}

		return hexString.toString();
	}

}
