package com.automated.trading.stock.StockManager.wallet.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KeyPairRepository extends JpaRepository<KeyPair, Long> {

    @Query("SELECT k FROM KeyPair k WHERE k.publicKeyX = :publicKeyX and k.publicKeyY = :publicKeyY")
    Optional<KeyPair> findByPublicKey(@Param("publicKeyX") String publicKeyX,
                                      @Param("publicKeyY") String publicKeyY);

}
