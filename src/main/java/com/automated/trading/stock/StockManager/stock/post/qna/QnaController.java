package com.automated.trading.stock.StockManager.stock.post.qna;

import com.automated.trading.stock.StockManager.stock.post.qna.dto.QnaDeleteRequestDto;
import com.automated.trading.stock.StockManager.stock.post.qna.dto.ReturnQnaResponseDto;
import com.automated.trading.stock.StockManager.stock.post.qna.dto.QnaSaveRequestDto;
import com.automated.trading.stock.StockManager.stock.post.qna.dto.QnaUpdateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QnaController {

    private final QnaService qnaService;

    public QnaController(QnaService qnaService) {
        this.qnaService = qnaService;
    }

    /*
        Q&A 저장 Controller

        성공: Qna saved successfully
     */
    @PostMapping("/qna/save/{member_id}")
    public ResponseEntity<String> saveQna(@PathVariable("member_id") int member_id,
                                             @RequestBody QnaSaveRequestDto dto) {
        dto.setMember_id(member_id);

        try {
            qnaService.saveQna(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save qna: " + e.getMessage());
        }
        return ResponseEntity.ok("Qna saved successfully");
    }

    /*
        Q&A 수정 Controller

        성공: Qna updated successfully
     */
    @PutMapping("/qna/update/{member_id}/{post_fk}")
    public ResponseEntity<String> updateQna(@PathVariable("member_id") int member_id,
                                               @PathVariable("post_fk") int post_fk,
                                               @RequestBody QnaUpdateRequestDto dto) {
        dto.setMember_id(member_id);
        dto.setPost_fk(post_fk);

        try {
            qnaService.updateQna(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update qna: " + e.getMessage());
        }
        return ResponseEntity.ok("Qna updated successfully");
    }

    /*
        Q&A 삭제 Controller

        성공: Qna deleted successfully
     */
    @DeleteMapping("/qna/delete/{member_id}/{post_fk}")
    public ResponseEntity<String> deleteQna(@PathVariable("member_id") int member_id,
                                            @PathVariable("post_fk") int post_fk) {
        QnaDeleteRequestDto dto = new QnaDeleteRequestDto();
        dto.setMember_id(member_id);
        dto.setPost_fk(post_fk);

        try {
            qnaService.deleteQna(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete qna: " + e.getMessage());
        }
        return ResponseEntity.ok("Qna deleted successfully");
    }

    /*
        Q&A 모두 반환 Controller
     */
    @GetMapping("/qna")
    public List<ReturnQnaResponseDto> findAllQnas() {
        return qnaService.findAllQnas();
    }

    /*
        Q&A 선택 반환 Controller
     */
    @GetMapping("/qna/{qna_id}")
    public ReturnQnaResponseDto findById(@PathVariable("qna_id") int qna_id) {
        return qnaService.findById(qna_id);
    }

}
