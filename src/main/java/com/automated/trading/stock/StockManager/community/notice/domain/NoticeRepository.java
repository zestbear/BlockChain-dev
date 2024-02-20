package com.automated.trading.stock.StockManager.community.notice.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("select n from Notice n where n.writer.id = :writer")
    Optional<Notice> findByMember(@Param("writer") int writer);

    @Modifying
    @Query("update Notice n set n.title = :newTitle, n.content = :newContent, n.wrt_dt = :now")
    void updateNotice(@Param("newTitle") String newTitle,
                      @Param("newContent") String newContent,
                      @Param("now") LocalDateTime now);

    @Query("select n from Notice n")
    List<Notice> findAllNotice(Pageable pageable);
}
