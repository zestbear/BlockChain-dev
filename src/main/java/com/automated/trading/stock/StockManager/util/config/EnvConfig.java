package com.automated.trading.stock.StockManager.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class EnvConfig {

    @Value("${PostgreSQL_URL}")
    private String database_url;

    @Value("${PostgreSQL_NAME}")
    private String database_name;

    @Scheduled(fixedDelay = 1000)
    public void print() {
        System.out.println(database_url);
        System.out.println(database_name);
    }

}
