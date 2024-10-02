package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson04/ex01")
@Controller // HTML 경로일 경우 @ResponseBody가 없다
public class Lesson04Ex01Controller {

	
	/*MVC Cycle 1-1 : form 태그와 회원가입*/
	
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private UserBO userBo;
	
	// 회원가입 화면
	// http:localhost:80/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // HTML 경로
	}
	
	// 회원가입 데이터를 DB에 INSERT => 결과 화면 이동
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
		userBo.addtUser(name, yyyymmdd, email, introduce);
		
		// 결과 화면 이동
		return "lesson04/afterAddUser";
	}
	
}
