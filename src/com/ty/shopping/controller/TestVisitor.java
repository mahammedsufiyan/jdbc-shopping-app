package com.ty.shopping.controller;

import com.ty.shopping.dao.VisitorDao;
import com.ty.shopping.dto.Visitor;

public class TestVisitor {
	
	public static void main(String[] args) {
		Visitor visit = new Visitor();
		visit.setId(1);
		visit.setName("anu");
		visit.setPhone(12345);
		visit.setGender("male");
		visit.setDob("01-01-2000");
		visit.setVisitedTime("1:30");
		 
		VisitorDao dao = new VisitorDao();
		int res = dao.saveVisitor(visit);
		if(res>0)
			System.out.println("data added");
		else
			System.out.println("no data added");
		
	}
}
