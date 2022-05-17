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
public class Board_service_test_1 {
	
	@Autowired
    private BoardService boardService;
   
    @Test
    public void ServiceTest1() {       
    Board board=boardService.getBoard(2, true); // 조회수 테스트 포함
    log.info(board);
    }

}
