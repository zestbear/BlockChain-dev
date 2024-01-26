package com.automated.trading.stock.StockManager.stock.block;

import com.automated.trading.stock.StockManager.stock.block.dto.BlockDto;

public interface BlockMapper {

    void createBlock(BlockDto dto);

    void updateBlock(int block_id);

    void deleteBlock(BlockDto dto);

    BlockDto findById(int block_id);

}
