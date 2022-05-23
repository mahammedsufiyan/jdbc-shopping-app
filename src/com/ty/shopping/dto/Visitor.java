package com.ty.shopping.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Visitor {
	
	private int id;
	private String name;
	private long phone;
	private int age;
	private String gender;
	private LocalDate dob;
	private LocalDateTime visitedTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void LocalDate(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDateTime getVisitedTime() {
		return visitedTime;
	}
	public void setVisitedTime(LocalDateTime visitedTime) {
		this.visitedTime = visitedTime;
	}
	
	
	
}
