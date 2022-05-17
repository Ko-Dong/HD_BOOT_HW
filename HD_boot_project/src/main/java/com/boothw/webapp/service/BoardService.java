package com.boothw.webapp.service;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boothw.webapp.dao.BoardDao;
import com.boothw.webapp.dto.Board;
import com.boothw.webapp.dto.Pager;
import lombok.extern.slf4j.Slf4j;
 
@Service
@Slf4j
/**
 * @author 고동현
 * 게시판 관련 Service 구현
 *
 */
public class BoardService {
   
    @Autowired
    private BoardDao boardDao;
   
    public List<Board> getBoards(Pager pager) {
        log.info("해당 페이지 게시글들 받아오기");
        return boardDao.selectByPage(pager); // 해당 페이지 게시글 받아오기
    }
   
    public Board getBoard(int bno, boolean hit) {
        log.info("해당 게시글 가져오기");
        if(hit) {
            boardDao.updatehit(bno); // 조회수 1 증가
        }
        return boardDao.selectByBno(bno);
    }
    
    public List<Board> getBoard_by_writer(String writer) {
        log.info("해당 작성자 기준으로 조회");
        return boardDao.selectByWriter(writer); // 해당 작성자가 쓴 게시글 받아오기
    }
   
    public int getTotalBoardNum() {
        log.info("총 게시글 수 가져오기"); // 페이징 위함
        return boardDao.count();
    }
   
    public void writeBoard(Board board) {
        log.info("글 작성");
        boardDao.insert(board); // 글 작성
    }
   
    public void updateBoard(Board board) {
        log.info("글 수정");
        boardDao.update(board); // 글 수정
    }
   
    public void removeBoard(int bno) {
        log.info("글 삭제");
        boardDao.deleteByBno(bno); // 글 삭제
    }
}

