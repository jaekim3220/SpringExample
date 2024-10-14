package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBo;
import com.example.lesson04.domain.Student;

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
@RequestMapping("/lesson04/ex02")
@Controller // HTML 경로일 경우 @ResponseBody가 없다
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBo studentBo;
	
	
	/*lesson04 : MVC Cycle*/
	// 방금 가입한 학생의 id pk 가져오기 (고급) - 방금 가입한 학생
	
	// 회원가입 화면
	// http:localhost:80/lesson04/ex02/add-student-view
	@RequestMapping("/add-student-view")
	public String addStrudentView() {
		
		return "lesson04/addStudent"; // HTML(VIEW) 경로
	}
	
	
	// 학생 DB 추가 => 방금 가입한 학생 화면
	// 입력, 수신한 데이터를 DB에 INSERT => 결과 화면 이동
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student, // form 태그의 name과 field가 일치하면 세팅됨 (Domain에서 가져옴)
			Model model) {
		
		// DB에 삽입(INSERT)
		studentBo.addStudent(student); // 입력한 student 데이터 삽입
		
		
		// DB SELECT
//		int id = student.getId();
		Student lateststudent = studentBo.getStudentById(student.getId());
		
		
		// MODEL 데이터 삽입
		// Controller가 Model에 데이터를 삽입
		// HTML(VIEW)가 Model에서 꺼내서 사용
		model.addAttribute("student", lateststudent);		
		
		
		return "lesson04/afterAddStudent"; // VIEW(HTML) 경로
	}

	
}
