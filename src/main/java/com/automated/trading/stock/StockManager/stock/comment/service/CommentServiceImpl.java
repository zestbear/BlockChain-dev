package com.automated.trading.stock.StockManager.stock.comment.service;

import com.automated.trading.stock.StockManager.stock.comment.controller.dto.CommentSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.comment.controller.dto.ReturnCommentResponseDto;
import com.automated.trading.stock.StockManager.stock.comment.domain.Comment;
import com.automated.trading.stock.StockManager.stock.comment.domain.CommentRepository;
import com.automated.trading.stock.StockManager.stock.member.domain.Member;
import com.automated.trading.stock.StockManager.stock.member.domain.MemberRepository;
import com.automated.trading.stock.StockManager.stock.qna.domain.Qna;
import com.automated.trading.stock.StockManager.stock.qna.domain.QnaRepository;
import com.automated.trading.stock.StockManager.util.exception.CommentNotExistException;
import com.automated.trading.stock.StockManager.util.exception.MemberNotExistException;
import com.automated.trading.stock.StockManager.util.exception.PostNotExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final QnaRepository qnaRepository;

    public CommentServiceImpl(CommentRepository commentRepository, MemberRepository memberRepository, QnaRepository qnaRepository) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.qnaRepository = qnaRepository;
    }

    /**
     * 댓글 저장
     *
     * @param qna_id
     * @param member_id
     * @param dto
     */
    @Override
    @Transactional
    public void saveComment(Long qna_id, Long member_id, CommentSaveRequestDto dto) {
        Member member = memberRepository.findById(member_id)
                .orElseThrow(MemberNotExistException::new);
        Qna qna = qnaRepository.findById(qna_id)
                .orElseThrow(PostNotExistException::new);

        commentRepository.save(Comment.builder()
                .content(dto.getContent())
                .member(member)
                .qna(qna)
                .build());
    }

    /**
     * 댓글 모두 반환
     * @param qna_id
     * @return
     */
    @Override
    public List<ReturnCommentResponseDto> findAllComments(Long qna_id) {
        List<Comment> allComment = commentRepository.findAllComment(qna_id);
        List<ReturnCommentResponseDto> returnComment = new ArrayList<>();
        for (Comment comment : allComment) {
            returnComment.add(comment.toEntity());
        }

        return returnComment;
    }

    /**
     * 댓글에 추천 누르기 (좋아요 기능)
     * @param comment_id
     */
    @Override
    @Transactional
    public int addRecommends(Long comment_id) {
        Comment comment = commentRepository.findById(comment_id)
                .orElseThrow(CommentNotExistException::new);
        int added = comment.getRecommends() + 1;

        return commentRepository.addRecommend(comment_id, added);
    }
}
