package com.boothw.webapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.boothw.webapp.dto.Board;
import com.boothw.webapp.dto.Pager;

@Mapper
/**
 * @author 고동현
 * 게시판 관련 DAO 구현
 *
 */
public interface BoardDao {
	
	public List<Board> selectByPage(Pager pager); // 페이지별 조회
	public int count();
	public Board selectByBno(int bno); // 게시글 번호로 조회
	public ArrayList<Board> selectByWriter(String writer); // 작성자로 조회
	
	public int insert(Board board); // 게시글 작성
	public int deleteByBno(int bno); // 게시글 삭제
	public int update(Board board); // 게시글 수정
	public int updatehit(int bno); //조회수 변경
}
