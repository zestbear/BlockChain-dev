package com.automated.trading.stock.StockManager.stock.wallet;

import com.automated.trading.stock.StockManager.stock.wallet.SearchKeyPairDto;

public interface WalletService {

    public String[] createKeypair();

    public Boolean checkKey(SearchKeyPairDto searchKeyPairDto, String privateKey) throws Exception;

}
