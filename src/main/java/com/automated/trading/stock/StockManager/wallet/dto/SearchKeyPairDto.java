package com.automated.trading.stock.StockManager.wallet.dto;

import com.automated.trading.stock.StockManager.wallet.domain.KeyPair;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchKeyPairDto {

    private String publicKeyX;
    private String publicKeyY;

    @Builder
    public SearchKeyPairDto(String publicKeyX, String publicKeyY, String privateKey) {
        this.publicKeyX = publicKeyX;
        this.publicKeyY = publicKeyY;
    }

    public SearchKeyPairDto toDto(KeyPair pair) {
        return SearchKeyPairDto.builder()
                .publicKeyX(publicKeyX)
                .publicKeyY(publicKeyY)
                .build();
    }

}
