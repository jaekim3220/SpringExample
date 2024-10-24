package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

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

	
	// MyBatis
	// input : Student 데이터
	// output : int or void
	// 방금 가입한 학생의 id pk 가져오기 (고급) - 방금 가입한 학생
	public void addStudent(Student student) {
		// void로 진행할 경우 return 값이 주어지지 않아 변경한 행의 수가 return 되지 않음
		studentmapper.insertStudent(student);
	}
	
	
	// MyBatis
	// input : Student id 데이터
	// output : Student 데이터
	public Student getStudentById(int id) {
		return studentmapper.selectStudentById(id);
	}
	
	
	/*JPA*/
	
	@Autowired
	private StudentRepository studentRepository;

	// JPA - Create
	public StudentEntity addStudent(
			String name, String phoneNumber,
			String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	
	// JPA - UPDATE
	public StudentEntity updateStudentDreamById(
			int id, String dreamJob) {
		// 기존 데이터 조회 - id로 entity 조회
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// update - JPA는 save 메서드를 사용(INSERT, UPDATE)
		// 조회된 데이터가 존재할 때 업데이트 진행
		if (student != null) {
			
			// 변경할 내용을 엔티티에 설정 후 save(id가 존재) update
			student = student.toBuilder()
			.dreamJob(dreamJob)
			.build();
			
			student = studentRepository.save(student); // 설정 후 다시 변수에 담으면 URL을 사용해 updated 정보도 조회 가능
		}
		
		return student;
	}
	
	
	// JPA - DELETE
	public void deleteStudentById(int id) {
		// 방법1) 삭제할 대상 select => 삭제
		/*
		StudentEntity student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			studentRepository.delete(student);
		}
		*/
		
		// 방법2) 삭제할 대상 select => 삭제
		Optional<StudentEntity> studentOptional =  studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
	
}
