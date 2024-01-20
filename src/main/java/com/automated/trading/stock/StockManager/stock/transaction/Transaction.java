package com.automated.trading.stock.StockManager.stock.transaction;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @Column // 수신자 공개키
    private String senderKey;

    @Column // 송신자 공개키
    private String receiverKey;

    @Column // 전송 수량
    private Long count;

    @Column // 수신자가 보낼 돈을 가지고 있다는 것을 증명 할 이전 트랜잭션 참조값
    private String transactionInput;

    @Column // 거래에서 받은 관련 주소 금액 -> 다음에 일어날 새 트랜잭션의 Input으로 사용됨
    private String transactionOutput;

    @Column // 주소의 송신자가 데이터가 변경되지 않았음을 증명하는 서명(ex> 제 3자가 임의로 금액을 바꾸지 못하게)
    private String signature;

}
