package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBo;
import com.example.lesson07.entity.StudentEntity;

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

@RestController
@RequestMapping("/lesson07/ex01")
public class Lesson07Ex01RestController {

	// CRUD 구현

	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private StudentBo studentBO;
	
	
	// C : Create
	@GetMapping("/create")
	// localhost/lesson07/ex01/create
	public StudentEntity create() {
		String name = "김지은";
		String phoneNumber = "010-1111-3333";
		String email = "jek@naver.com";
		String dreamJob = "교수";
		
		// save된 객체를 return하므로 id가 채워져있음
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U : Update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 4인 dreamJob을 경찰로 변경
		return studentBO.updateStudentById(5, "경찰");
	}
	
}
