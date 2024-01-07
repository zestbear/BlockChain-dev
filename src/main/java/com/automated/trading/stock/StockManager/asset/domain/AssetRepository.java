package com.automated.trading.stock.StockManager.asset.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Long, Asset> {
}
