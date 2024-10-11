package com.example.lesson04.domain;

import java.time.LocalDateTime;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Controller영역(Domain)

// 일반 JAVA BEAN
// DTO(Data Transfer Object), Domain, Model, Entity(결과)
public class Student {

	
	// 속성 : field (`new_student` 테이블)
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String dreamjob;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDreamjob() {
		return dreamjob;
	}
	public void setDreamjob(String dreamjob) {
		this.dreamjob = dreamjob;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
