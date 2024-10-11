package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Student;
import com.example.lesson04.domain.User;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface StudentMapper {

	// input : Student 데이터
	// output : int or void
	// 방금 가입한 학생의 id pk 가져오기 (고급) - 방금 가입한 학생
	public void insertStudent(Student student);
	
	// input : Student 데이터
	// output : int or void
	public Student selectStudentById(int id);
	
	
}
