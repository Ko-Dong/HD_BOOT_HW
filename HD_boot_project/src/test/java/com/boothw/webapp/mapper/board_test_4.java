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
public class board_test_4 {
	
	@Autowired
	private BoardDao boradDao;
	
	@Test
	public void ListTest() {
		int total = boradDao.count();
		log.info(total);
		boradDao.selectByWriter("고동현").forEach(i -> log.info(i)); 
		// 고동현이 쓴 게시글 있는지 테스트
	}
}
