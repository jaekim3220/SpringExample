package com.example.lesson04.domain;

import java.time.LocalDateTime;

import lombok.Data;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Controller영역(Domain)

// 일반 JAVA BEAN
// DTO(Data Transfer Object), Domain, Model, Entity(결과)

@Data
public class User {
	
	
	// 속성 : field (`new_review` 테이블)
	private int id;
	private String name;
	private String yyyymmdd;
	private String email;
	private String introduce;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;


	
}
