package com.develop.all.about.BlockChain.secrets;

import com.develop.all.about.BlockChain.api.ApiResponseType;
import com.develop.all.about.BlockChain.api.exception.CryptionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

@Slf4j
@Configuration
public class CrypticSecurity {

    @Value("${blockchain.develop.encrypt.key}")
    private String KEY;

    private static final String ALGORITHM = "AES";

    public String encrypt(String data) throws Exception {
        try {
            Key key = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encVal);
        } catch (CryptionException cryptionException) {
            log.error(ApiResponseType.Cryption_ERROR.getMessage());
            throw new CryptionException();
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
        } catch (CryptionException cryptionException) {
            log.error(ApiResponseType.Cryption_ERROR.getMessage());
            throw new CryptionException();
        }
    }

}
