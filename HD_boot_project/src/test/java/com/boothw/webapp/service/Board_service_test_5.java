package com.boothw.webapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boothw.webapp.dto.Board;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
/**
 * @author 고동현
 * 게시판 관련 service test 구현
 *
 */
public class Board_service_test_5 {
	
	@Autowired
    private BoardService boardService;
   
    @Test
    public void ServiceTest5() {
    	
    	Board board = new Board();
		board.setBno(14);
		board.setBtitle("test update titel");
		board.setBcontent("test update content");
		board.setMid("user");
		board.setWriter("고동현");
  
    	boardService.updateBoard(board);
    	int totalRows = boardService.getTotalBoardNum();
    	log.info(totalRows); // 해당 게시글 업데이트 되는지 테스트
    	}
}
