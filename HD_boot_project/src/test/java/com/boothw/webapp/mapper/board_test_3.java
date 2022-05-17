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
public class board_test_3 {

	@Autowired
	private BoardDao boradDao;
	
	@Test
	public void ListTest() {
		Board board = boradDao.selectByBno(2); // 2번 글 불러와지는지 테스트
		log.info(board);
		
	}
}
