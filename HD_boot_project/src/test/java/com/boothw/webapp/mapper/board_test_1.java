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
public class board_test_1 {
	
	@Autowired
	private BoardDao boradDao;
	
	@Test
	public void ListTest() {
		int total = boradDao.count(); // 총 갯수 불러오기
		log.info(total);
	}
}
