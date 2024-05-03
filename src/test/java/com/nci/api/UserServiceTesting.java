package com.nci.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nci.api.model.UserModel;
import com.nci.api.service.UserService;

public class UserServiceTesting extends EmailSpringBootApplicationTests {

	@Autowired
	private UserService userService;
	@Test
	public void validateUserLogin() throws Exception {
		assertEquals(true,userService.checkLogin("anusha@gmail.com", "anusha")) ;
	}
	@Test
	public void validateFakeUserLogin() throws Exception {
		
		assertEquals(false,userService.checkLogin("anusha@gmail.com", "anusha1")) ;
	}
	
	@Test
	public void validatePassword() throws Exception{
		assertEquals(true, userService.validatePassword(1,"anusha"));
	}

	@Test
	public void validateFakePassword() throws Exception{
		assertEquals(false, userService.validatePassword(1,"wrongpassword"));
	}

	@Test
	public void getUser() throws Exception{
		String email="anusha@gmail.com";
		
		UserModel dbuser=userService.getUserByEmail(email);
		assertEquals(true, dbuser!=null);
		
		
	}
	
	@Test
	public void getFakeUser() throws Exception{
		
		String fakeEmail="123@gmail.com";
		
		UserModel dbuser=userService.getUserByEmail(fakeEmail);
		assertEquals(true, dbuser==null);
		
	}
	
}