package com.automated.trading.stock.StockManager.stock.transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

    private int transaction_id; // PK
    private String sender_key; // 송신자 공개키
    private String receiver_key; // 수신자 공개키
    private int count; // 보내는 갯수
    private String transaction_input; // 수신자가 보낼 돈을 가지고 있다는 것을 증명 할 이전 트랜잭션 참조값
    private String transaction_output; // 거래에서 받은 관련 주소 금액 -> 다음에 일어날 새 트랜잭션의 input으로 사용됨
    private String signature; // 주소의 송신자가 데이터가 변겨오디지 않았음을 증명하는 서명 (ex. 제 3자가 임의로 금액을 바꾸지 못하게 하는 역할)
    private String tran_dt; // 거래 시간
    private int data_fk; // FK

}
