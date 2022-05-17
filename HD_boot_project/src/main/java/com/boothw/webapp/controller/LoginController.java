package com.boothw.webapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boothw.webapp.security.dto.AuthMemberDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/loginaccess")
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class LoginController {

	@PreAuthorize("permitAll()")
   @GetMapping("/all")
   public void accessALL(){
       log.info("exAll.....");
   }//end ex..

	@PreAuthorize("hasRole('ROLE_USER')")
   @GetMapping("/member")
   public void accessMember(){
       log.info("exMember.....");
   }//end ex..

	@PreAuthorize("hasRole('ROLE_ADMIN')")
   @GetMapping("/admin")
   public void accessAdmin(){
       log.info("exAdmin.....");
   }//end ex..
   
   @GetMapping("/test")
   public void test(){
       log.info("test.....");
   }//end ex..
   
   @PreAuthorize("hasRole('ROLE_USER')")
   @GetMapping("/modify")
   public void exmodify(
           @AuthenticationPrincipal AuthMemberDTO clubAuthMemberDTO
   ){
       log.info("exModify.....");
       log.info("--------------");
       log.info(clubAuthMemberDTO);
   }//end ex..
   
	/*
	 * //user95@zerock.org 만 접근 가능
	 * 
	 * @PreAuthorize(" #AuthMemberDTO != null " +
	 * " && #AuthMemberDTO.memail eq \"user95@zerock.org\" ")
	 * 
	 * @GetMapping("/exOnly") public void exMemebrOnly(
	 * 
	 * @AuthenticationPrincipal AuthMemberDTO clubAuthMemberDTO){
	 * log.info("exMemberOnly-------"); log.info(clubAuthMemberDTO); }//end exM..
	 */
}//end class