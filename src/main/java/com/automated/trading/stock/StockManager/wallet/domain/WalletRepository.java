package com.automated.trading.stock.StockManager.wallet.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Long, Wallet> {
}
