package com.automated.trading.stock.StockManager.wallet.service;

import com.automated.trading.stock.StockManager.wallet.dto.SearchKeyPairDto;

public interface WalletService {

    public String[] createKeypair();

    public Boolean checkKey(SearchKeyPairDto searchKeyPairDto, String privateKey) throws Exception;

}
