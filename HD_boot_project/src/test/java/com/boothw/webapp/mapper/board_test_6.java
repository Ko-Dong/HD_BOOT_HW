package com.boothw.webapp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boothw.webapp.dao.BoardDao;
import com.boothw.webapp.dto.Board;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
/**
 * @author 고동현
 * 게시판 관련 mapper test 구현
 *
 */
public class board_test_6 {
	
	@Autowired
	private BoardDao boradDao;
	
	@Test
	public void InsertTest() {
		Board board = new Board();
		board.setBtitle("test titel");
		board.setBcontent("test content");
		board.setMid("user");
		board.setWriter("고동현");
		boradDao.insert(board);
		int total = boradDao.count();
		log.info(total); // 값 잘 넣어지는지 테스트 후 게시글 수로 확인
	}

}
