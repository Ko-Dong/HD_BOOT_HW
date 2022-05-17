package com.boothw.webapp.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.boothw.webapp.dto.MemberDTO;
import com.boothw.webapp.dto.MemberRole;
import com.boothw.webapp.dto.MemberRoleSetDTO;
import com.boothw.webapp.repository.MemberRepository;
import java.sql.SQLException;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRoleSetTest {
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void insertMemberRoleSetTest() throws SQLException {
		for (int i = 1; i <= 101; i++) {
			MemberRoleSetDTO memberRole = new MemberRoleSetDTO();
			memberRole.setMid("user" + i);
			
			if (i < 33) {
				memberRole.setRole_set(MemberRole.USER.toString());
			}
			else if (i < 66) {
				memberRole.setRole_set(MemberRole.MANAGER.toString());
			}
			else {
				memberRole.setRole_set(MemberRole.ADMIN.toString());
			}
			
			memberRepository.insertMemberRoleSet(memberRole);
		}
	}
}
