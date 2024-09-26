package com.example.lesson01;

// 일반 JAVA Bean : Spring이 관여 안 함(데이터를 담는 공간)
public class Data {
	
	// 속성 : field
	private int id;
	private String name;
	

	// 기능 : 메서드
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
	
	
	// Constructor/setter
	
}
