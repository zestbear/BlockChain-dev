package com.develop.all.about.BlockChain.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnBlockChainResponseDto {

    private int block_id;
    private String hash;
    private String previous_hash;
    private String time_stamp;
    private Boolean is_last;
    private int member_id;

}
