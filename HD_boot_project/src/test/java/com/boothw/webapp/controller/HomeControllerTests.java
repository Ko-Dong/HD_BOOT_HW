package com.boothw.webapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;


@SpringBootTest
@AutoConfigureMockMvc
@Log4j2
/**
 * @author 고동현
 * 게시판 관련 Controller test 구현
 *
 */
public class HomeControllerTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void test01_home() throws Exception{ // home 페이지로 이동 테스트
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getModelAndView().getViewName()
				
	);
				
	}
	
	@Test
	public void test02_list() throws Exception{ // 게시글 불러오기 테스트
		ModelAndView mnv = mockMvc.perform(get("/board/list")
				.param("bno", "18"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getModelAndView();
		
		log.info(mnv.getViewName()); // 어느 페이지로 갈건지 출력
		log.info(mnv.getModel()); // 모델에 담긴 값 출력
		
	}
	
	@Test
	public void test03_detail() throws Exception{ // 글 상세보기 테스트
		ModelAndView mnv = mockMvc.perform(get("/board/detail")
				.param("bno", "18")
				.param("hit", "true"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getModelAndView();
		
		log.info(mnv.getViewName());// 어느 페이지로 갈건지 출력
		log.info(mnv.getModel());// 모델에 담긴 값 출력
		
	}
	
	@Test
	public void test04_update() throws Exception{ // 글 수정 페이지 테스트
		ModelAndView mnv = mockMvc.perform(get("/board/updatepage")
				.param("bno", "18"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getModelAndView();
		
		log.info(mnv.getViewName());// 어느 페이지로 갈건지 출력
		log.info(mnv.getModel());// 모델에 담긴 값 출력
		
	}
	
	@Test
	public void test05_insert() throws Exception{ // 글 작성 페이지 테스트
		log.info(
				mockMvc.perform(get("/board/insert"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getModelAndView().getViewName()// 어느 페이지로 갈건지 출력
				
	);
		
	}
}
