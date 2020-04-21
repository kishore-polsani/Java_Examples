package com.kishore.encode;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class AES128 {

    private static final String characterEncoding = "UTF-8";
    private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
    private static final String aesEncryptionAlgorithm = "AES";

    public static byte[] decryptBase64EncodedWithManagedIV(String encryptedText, String key) throws Exception {
        byte[] cipherText = Base64.decodeBase64(encryptedText.getBytes());
        byte[] keyBytes = Base64.decodeBase64(key.getBytes());
        return decryptWithManagedIV(cipherText, keyBytes);
    }

    public static byte[] decryptWithManagedIV(byte[] cipherText, byte[] key) throws Exception {
        byte[] initialVector = Arrays.copyOfRange(cipherText, 0, 16);
        byte[] trimmedCipherText = Arrays.copyOfRange(cipherText, 16, cipherText.length);
        return decrypt(trimmedCipherText, key, initialVector);
    }

    public static byte[] decrypt(byte[] cipherText, byte[] key, byte[] initialVector) throws Exception {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
        cipherText = cipher.doFinal(cipherText);
        return cipherText;
    }

    public static void main(String[] args) throws Exception {
        //byte[] clearText = decryptBase64EncodedWithManagedIV("CERcUfcNbCAkVxklXVpMqko2FqhE12iU6eldQ9jpFPUl+uVQXKDCXxtfPQ1hwt9A5fIbt60kdVgyFhb2V40z7w==", "mRMjHmlC1C+1L/Dkz8EJuw==");
        byte[] clearText = decryptBase64EncodedWithManagedIV(
            "D9aGlwkdByob2aVX6r5ITcbAjAIBU9MNV1LLoULfJ7eY6EUB6ZQl9S9VypUfMHJZ7S97j4dAkHy4VCGjpEtDbSpE/B/1rgt8L38iOBogt1gNVdEZEXGSMnSmMEwXDTh2mWFSD5FYlEuE1e+h7h6ECpINYlKXX8RyAjAHPVrY27o=:63cWQ6iE/EgYjsVnW+4/SVFzJ1GmuSym1LozBmbkI3/gAWLD/mW2+ljWgM/QyDxR29thuvZU9UJxHbaY9tIoDuy7Op7jxw+T440qH/Lk9CIu+OlxuvEjoAVQYmwEX6DpHaoqXnKCovzOTqb+N5uDxz85EOY4O8dudrFWEvm16u0VzEny2OzvG+UTNk6a/Q17zAR9J7fX4VpFpgb0lJYM77YdV3I11+2UziAHDkJwWjEbDdo1txS7h9NIZfkikGQtXCMKpRX4VhuPMuv1vyRP3fZAhsyn/K40AM7204vjyAEY7Eks2OWFNmQZU4jmRcDd5NTfxehjTcNRaxRQDBZYkvG0CDHyRkAfktkXTBDHPO9Pv5f+ebNN4+OxAt9+XKneK030zdOL/RwEapw1OT4il0D1YkP4A3Tbb5f0cvmu/mB0UgIK8dsrwHJZk59c3YDMtbLxvWwYYxXTuXHGfhc1lzIzm2TMheMcFs/t8krllXU=",
            "5r7owaVHWQnc9P0ZWALBbQ==");
        System.out.println("ClearText:" + new String(clearText, characterEncoding));
    }

}