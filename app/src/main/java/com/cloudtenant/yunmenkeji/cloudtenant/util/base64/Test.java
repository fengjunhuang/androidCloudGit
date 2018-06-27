package com.cloudtenant.yunmenkeji.cloudtenant.util.base64;


public class Test {

	public static void main(String[] args) {

		String content = "18420013303";
		String skey = "smkldospdosldaaa";
		try {
			//����
			byte[] encryptResultStr = BackAES.encrypt(content, skey, 0);

			System.out.println("����-���ܺ�"+new String(encryptResultStr));
			String decryptString=BackAES.decrypt(new String(encryptResultStr),
					skey, 0);
			System.out.println("����-���ܺ�"+decryptString);
			
			/**
			 * String parseByte2HexStr(byte buf[]) //**��������ת����16����
			 *byte[] parseHexStr2Byte(String hexStr) //java��16����ת��Ϊ������
			 */
			
			
//			String skey2 = "admin";
//			byte[] encryptResultStr2 = BackAES.newencrypt(content, skey2);
//		
//			//System.out.println("���������ܺ�"+new String(encryptResultStr2));
//			////.java��2��������ת����16����parseHexStr2Byte
//			String toByteString=BackAES.parseByte2HexStr(encryptResultStr2);//java��16����ת��Ϊ������
//			System.out.println("���������ܺ�ת��16���ƣ�"+toByteString);
//			
//			
//			// /**��16����ת����2����
//
//			byte[] ascToByte=BackAES.parseHexStr2Byte(toByteString);
//			System.out.println("�����������ܺ�ת�ɶ����ƣ�"+new String(ascToByte));
//			
//			byte[] decryptString2=BackAES.newdecrypt(ascToByte,skey2);
//			System.out.println("���������ܺ�"+new String(decryptString2));
//			
		
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		// String result1 = Base64.encode(encryptResultStr, chartCode);
		// System.out.println("Base64ת���" + result1);
		//
		// System.out.println("============================================");
		// String result2 = Base64.decode(result1, chartCode);
		// System.out.println("Base64�����" + result2);

	}
}
