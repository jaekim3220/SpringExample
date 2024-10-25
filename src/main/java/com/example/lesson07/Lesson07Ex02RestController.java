package com.example.lesson07;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

/*
<Response 방법 - 서버 기준>
@Controller + return String => ViewResolver => HTML 파일 렌더링(Model) => HTML
@Controller + @ResponseBody return String => HTTPMessageConverter => HTML
@Controller + @ResponseBody return 객체(map, list) => HTTPMessageConverter => jackson => JSON
@RestController return map => JSON
*/

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {

	// CRUD 구현 - SELECT
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	// 이번만 BO 생략
	@GetMapping("/select1")
	// http://localhost/lesson07/ex02/select1
	public List<StudentEntity> select1() {
		// 1) 전체 조회
		// return studentRepository.findAll(); // 내장형
		
		// 2) id 기준 내림차순 전체 조회
		// return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개 행 조회
		// return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) `이름`이 '김재원'인 데이터 조회
		// return studentRepository.findByName("김재원");
		
		// 5) in문으로 일치하는 이름 값 모두 조회 ('김재현', '김재원') - in문
		// return studentRepository.findByNameIn(Arrays.asList("김재현", "김재원"));
		
		// 6) 여러 컬럼 값과 일치하는 데이터 조회 - AND 문
		// 이름 : 김재현, 장래희망 : 개발자
		// return studentRepository.findByNameAndDreamJob("김재현", "개발자");
		
		// 7) email에 "naver" 포함된 데이터 조회 - like문 %naver%
		// return studentRepository.findByEmailContains("naver");
		
		// 8) 이름이 "김"으로 시작하는 데이터 조회 - like문 김%
		// return studentRepository.findByNameStartingWith("김");
		
		// 9) id 번호 2 ~ 3 조회 : between
		return studentRepository.findByIdBetween(2, 3);
	}
	
	
	// 예제2)
	@GetMapping("/select2")
	// http://localhost/lesson07/ex02/select2
	public List<StudentEntity> select2() {
		// 장래희망이 특정 값인 행 조회
		return studentRepository.findBydreamJob("변호사");
	}
	
}
