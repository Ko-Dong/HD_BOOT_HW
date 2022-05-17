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
public class board_test_7 {
	
	
	@Autowired
	private BoardDao boradDao;
	
	@Test
	public void UpdateTest() {
		Board board = new Board();
		board.setBno(13);
		board.setBtitle("test update titel");
		board.setBcontent("test update content");
		board.setMid("user");
		board.setWriter("고동현");
		int test = boradDao.update(board);
		log.info(test); // 해당 게시글 수정 잘 되는지 테스트
	}
}
