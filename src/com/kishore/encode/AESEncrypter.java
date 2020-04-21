package com.kishore.encode;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESEncrypter {

    private String encryptedText;
    private String key;
    private static String characterEncoding = "UTF-8";
    private String cipherTransformation = "AES/CBC/PKCS5Padding";
    private String aesEncryptionAlgorithm = "AES";
    private static final Logger log = LoggerFactory.getLogger(AESEncrypter.class);

    public AESEncrypter(String encryptedText, String key) {
        this.encryptedText = encryptedText;
        this.key = key;
    }

    public byte[] decrypt(byte[] cipherText, byte[] key, byte[] initialVector) {

        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            SecretKeySpec secretKeySpecy = new SecretKeySpec(key, aesEncryptionAlgorithm);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
            cipherText = cipher.doFinal(cipherText);
        } catch (IllegalBlockSizeException e) {
            log.error(e.getMessage());
        } catch (BadPaddingException e) {
            log.error(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        } catch (NoSuchPaddingException e) {
            log.error(e.getMessage());
        } catch (InvalidKeyException e) {
            log.error(e.getMessage());
        } catch (InvalidAlgorithmParameterException e) {
            log.error(e.getMessage());
        }
        return cipherText;
    }

    private static byte[] getKeyBytes(String key) {
        byte[] keyBytes = new byte[16];
        byte[] parameterKeyBytes;
        try {
            parameterKeyBytes = key.getBytes(characterEncoding);
            System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return keyBytes;
    }

    public String decrypt() throws GeneralSecurityException, IOException {
        byte[] cipheredBytes = Base64.decodeBase64(encryptedText);
        byte[] keyBytes = getKeyBytes(key);
        return new String(decrypt(cipheredBytes, keyBytes, keyBytes), characterEncoding);
    }

    public byte[] encrypt(byte[] plainText, byte[] key, byte[] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        plainText = cipher.doFinal(plainText);
        return plainText;
    }

    public String encrypt(String plainText, String key) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] plainTextbytes = plainText.getBytes(characterEncoding);
        byte[] keyBytes = getKeyBytes(key);
        Base64 base64 = new Base64();
        return base64.encodeToString(encrypt(plainTextbytes, keyBytes, keyBytes));
    }

}
