package com.automated.trading.stock.StockManager.wallet;

import com.automated.trading.stock.StockManager.keypair.SearchKeyPairDto;

public interface WalletService {

    public String[] createKeypair();

    public Boolean checkKey(SearchKeyPairDto searchKeyPairDto, String privateKey) throws Exception;

}
