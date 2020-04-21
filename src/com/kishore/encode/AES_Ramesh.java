package com.kishore.encode;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.SQLException;

public class AES_Ramesh {

    public static void main(String[] args) {
        byte[] decodedByte = Base64.decodeBase64("5r7owaVHWQnc9P0ZWALBbQ==");
        try {
            Blob blob = new SerialBlob(decodedByte);
        } catch (SerialException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String detail = "D9aGlwkdByob2aVX6r5ITcbAjAIBU9MNV1LLoULfJ7eY6EUB6ZQl9S9VypUfMHJZ7S97j4dAkHy4VCGjpEtDbSpE/B/1rgt8L38iOBogt1gNVdEZEXGSMnSmMEwXDTh2mWFSD5FYlEuE1e+h7h6ECpINYlKXX8RyAjAHPVrY27o=:63cWQ6iE/EgYjsVnW+4/SVFzJ1GmuSym1LozBmbkI3/gAWLD/mW2+ljWgM/QyDxR29thuvZU9UJxHbaY9tIoDuy7Op7jxw+T440qH/Lk9CIu+OlxuvEjoAVQYmwEX6DpHaoqXnKCovzOTqb+N5uDxz85EOY4O8dudrFWEvm16u0VzEny2OzvG+UTNk6a/Q17zAR9J7fX4VpFpgb0lJYM77YdV3I11+2UziAHDkJwWjEbDdo1txS7h9NIZfkikGQtXCMKpRX4VhuPMuv1vyRP3fZAhsyn/K40AM7204vjyAEY7Eks2OWFNmQZU4jmRcDd5NTfxehjTcNRaxRQDBZYkvG0CDHyRkAfktkXTBDHPO9Pv5f+ebNN4+OxAt9+XKneK030zdOL/RwEapw1OT4il0D1YkP4A3Tbb5f0cvmu/mB0UgIK8dsrwHJZk59c3YDMtbLxvWwYYxXTuXHGfhc1lzIzm2TMheMcFs/t8krllXU=";
        byte[] detailsByteArray = detail.getBytes();
        try {
            Blob detailBlob = new SerialBlob(detailsByteArray);
        } catch (SerialException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // keyGenerator.init(AES_128);
        //Generate Key
        SecretKey skey = keyGenerator.generateKey();
        //Initialization vector
        SecretKey IV = keyGenerator.generateKey();

        try {
            String text = detail;
            // String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(skey.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            String encrptString = new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
