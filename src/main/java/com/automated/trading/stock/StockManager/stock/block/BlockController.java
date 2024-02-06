package com.automated.trading.stock.StockManager.stock.block;

import com.automated.trading.stock.StockManager.stock.block.dto.BlockSaveRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @PostMapping("/block/save/{member_id}")
    public ResponseEntity<String> createBlock(@PathVariable("member_id") int member_id,
                                              @RequestBody BlockSaveRequestDto dto) {
        dto.setMember_id(member_id);
        try {
            blockService.createBlock(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create block: " + e.getMessage());
        }
        log.info("Block created successfully");
        return ResponseEntity.ok("Block created successfully");
    }

}
