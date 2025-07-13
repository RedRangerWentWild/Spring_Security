package com.Week5.Security.SpringSecurity;

import com.Week5.Security.SpringSecurity.Entity.User;
import com.Week5.Security.SpringSecurity.Service.JwtServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearningApplicationTests {
@Autowired
private JwtServiceImpl jwtService;
	@Test
	void contextLoads() {
		User user=new User(4L,"aadi01@gamil.com","1234");
		String token= jwtService.generateToken(user);
		System.out.println(token);
		Long id=jwtService.getUserIdFromToken(token);
		System.out.println(id);
	}

}
