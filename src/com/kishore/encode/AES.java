package com.kishore.encode;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Aes encryption
 */
public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    private static String decryptedString;
    private static String encryptedString;

    public static void setKey(String myKey) {

        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            System.out.println(Base64.decodeBase64(myKey));

            //String str = new String(myKey.getBytes("UTF-8"), StandardCharsets.UTF_8);
            //System.out.println(str);
            //  key = Base64.decodeBase64(str);
            System.out.println(key.length);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            System.out.println(key.length);
            System.out.println(new String(key, StandardCharsets.UTF_8));
            secretKey = new SecretKeySpec(key, "AES");

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String getDecryptedString() {
        return decryptedString;
    }

    public static void setDecryptedString(String decryptedString) {
        AES.decryptedString = decryptedString;
    }

    public static String getEncryptedString() {
        return encryptedString;
    }

    public static void setEncryptedString(String encryptedString) {
        AES.encryptedString = encryptedString;
    }

    public static String encrypt(String strToEncrypt) {
        try {
            //  Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            setEncryptedString(URLEncoder.encode(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8))), "UTF-8"));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));

        } catch (Exception e) {

            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        final String strToEncrypt = "BusinessUnitCode=CXDG|AccountNumber=null|EmailAddress=kishore.polsani@gmail.com|CustomerName=Kishore Polsani|TRPaymentCompanyId=CXDigital|ContactName=Kishore Polsani|AddressLine1=null|City=eagan|State=Minnesota|Country=United States|Telephone=435|PostalCode=55123|QuoteNumber=null|PaymentCurrency=$|PaymentAmount=124.8";
        final String strPssword = "5r7owaVHWQnc9P0ZWALBbQ==";
        //final String strPssword = "380db410e8b11fa9";

        byte[] stg = Base64.decodeBase64(strPssword);
        String s = new String(stg);
        //System.out.println(s);
        //System.out.println(Base64.decodeBase64(strPssword));
        AES.setKey(strPssword);

        AES.encrypt(strToEncrypt.trim());

        System.out.println("String to Encrypt: " + strToEncrypt);
        System.out.println("Encrypted: " + AES.getEncryptedString());

        //final String strToDecrypt =  AES.getEncryptedString();
        final String strToDecrypt = AES.getEncryptedString();
        //final String strToDecrypt = "D9aGlwkdByob2aVX6r5ITcbAjAIBU9MNV1LLoULfJ7eY6EUB6ZQl9S9VypUfMHJZ7S97j4dAkHy4VCGjpEtDbSpE/B/1rgt8L38iOBogt1gNVdEZEXGSMnSmMEwXDTh2mWFSD5FYlEuE1e+h7h6ECpINYlKXX8RyAjAHPVrY27o=:63cWQ6iE/EgYjsVnW+4/SVFzJ1GmuSym1LozBmbkI3/gAWLD/mW2+ljWgM/QyDxR29thuvZU9UJxHbaY9tIoDuy7Op7jxw+T440qH/Lk9CIu+OlxuvEjoAVQYmwEX6DpHaoqXnKCovzOTqb+N5uDxz85EOY4O8dudrFWEvm16u0VzEny2OzvG+UTNk6a/Q17zAR9J7fX4VpFpgb0lJYM77YdV3I11+2UziAHDkJwWjEbDdo1txS7h9NIZfkikGQtXCMKpRX4VhuPMuv1vyRP3fZAhsyn/K40AM7204vjyAEY7Eks2OWFNmQZU4jmRcDd5NTfxehjTcNRaxRQDBZYkvG0CDHyRkAfktkXTBDHPO9Pv5f+ebNN4+OxAt9+XKneK030zdOL/RwEapw1OT4il0D1YkP4A3Tbb5f0cvmu/mB0UgIK8dsrwHJZk59c3YDMtbLxvWwYYxXTuXHGfhc1lzIzm2TMheMcFs/t8krllXU=";
        AES.decrypt(strToDecrypt.trim());

        System.out.println("String To Decrypt : " + strToDecrypt);
        System.out.println("Decrypted : " + AES.getDecryptedString());

    }

}