package com.alibaba.demo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/*
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
*/


public class DemoGoogle {

    private static final int SECRET_SIZE = 10;

    private static final String SEED = "g8GjEvTbW5oVSV7avLBdwIHqGlUYNzKFI7izOF8GwLDVKs2m0QN7vxRs2im5MDaNCWGmcD2rvcZx";

    private static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";

    public static void main(String[] args){

    }
  /*  private static String generateSecretKey() {
   *//*     SecureRandom sr = null;
        try {
       *//**//*     sr = SecureRandom.getInstance(RANDOM_NUMBER_ALGORITHM);
            sr.setSeed(Base64.decodeBase64(SEED));
            byte[] buffer = sr.generateSeed(SECRET_SIZE);
            Base32 codec = new Base32();
            byte[] bEncodedKey = codec.encode(buffer);
            String encodedKey = new String(bEncodedKey);*//**//*
            return null;
        }catch (NoSuchAlgorithmException e) {
        }
        return null;*//*
    }*/
}
