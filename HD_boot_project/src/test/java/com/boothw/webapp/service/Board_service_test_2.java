package com.boothw.webapp.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boothw.webapp.dto.Board;
import com.boothw.webapp.dto.Pager;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
/**
 * @author 고동현
 * 게시판 관련 service test 구현
 *
 */
public class Board_service_test_2 {
	
	@Autowired
    private BoardService boardService;
   
    @Test
    public void ServiceTest2() {
    
    	int totalRows = boardService.getTotalBoardNum();
    	Pager pager = new Pager(5, 5, totalRows, 1);
    	List<Board> list = boardService.getBoards(pager); // 해당 페이지 글 불러오기
    	list.forEach(i -> log.info(i));
    	
    	}
}
