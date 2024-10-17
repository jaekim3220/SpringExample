package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

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

@Controller
@RequestMapping("/lesson06/ex01")
public class Lesson06Ex01Controller {

	/*6-1 : AJAX 통신으로 서버 요청*/
	
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private UserBO userBO;
	
	// 회원가입 화면
	// localhost/lesson06/ex01/add-user-view
	@GetMapping("/add-user-view")
	public String addUserView() {
		
		return "lesson06/addUser1";
	}
	
	
	// 회원가입 진행 => AJAX 요청
	@ResponseBody
	@PostMapping("/add-user")
	public String addUser(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천) - null이 아닌 column
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			
			// 비필수 파라미터 불러오기2 : 기본값 설정 (추천)
			@RequestParam(value = "introduce", required = false) String introduce
			) {
		
		
		// DB INSERT
		userBO.addtUser(name, yyyymmdd, email, introduce);
		
		
		// 응답값 => String
		return "성공";
	}
	
	
	// 가입 완료 화면
	// localhost/lesson06/ex01/after-add-user-view
	@GetMapping("/after-add-user-view")
	public String afterAddUserView() {
		return "lesson06/afterAddUser1";
	}
	
}
