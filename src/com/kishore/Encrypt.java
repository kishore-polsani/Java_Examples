package com.kishore;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Encrypt {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        String encryptString = "a4N4D0000000XQ5UAM";
        final String KEY = "digital";
        Encrypt obj = new Encrypt();
        String encryptedString = obj.encrypt(encryptString, obj.encryptSecretKey(KEY));
        System.out.println("encryptedString: " + encryptedString);
        //output encryptedString: FzHwIRwsuOfatPtYn8C/5qgRHwX7DP5FpjCVgqut5xE=
        String decyptedString = obj.decrypt(encryptedString, obj.encryptSecretKey(KEY));
        System.out.println("decyptedString: " + decyptedString);
    }

    public SecretKeySpec encryptSecretKey(final String secretKey) {
        MessageDigest sha = null;
        SecretKeySpec encryptApiSecret = null;
        try {
            byte[] key = secretKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            encryptApiSecret = new SecretKeySpec(key, "AES");
        } catch (final NoSuchAlgorithmException e) {
            LOGGER.error("Exception occurred in TRCommerceEncrypter:encryptApiSecret", e);
        }
        return encryptApiSecret;
    }

    public String decrypt(final String strToDecrypt, final SecretKeySpec secretKey) {
        String decryptedApiKey = "";
        try {
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] c = Base64.decodeBase64(strToDecrypt.getBytes(StandardCharsets.UTF_8));
            decryptedApiKey = new String(cipher.doFinal(c));
        } catch (final Exception e) {
            LOGGER.error("Exception occurred in TRCommerceEncrypter:decrypt", e);
        }
        return decryptedApiKey;
    }

    public String encrypt(final String strToDecrypt, final SecretKeySpec secretKey) {
        String encryptedApiKey = "";
        try {
            final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] c = cipher.doFinal(strToDecrypt.getBytes());
            encryptedApiKey = new String(Base64.encodeBase64(c));
        } catch (final Exception e) {
            LOGGER.error("Exception occurred in TRCommerceEncrypter:encrypt", e);
        }
        return encryptedApiKey;
    }

    public static String decryptID(String id_param) {/*
	    if(id_param == null) return null;
	    String key="digital";
	    //encrypted blob
	    Blob encodedEncryptedBlob = EncodingUtil.base64Decode(id_param);
	    //decrypted blob
	    Blob decryptedBlob = Crypt.decryptWithManagedIV("AES128", key, encodedEncryptedBlob);
	    //decrypted string
	    String decryptedClearText = decryptedBlob.toString();

	    LOGGER.debug(decryptedClearText);

	    return decryptedClearText;
	    */
        return null;

    }

}
