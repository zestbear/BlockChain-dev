package com.automated.trading.stock.StockManager.stock.qna.service;

import com.automated.trading.stock.StockManager.stock.member.domain.Member;
import com.automated.trading.stock.StockManager.stock.member.domain.MemberRepository;
import com.automated.trading.stock.StockManager.stock.qna.controller.dto.QnaSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.qna.controller.dto.QnaUpdateRequestDto;
import com.automated.trading.stock.StockManager.stock.qna.controller.dto.ReturnQnaResponseDto;
import com.automated.trading.stock.StockManager.stock.qna.domain.Qna;
import com.automated.trading.stock.StockManager.stock.qna.domain.QnaRepository;
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
public class QnaServiceImpl implements QnaService {

    private final MemberRepository memberRepository;
    private final QnaRepository qnaRepository;

    public QnaServiceImpl(MemberRepository memberRepository, QnaRepository qnaRepository) {
        this.memberRepository = memberRepository;
        this.qnaRepository = qnaRepository;
    }

    /**
     * Q&A 저장
     * @param writer
     * @param dto
     */
    @Override
    @Transactional
    public void saveQna(Long writer, QnaSaveRequestDto dto) {
        Member findMember = memberRepository.findById(writer)
                .orElseThrow(MemberNotExistException::new);

        if (dto.getTitle().isEmpty() || dto.getContent().isEmpty()) {
            throw new NullTextFieldException();
        }

        Qna qna = Qna.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(findMember)
                .secret(dto.getSecret())
                .build();

        qnaRepository.save(qna);
        findMember.addQna(qna);
    }

    /**
     * Q&A 수정
     * @param writer
     * @param post_id
     * @param dto
     */
    @Override
    @Transactional
    public void updateQna(Long writer, Long post_id, QnaUpdateRequestDto dto) {
        LocalDateTime now = LocalDateTime.now();
        Qna qna = qnaRepository.findById(post_id)
                .orElseThrow(PostNotExistException::new);

        if (dto.getTitle().isEmpty() || dto.getContent().isEmpty()) {
            throw new NullTextFieldException();
        }

        String newTitle;
        String newContent;
        if (qna.getWriter().getId().equals(writer)) {
            if (dto.getTitle().equals(qna.getTitle())) {
                newTitle = qna.getTitle();
            } else {
                newTitle = dto.getTitle();
            }
            if (dto.getContent().equals(qna.getContent())) {
                newContent = qna.getContent();
            } else {
                newContent = dto.getContent();
            }
            qnaRepository.updateQna(newTitle, newContent, now);
        } else {
            throw new PostWriterNotMatchException();
        }
    }

    /**
     * Q&A 모두 반환
     * @param size
     * @param page
     * @return
     */
    @Override
    public List<ReturnQnaResponseDto> findAllQnas(int size, int page) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"));
        List<Qna> allQna = qnaRepository.findAllQna(pageable);
        List<ReturnQnaResponseDto> returnQna = new ArrayList<>();
        for (Qna qna : allQna) {
            returnQna.add(qna.toEntity());
        }

        return returnQna;
    }

}
