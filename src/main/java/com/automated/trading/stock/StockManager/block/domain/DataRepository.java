package com.automated.trading.stock.StockManager.block.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
