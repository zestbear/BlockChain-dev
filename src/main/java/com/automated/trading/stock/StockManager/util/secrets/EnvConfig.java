package com.automated.trading.stock.StockManager.util.secrets;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class EnvConfig {

    @Value("${spring.datasource.url}")
    private String database_url;

    @Value("${spring.datasource.username}")
    private String database_name;

    @Value("${stock.manager.encrypt.key}")
    private String secretKey;

}
