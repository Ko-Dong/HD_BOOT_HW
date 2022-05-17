package com.boothw.webapp.exception;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
 
@Component
@ControllerAdvice
@Log4j2
/**
 * @author 고동현
 * Controller 관련 예외처리 구현
 *
 */
public class ControllerExceptionHandler {   
    @ExceptionHandler
    public void handleOtherException(Exception e,
            HttpServletResponse response) throws IOException {
        log.info("handleOtherException: "+e.getMessage());
        e.printStackTrace();
        //내부 서버 에러일 경우
        response.sendError(500);
    }
   
    @ExceptionHandler
    public void handleOtherException(BadCredentialsException e,
            HttpServletResponse response) throws IOException {
        log.info("BadCredentialsException : " +e.getMessage());
        //권한이 없을 경우
        response.sendError(401);
    }
}

