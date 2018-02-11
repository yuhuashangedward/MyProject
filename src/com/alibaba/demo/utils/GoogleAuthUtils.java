package com.alibaba.demo.utils;


import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;



/**
 * @function 谷歌验证器校验类
 * @author WangZhenwei
 *
 * @version 2017年3月25日 下午1:57:28
 */
public class GoogleAuthUtils {

    // taken from Google pam docs - we probably don't need to mess with these
    private static final int SECRET_SIZE = 10;

    private static final String SEED = "g8GjEvTbW5oVSV7avLBdwIHqGlUYNzKFI7izOF8GwLDVKs2m0QN7vxRs2im5MDaNCWGmcD2rvcZx";

    private static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";

    int window_size = 3;

    public void setWindowSize(int s) {
        if (s >= 1 && s <= 17)
            window_size = s;
    }


    /**
     * 校验谷歌验证码是否有效
     * @param codes  校验码
     * @param savedSecret  保存的秘钥
     * @return
     */
    public static Boolean authcode(String codes, String savedSecret) {
        if(!GoogleAuthUtils.isLong(codes)){
            return false;
        }
        long code = Long.parseLong(codes);
        long t = System.currentTimeMillis();
        GoogleAuthUtils ga = new GoogleAuthUtils();
        ga.setWindowSize(1);
        boolean r = ga.check_code(savedSecret, code, t);
        return r;
    }

    /**
     * 初始化获取私钥，传入user
     * @param
     * @return
     */
    public static String genSecret() {
        String secret = GoogleAuthUtils.generateSecretKey();
        return secret;
    }

    private static String generateSecretKey() {
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance(RANDOM_NUMBER_ALGORITHM);
            sr.setSeed(Base64.decodeBase64(SEED));
            byte[] buffer = sr.generateSeed(SECRET_SIZE);
            Base32 codec = new Base32();
            byte[] bEncodedKey = codec.encode(buffer);
            String encodedKey = new String(bEncodedKey);
            return encodedKey;
        }catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

    /**
     * 获取二维码参数
     * @param
     * @param
     * @param secret
     * @return
     */
    public static String getQRBarcodeURL(String email, String secret) {
        String host = "SuperBit";
        String format = "otpauth://totp/%s:%s?secret=%s&issuer=%s";
        return String.format(format, host, email, secret,host);
    }

    /**
     * 校验谷歌验证码正确性，内部方法，根据私钥，验证码和时间进行校验
     * @param secret
     * @param code
     * @param timeMsec
     * @return
     */
    private boolean check_code(String secret, long code, long timeMsec) {
        Base32 codec = new Base32();
        byte[] decodedKey = codec.decode(secret);
        long t = (timeMsec / 1000L) / 30L;
        for (int i = 0; i <= window_size; ++i) {
            long hash;
            try {
                hash = verify_code(decodedKey, t + i);
            }catch (Exception e) {
                return false;
            }
            if (hash == code) {
                return true;
            }
        }
        return false;
    }

    private static int verify_code(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] data = new byte[8];
        long value = t;
        for (int i = 8; i-- > 0; value >>>= 8) {
            data[i] = (byte) value;
        }
        SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signKey);
        byte[] hash = mac.doFinal(data);
        int offset = hash[20 - 1] & 0xF;
        long truncatedHash = 0;
        for (int i = 0; i < 4; ++i) {
            truncatedHash <<= 8;
            truncatedHash |= (hash[offset + i] & 0xFF);
        }
        truncatedHash &= 0x7FFFFFFF;
        truncatedHash %= 1000000;
        return (int) truncatedHash;
    }

    public static void main(String[] args) {
        String key = genSecret();
        System.out.println(key);
        boolean b = authcode("061729","BCCJS6XYTABENRZB");
        String a = getQRBarcodeURL("wangzhenwei@bitape.com","BCCJS6XYTABENRZB");
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * @function 判断对象是否是Long类型
     * @param str
     * @return
     */
    private static boolean isLong(String str) {
        try{
            validateIsLong(str, null);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    /**@function 字符串不是Long类型时抛出异常
     * @param str
     * @throws
     */
    private static void validateIsLong(String str, String paramName)throws Exception {
        try{
            Long.parseLong(str);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
