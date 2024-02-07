//package com.automated.trading.stock.StockManager.util.mapper;
//
//import com.automated.trading.stock.StockManager.stock.block.dto.BlockSaveRequestDto;
//import com.automated.trading.stock.StockManager.stock.block.dto.BlockUpdateRequestDto;
//import com.automated.trading.stock.StockManager.stock.block.dto.ReturnBlockResponseDto;
//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
//public interface BlockMapper {
//
//    void createBlock(BlockSaveRequestDto dto);
//
//    void updateBlock(BlockUpdateRequestDto dto);
//
//    void deleteBlock(int block_id);
//
//    ReturnBlockResponseDto findByHash(String hash);
//
//    ReturnBlockResponseDto findByPreviousHash(String previous_hash);
//
//    int countBlocks();
//
//    String getLastHash();
//
//}
