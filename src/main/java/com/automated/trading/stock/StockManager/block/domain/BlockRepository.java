package com.automated.trading.stock.StockManager.block.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {

//    기본 내장 함수 (중복)
//    @Query("SELECT b FROM Block b WHERE b.id = :id")
//    Optional<Block> findById(@Param("id") Long id);

}
