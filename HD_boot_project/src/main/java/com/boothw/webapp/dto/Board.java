package com.boothw.webapp.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
/**
 * @author 고동현
 * 게시판 관련 DTO 구현
 *
 */
public class Board {
	private int bno; // 게시글 번호
	private String btitle; // 게시글 제목
	private String bcontent; // 게시글 내용
	private String mid; // 회원번호
	private Date bdate; // 작성일
	private int hit; // 조회수
	private MultipartFile battach; // 첨부파일
	private String battachoname; // 첨부파일 관련 변수
	private String battachsname;
	private String battachtype;
	private String writer; // 작성자
}
