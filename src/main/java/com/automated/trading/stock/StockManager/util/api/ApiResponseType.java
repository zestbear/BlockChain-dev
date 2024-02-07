package com.automated.trading.stock.StockManager.util.api;

import lombok.Getter;

@Getter
public enum ApiResponseType {

    SUCCESS(200, "API 요청이 성공했습니다."),

    /* 사용자 관련 Error */
    DuplicatedEmail_ERROR(102, "중복 ID가 존재합니다."),
    MemberNotExist_ERROR(103, "해당 사용자가 존재하지 않습니다."),

    /* 게시물 관련 Error */
    PostWriter_ERROR(104, "해당 게시물의 작성자가 아닙니다."),
    PostNotExist_ERROR(105, "해당 게시물이 존재하지 않습니다."),
    NullTextField_ERROR(106, "입력 텍스트박스가 null 입니다."),

    BAD_REQUEST(201,"불가능한 요청입니다."),
    ERROR(500, "에러가 발생했습니다.");

    private final Integer code;
    private final String message;

    ApiResponseType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}