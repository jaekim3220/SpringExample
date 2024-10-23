package com.example.lesson04.bo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service // Spring Bean 등록
public class StudentBo {
	
	@Autowired
	private StudentMapper studentmapper;
	
	@Autowired
	private StudentRepository studentRepository;

	// JPA
	public StudentEntity addStudent(
			String name, String phoneNumber,
			String email, String dreamjob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamjob(dreamjob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	
	// MyBatis
	// input : Student 데이터
	// output : int or void
	// 방금 가입한 학생의 id pk 가져오기 (고급) - 방금 가입한 학생
	public void addStudent(Student student) {
		// void로 진행할 경우 return 값이 주어지지 않아 변경한 행의 수가 return 되지 않음
		studentmapper.insertStudent(student);
	}
	
	
	// input : Student id 데이터
	// output : Student 데이터
	public Student getStudentById(int id) {
		return studentmapper.selectStudentById(id);
	}
	
}
