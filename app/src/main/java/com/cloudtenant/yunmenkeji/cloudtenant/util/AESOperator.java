package com.cloudtenant.yunmenkeji.cloudtenant.util;

import com.cloudtenant.yunmenkeji.cloudtenant.util.misc.BASE64Decoder;
import com.cloudtenant.yunmenkeji.cloudtenant.util.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



/**
 * AES 是一种可逆加密算法，对用户的敏感信息加密处理 对原始数据进行AES加密后，在进行Base64编码转化；
 */
public class AESOperator {

    /*
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
     */
    private String sKey = "smkldospdosldaaa";//key，可自行修改
    private String ivParameter = "0392039203920300";//偏移量,可自行修改

    private static AESOperator instance = null;

    private AESOperator() {

    }

    public static AESOperator getInstance() {
        if (instance == null)
            instance = new AESOperator();
        return instance;
    }
    
public static String Encrypt(String encData ,String secretKey,String vector) throws Exception {
        
        if(secretKey == null) {
            return null;
        }
        if(secretKey.length() != 16) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = secretKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(encData.getBytes("utf-8"));
        return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
    }


    // 加密
    public String encrypt(String sSrc) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
    }

    // 解密
    public String decrypt(String sSrc) throws Exception {
        try {
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public String decrypt(String sSrc,String key,String ivs) throws Exception {
        try {
            byte[] raw = key.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivs.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public static String encodeBytes(byte[] bytes) {
        StringBuffer strBuf = new StringBuffer();

        for (int i = 0; i < bytes.length; i++) {
            strBuf.append((char) (((bytes[i] >> 4) & 0xF) + ((int) 'a')));
            strBuf.append((char) (((bytes[i]) & 0xF) + ((int) 'a')));
        }

        return strBuf.toString();
    }

    public static void main(String[] args) throws Exception {
        // 需要加密的字串
        String cSrc = "[{\"request_no\":\"1001\",\"service_code\":\"FS0001\",\"contract_id\":\"100002\",\"order_id\":\"0\",\"phone_id\":\"13913996922\",\"plat_offer_id\":\"100094\",\"channel_id\":\"1\",\"activity_id\":\"100045\"}]";
        
        // 加密
        long lStart = System.currentTimeMillis();
        String enString = AESOperator.getInstance().encrypt(cSrc);
        System.out.println("加密后的字串是：" + enString);

        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("加密耗时：" + lUseTime + "毫秒");
        // 解密
        lStart = System.currentTimeMillis();
        String DeString = AESOperator.getInstance().decrypt("ZX+mygKGL5s9ChuiWtZFZeQKWMjOIjC5em390viOT5NH2SpBpGHQ/iJswgNH8pSYhyRAq8hJZ0SAF3bqhmX4q00m6+4XnThC81OJ/InkAUTGQxpwGza2f+ZPyvb7Ls4f1nJbEp4yF/yU4cLgr1d10YmZFBVywyNTq/Tw5aoXvEIlzyQjzITUzZvUGaUyE6O05fc/Wbo8tqj5D7IZZuqo0acmhxZA90mfUTW1GDvShcebagi5bMssbiB3HB/4gBGN3WZ+TndGE6xEa7o+pi1T+igobrBdXZPK2Rp2ZmeETS4aWUhhq8BOCk8VMJApqEnFsltSjifHJMs52jZBvBfA1ZqKt2e35wbH7eIEYHFO1stmdoJa/auc8rkbbEwPm7QiCsA2SXoqg4kqUOCRlvsL7Uce6YFejrlRR7PI1G0aiJWCB/XUfkw5TNZqqOk5Xu+JUlohPX9UgAcJ8pAmhUfj2MI/+TFdf6u7n54wnj+UlTvAbn95Bx43eZ1qBFAdZbCLMiMGwaW+0YZtcM6sxjHpfOOdZ88HqgTgutgwpbIUaJR+4CGwCGcjg7puK0mOOFmUQfOjK+xiQmsQI3t7K7YR91PZcXOMLHy0f8sFQ6oNpgPINFV3nwuUlTpMKtG343BFqyy6+pKlVLG4eL3CCLLKB4RTV2B4qA3LVZu4QiPTituGyE6PZ7ZAOW45X48ZpJhcEDIbGUnKhm9Juwfbyiqp8w8bBa9O+okkfjMXT4bi5yfRkLkAhBapGVDVF0bU/1m1mkIXUamLh/ktp8fusiypP/zdrNhm1t6z7urB1sQL1hU6ugXi/x2Cyta+X45X6xbZ9xixtOTxqSXE70CXaZs7zX3m4+G1Y090wGN/LGMoQCq2vgg/AUqU6tpontUCjl8JjLnzZ2ZColBE9VgLLMUmD+voX4QfJpEh0auvLKnhR4t7cbKP+FH+fAw/mxEMSeK+BLOKuerQR5Yp16VQu6Tcqg==");
        System.out.println("解密后的字串是：" + DeString);
        lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("解密耗时：" + lUseTime + "毫秒");
    }

}