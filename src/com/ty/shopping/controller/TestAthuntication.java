package com.ty.shopping.controller;

import com.ty.shopping.dao.UserDao;
import com.ty.shopping.dto.User;

public class TestAthuntication {
	
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user=userDao.validationUser("anjum@gmail.com", "xyz");
		if (user != null) {
			System.out.println("Details of user");
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getMobile());
		}
		else
			System.out.println("Wrong email or password");
		
	}
}
