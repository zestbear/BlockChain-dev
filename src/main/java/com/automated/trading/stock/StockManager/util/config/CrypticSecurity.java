package com.automated.trading.stock.StockManager.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

@Service
public class CrypticSecurity {

    private EnvConfig envConfig;

    public CrypticSecurity(EnvConfig envConfig) {
        this.envConfig = envConfig;
    }

    @Value("${stock.manager.encrypt.key}")
    private String KEY;

    private static final String ALGORITHM = "AES";

    public String encrypt(String data) throws Exception {
        try {
            Key key = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encVal);
        } catch (Exception e) {
            throw new Exception("Error while encrypting: " + e.toString());
        }
    }

    public String decrypt(String encryptedData) throws Exception {
        try {
            Key key = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedValue = Base64.getDecoder().decode(encryptedData.getBytes(StandardCharsets.UTF_8));
            byte[] decValue = c.doFinal(decodedValue);
            return new String(decValue, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new Exception("Error while decrypting: " + e.toString());
        }
    }

}
