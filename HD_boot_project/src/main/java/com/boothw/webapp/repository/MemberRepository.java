package com.boothw.webapp.repository;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boothw.webapp.dto.MemberAndMemberRoleJoin;
import com.boothw.webapp.dto.MemberDTO;
import com.boothw.webapp.dto.MemberRoleSetDTO;

@Mapper
public interface MemberRepository {
	public void insertMember(MemberDTO member);
	public void insertMemberRoleSet(MemberRoleSetDTO memberRoleSet);
	public MemberAndMemberRoleJoin findByMid(@Param("mid") String mid
			, @Param("menabled") int menabled) throws SQLException;
	public MemberAndMemberRoleJoin findByGmail(@Param("memail") String memail
			, @Param("menabled") int menabled) throws SQLException;
}
