package com.ty.shopping.controller;

import com.ty.shopping.dao.UserDao;
import com.ty.shopping.dto.User;

public class TestUserInsert {
	
	public static void main(String[] args) {
		User user = new User();
//		user.setId(5);
//		user.setName("anil");
//		user.setEmail("anil@gmail.com");
//		user.setPassword("hij1");
//		user.setMobile(2233441155l);
//		
		UserDao userDao = new UserDao();
//		int res=userDao.saveUser(user);
//		if(res > 0) {
//			System.out.println("Data inserted");
//		}
//		else
//			System.out.println("No data inserted");
		
		userDao.deletUser(3);
	}
}
