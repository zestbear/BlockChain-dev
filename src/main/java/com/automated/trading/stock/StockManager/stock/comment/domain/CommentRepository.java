package com.automated.trading.stock.StockManager.stock.comment.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * 특정 게시물의 모든 댓글 반환
     * @param qna_id
     * @return
     */
    @Query("select c from Comment c where c.qna.id = :qna_id")
    List<Comment> findAllComment(@Param("qna_id") Long qna_id);

}
