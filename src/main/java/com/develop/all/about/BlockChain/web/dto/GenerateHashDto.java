package com.develop.all.about.BlockChain.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class GenerateHashDto {

    private String previousHash;
    private String data;
    private String timeStamp;

    @Builder
    public GenerateHashDto(String previousHash, String data, String timeStamp) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = timeStamp;
    }

}
