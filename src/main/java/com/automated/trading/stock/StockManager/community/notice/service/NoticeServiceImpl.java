package com.automated.trading.stock.StockManager.community.notice.service;

import com.automated.trading.stock.StockManager.community.member.domain.Member;
import com.automated.trading.stock.StockManager.community.member.domain.MemberRepository;
import com.automated.trading.stock.StockManager.community.notice.controller.dto.NoticeSaveRequestDto;
import com.automated.trading.stock.StockManager.community.notice.controller.dto.NoticeUpdateRequestDto;
import com.automated.trading.stock.StockManager.community.notice.controller.dto.ReturnNoticeResponseDto;
import com.automated.trading.stock.StockManager.community.notice.domain.Notice;
import com.automated.trading.stock.StockManager.community.notice.domain.NoticeRepository;
import com.automated.trading.stock.StockManager.util.exception.MemberNotExistException;
import com.automated.trading.stock.StockManager.util.exception.NullTextFieldException;
import com.automated.trading.stock.StockManager.util.exception.PostNotExistException;
import com.automated.trading.stock.StockManager.util.exception.PostWriterNotMatchException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final MemberRepository memberRepository;
    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(MemberRepository memberRepository, NoticeRepository noticeRepository) {
        this.memberRepository = memberRepository;
        this.noticeRepository = noticeRepository;
    }

    /**
     * 공지사항 저장
     */
    @Override
    @Transactional
    public void saveNotice(Long writer, NoticeSaveRequestDto dto) {
        Member findMember = memberRepository.findById(writer)
                .orElseThrow(MemberNotExistException::new);

        if (dto.getTitle().isEmpty() || dto.getContent().isEmpty()) {
            throw new NullTextFieldException();
        }

        Notice notice = Notice.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(findMember)
                .imprtnc(dto.getImprtnc())
                .build();

        noticeRepository.save(notice);
        findMember.addNotice(notice);
    }

    /**
     * 공지사항 수정
     *
     * #성능
     * notice의 양방향 연관관계에 있는 member를 select문으로 호출하는 것은 과연 필요한 작업일까?
     */
    @Override
    @Transactional
    public void updateNotice(Long writer, Long post_fk, NoticeUpdateRequestDto dto) {
        LocalDateTime now = LocalDateTime.now();
        Notice notice = noticeRepository.findById(post_fk)
                .orElseThrow(PostNotExistException::new);

        if (dto.getTitle().isEmpty() || dto.getContent().isEmpty()) {
            throw new NullTextFieldException();
        }

        String newTitle;
        String newContent;
        if (notice.getWriter().getId().equals(writer)) {
            if (dto.getTitle().equals(notice.getTitle())) {
                newTitle = notice.getTitle();
            } else {
                newTitle = dto.getTitle();
            }
            if (dto.getContent().equals(notice.getContent())) {
                newContent = notice.getContent();
            } else {
                newContent = dto.getContent();
            }
            noticeRepository.updateNotice(newTitle, newContent, now);
        } else {
            throw new PostWriterNotMatchException();
        }
    }

    /**
     * 공지사항 삭제
     */
    @Override
    public void deleteNotice(Long writer, Long post_fk) {
        Notice notice = noticeRepository.findById(post_fk)
                .orElseThrow(PostNotExistException::new);
        if (notice.getWriter().getId().equals(writer)) {
            noticeRepository.delete(notice);
        } else {
            throw new PostWriterNotMatchException();
        }
    }

    /**
     * 공지사항 모두 반환
     */
    @Override
    public List<ReturnNoticeResponseDto> findAllNotices(int size, int page) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"));
        List<Notice> allNotice = noticeRepository.findAllNotice(pageable);
        List<ReturnNoticeResponseDto> returnNotice = new ArrayList<>();
        for (Notice notice : allNotice) {
            returnNotice.add(notice.toEntity());
        }

        return returnNotice;
    }

}
