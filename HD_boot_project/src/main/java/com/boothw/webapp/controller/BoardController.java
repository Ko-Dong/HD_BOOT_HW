
package com.boothw.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.boothw.webapp.dto.Board;
import com.boothw.webapp.dto.Pager;
import com.boothw.webapp.service.BoardService;
import lombok.extern.slf4j.Slf4j;
 
@RestController
@RequestMapping("/board")
@Slf4j
/**
 * @author 고동현
 * 게시판 관련 Rest Controller 구현
 *
 */
public class BoardController {
 
    @Autowired
    private BoardService boardService;
 
    @GetMapping("/getlist")
    public Map<String, Object> list(@RequestParam(name = ("pageNo"), defaultValue = "1") int pageNo) { // 첫 페이지 1
        log.info("게시판 전체글 페이지별로 조회");
        int totalRows = boardService.getTotalBoardNum(); // 전체 글 수
        
        Pager pager = new Pager(5, 5, totalRows, pageNo); // 한 페이지에 5개씩
       
        List<Board> list = boardService.getBoards(pager); // 해당 페이지 게시글 가져오기
   
        Map<String, Object> map = new HashMap<>(); // JSON
        map.put("boards", list); // boards 
        map.put("pager", pager);
        return map;
    }
 
    @GetMapping("/{bno}/{hit}")
    public Board read(@PathVariable int bno, @PathVariable boolean hit) { // 기본 조회수 false
        log.info("해당 게시글 조회");
        log.info("hit : " + hit);
        
        Board board = boardService.getBoard(bno, hit); // 해당 게시글 상세 보여주기
        return board;
    }
 
    @PostMapping("/create")
    public Board create(@RequestBody Board board) {
        log.info("글 작성");
        
        //파일 업로드시 동작
        if (board.getBattach() != null && !board.getBattach().isEmpty()) { // 파일 이름 설정
            MultipartFile mf = board.getBattach();
            board.setBattachoname(mf.getOriginalFilename());
            board.setBattachsname(new Date().getTime() + "-" + mf.getOriginalFilename());
            board.setBattachtype(mf.getContentType());
            try {
                File file = new File("D:/upload_files/" + board.getBattachsname());
                mf.transferTo(file);
            } catch (Exception e) {
                log.info("업로드 에러" + e);            
            }
        }
        
        boardService.writeBoard(board);
     
        board = boardService.getBoard(board.getBno(), false); //생성 후 조회
        
        return board;
    }
 
    
    @PostMapping("/update")
    public Board update(@RequestBody Board board) {
        log.info("글 수정");
        
        if (board.getBattach() != null && !board.getBattach().isEmpty()) { // 파일이름 만들기
            MultipartFile mf = board.getBattach();
            board.setBattachoname(mf.getOriginalFilename());
            board.setBattachsname(new Date().getTime() + "-" + mf.getOriginalFilename());
            board.setBattachtype(mf.getContentType());
            try {
                File file = new File("D:/upload_files/" + board.getBattachsname());
                mf.transferTo(file);
            } catch (Exception e) {
                log.info("업로드 에러" + e);    
            }
        }
        
        boardService.updateBoard(board);
       
        board = boardService.getBoard(board.getBno(), false); // 글 수정 후 조회
        
        return board;
    }
 
    @DeleteMapping("/{bno}")
    public Map<String, String> delete(@PathVariable int bno) {
        log.info("글 삭제");
        boardService.removeBoard(bno);
        
        Map<String, String> map = new HashMap<String, String>(); // JSON 데이터
        map.put("result", "success");
        return map;
    }
 
    @GetMapping("/battach/{bno}")
    public void download(@PathVariable int bno, HttpServletResponse response) {
        log.info("파일 다운로드");
        try {
            Board board = boardService.getBoard(bno, false);
            String battachoname = board.getBattachoname();
            if (battachoname == null) {
                return;
            } // 해당 게시글에 첨부된 파일이 있는지 확인
            
            battachoname = new String(battachoname.getBytes("UTF-8"), "ISO-8859-1"); // 한글 처리
            String battachsname = board.getBattachsname();
            String battachtype = board.getBattachtype();
            // 파일 이름, 타입 세팅
            // "Content-Disposition", "attachment; filename="a.jpg";
            response.setHeader("Content-Disposition", "attachment; filename=\"" + battachoname + "\";");
            response.setContentType(battachtype);
            InputStream is = new FileInputStream("D:/upload_files/" + battachsname);
            OutputStream os = response.getOutputStream();
            FileCopyUtils.copy(is, os);
            is.close();
            os.flush();
            os.close();
        } catch (Exception e) {
            log.info("다운로드 에러" + e);    
        }
    }
    
    @PostMapping("/create2")
    public Board create2( Board board) {
        log.info("create2 실행");
        //파일 업로드시 동작
        if (board.getBattach() != null && !board.getBattach().isEmpty()) {
            log.info("파일 업로드 시작");
            MultipartFile mf = board.getBattach();
            board.setBattachoname(mf.getOriginalFilename());
            board.setBattachsname(new Date().getTime() + "-" + mf.getOriginalFilename());
            board.setBattachtype(mf.getContentType());
            try {
                File file = new File("D:/upload_files/" + board.getBattachsname());
                mf.transferTo(file);
            } catch (Exception e) {
                log.info("업로드 에러" + e);            
            }//end try
        }//end if      
        boardService.writeBoard(board);
        //생성후 조회
        board = boardService.getBoard(board.getBno(), false);
        return board;
    }//end carete..

    @PostMapping("/update2")
    public Board update2( Board board) {
        log.info("update2 실행");
        //첨부파일 수정
        if (board.getBattach() != null && !board.getBattach().isEmpty()) {
            MultipartFile mf = board.getBattach();
            board.setBattachoname(mf.getOriginalFilename());
            board.setBattachsname(new Date().getTime() + "-" + mf.getOriginalFilename());
            board.setBattachtype(mf.getContentType());
            try {
                File file = new File("D:/upload_files/" + board.getBattachsname());
                mf.transferTo(file);
            } catch (Exception e) {
                log.info("업로드 에러" + e);    
            }//end ret
        }//end if      
        boardService.updateBoard(board);
        //변경 후 조회
        board = boardService.getBoard(board.getBno(), false);
        return board;
    }//end update

   
}

