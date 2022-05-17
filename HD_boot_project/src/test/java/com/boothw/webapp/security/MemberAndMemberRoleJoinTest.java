package com.boothw.webapp.security;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.boothw.webapp.dto.MemberAndMemberRoleJoin;
import com.boothw.webapp.repository.MemberRepository;

@SpringBootTest
public class MemberAndMemberRoleJoinTest {
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void findByMidTest() throws SQLException {
		MemberAndMemberRoleJoin tablejoin = memberRepository.findByMid("user1", 1);
		System.out.println(tablejoin);
	}
}