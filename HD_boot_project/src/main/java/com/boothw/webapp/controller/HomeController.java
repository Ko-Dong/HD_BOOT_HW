package com.boothw.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boothw.webapp.dto.Board;
import com.boothw.webapp.dto.Pager;
import com.boothw.webapp.service.BoardService;

import lombok.extern.slf4j.Slf4j;
 
@Controller
@Slf4j
/**
 * @author 고동현
 * 페이지 이동하기 위한 Controller 구현
 *
 */
public class HomeController {
	
	@Autowired
	BoardService boardService;
	
    @RequestMapping("/") // 홈 화면
    public String home() {
        log.info("home 실행");
        return "home";
    }
    
    //@PreAuthorize("permitAll()")
    @RequestMapping("/board/list") // 게시글 띄우기
    public String boardlist(@RequestParam(defaultValue = "1") int pageNo, Model model) {
    	log.info("list 페이지로 이동");
    	int totalRows = boardService.getTotalBoardNum();
    	
    	Pager pager = new Pager(5, 5, totalRows, pageNo); // 한 페이지에 5개씩
    	
    	model.addAttribute("pager", pager); // 페이징 처리 위한 pager 전달
    	model.addAttribute("pageNo", pageNo); // 현재 페이지 번호 전달
    	 
    	return "list";
    }
    
    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/board/detail") // 글 상세페이지
    public String boarddetail(Model model, @RequestParam int bno, @RequestParam("hit") boolean hit) {
    	log.info("detail 페이지로 이동");
    	model.addAttribute("bno", bno);
    	model.addAttribute("hit", hit);
    	return "detail";
    }
    
    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/board/updatepage") // 게시글 수정 페이지
    public String boardupdate(Model model, @RequestParam int bno) {
    	log.info("update 페이지로 이동");
    	model.addAttribute("bno", bno);
    	return "update";
    }
    
    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/board/insert") // 게시글 작성 페이지
    public String boardinsert() {
    	log.info("insert 페이지로 이동");
    	return "insert";
    }
}

