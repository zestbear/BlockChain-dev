package com.automated.trading.stock.StockManager.wallet.service;

import com.automated.trading.stock.StockManager.wallet.domain.WalletRepository;
import lombok.Getter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

@Service
@Getter
public class WalletService {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private PrivateKey key;

    private String privateKey;
    private String publicXKey;
    private String publicYKey;

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional
    public void createKeypair() {

        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec("prime192v1");

            keyPairGenerator.initialize(ecGenParameterSpec, secureRandom);

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            key = keyPair.getPrivate();

            String parsing = key.toString();
            parsing = parsing.replace("EC Private Key", "");
            parsing = parsing.replaceAll(" ", "");
            parsing = parsing.replaceAll("X:", "");
            parsing = parsing.replaceAll("Y:", "");
            parsing = parsing.replaceAll(":", "");
            parsing = parsing.replaceAll("\\[", "");
            parsing = parsing.replaceAll("]", "");

            String[] parsed = new String[3];
            parsed = parsing.split("\n");

            privateKey = parsed[0];
            publicXKey = parsed[1];
            publicYKey = parsed[2];

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
