package com.automated.trading.stock.StockManager.util.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.automated.trading.stock.StockManager.util.api.ApiResponseType.SUCCESS;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private final Integer code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public ApiResponse(T result) {
        this.code = SUCCESS.getCode();
        this.message = SUCCESS.getMessage();
        this.result = result;
    }

    public ApiResponse(ApiResponseType type) {
        this.code = type.getCode();
        this.message = type.getMessage();
    }

}