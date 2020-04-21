package com.kishore.encode;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class EncryptDecryptKey {

    public static void main(String[] args) {
        final String strToDecrypt = "D!g!t@l";
        String apiKey = "dbe7d89523714612a95952498557a9490151e3fc6f4d4766a6c1dc1805fbe84c";
        String apikeySecret = "f4308c5bd697421ca8de05460a4fbb2a42e40427f4a240a488382d0531738c71";
        final SecretKeySpec secretKeySpec = encryptSecretKey(apikeySecret);

        String encryptedApiStr = encryptMthd(apiKey, encryptSecretKey(strToDecrypt));
        System.out.println("encryptedApiStr:" + encryptedApiStr);

        String encryptedStr = encryptMthd(apikeySecret, encryptSecretKey(strToDecrypt));
        System.out.println("encrypted Api Key Secret Str:" + encryptedStr);

        String decryptApiKeyStr = decrypt(encryptedApiStr, encryptSecretKey(strToDecrypt));
        System.out.println("decryptApiKeyStr:" + decryptApiKeyStr);

        String decryptStr = decrypt(encryptedStr, encryptSecretKey(strToDecrypt));
        System.out.println("decryptStr:" + decryptStr);

    }

    public static SecretKeySpec encryptSecretKey(String secretKey) {
        MessageDigest sha = null;
        SecretKeySpec encryptApiSecret = null;
        try {
            byte[] key = secretKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            encryptApiSecret = new SecretKeySpec(key, "AES");
        } catch (final NoSuchAlgorithmException e) {
            e.getMessage();
        }
        return encryptApiSecret;
    }

    public static String decrypt(final String strToDecrypt, final SecretKeySpec secretKey) {
        String decryptedApiKey = "";
        try {
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] c = Base64.decodeBase64(strToDecrypt.getBytes(StandardCharsets.UTF_8));
            decryptedApiKey = new String(cipher.doFinal(c));
        } catch (final Exception e) {
            e.getMessage();
        }
        return decryptedApiKey;
    }

    public static String encryptMthd(final String strToDecrypt, final SecretKeySpec secretKey) {
        String encryptedApiKey = "";
        try {
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] c = cipher.doFinal(strToDecrypt.getBytes());
            encryptedApiKey = new String(Base64.encodeBase64(c));
        } catch (final Exception e) {
            e.getMessage();
        }
        return encryptedApiKey;
    }
}