package com.boothw.webapp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
public class Board_service_test_4 {
	
	@Autowired
    private BoardService boardService;
   
    @Test
    public void ServiceTest4() {
    	
    	Board board = new Board();
		board.setBtitle("test titel");
		board.setBcontent("test content");
		board.setMid("user");
		board.setWriter("고동현");
  
    	boardService.writeBoard(board);
    	int totalRows = boardService.getTotalBoardNum();
    	log.info(totalRows); // 게시글 작성 후 개수 늘어났는지 테스트
    	}
}
