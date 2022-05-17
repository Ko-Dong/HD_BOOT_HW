package com.boothw.webapp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boothw.webapp.dao.BoardDao;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
/**
 * @author 고동현
 * 게시판 관련 mapper test 구현
 *
 */
public class board_test_9 {
	
	@Autowired
	private BoardDao boradDao;
	
	@Test
	public void UpdateHitTest() {
		
		int test = boradDao.deleteByBno(13);
		log.info(test); // 해당 게시글 삭제되는지 테스트
	}
}
