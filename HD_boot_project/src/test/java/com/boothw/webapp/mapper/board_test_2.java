package com.boothw.webapp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boothw.webapp.dao.BoardDao;
import com.boothw.webapp.dto.Pager;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
/**
 * @author 고동현
 * 게시판 관련 mapper test 구현
 *
 */
public class board_test_2 {
	
	
	@Autowired
	private BoardDao boradDao;
	
	@Test
	public void ListTest() {
		int total = boradDao.count();
		log.info(total);
		Pager pager = new Pager(5, 5, total, 1);
		boradDao.selectByPage(pager).forEach(i -> log.info(i)); 
		// 해당 페이지 게시글 불러와지는지 테스트
		
	}
}
