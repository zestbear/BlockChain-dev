package com.automated.trading.stock.StockManager.community.qna.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QnaRepository extends JpaRepository<Qna, Long> {

    @Modifying
    @Query("update Qna q set q.title = :newTitle, q.content = :newContent, q.wrt_dt = :now")
    void updateQna(@Param("newTitle") String newTitle,
                      @Param("newContent") String newContent,
                      @Param("now") LocalDateTime now);

    @Query("select q from Qna q")
    List<Qna> findAllQna(Pageable pageable);

}
