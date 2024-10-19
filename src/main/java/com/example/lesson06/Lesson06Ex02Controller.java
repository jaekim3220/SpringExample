package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/lesson06/ex02")
public class Lesson06Ex02Controller {

	
	@Autowired
	private UserBO userBO;
	
	
	/*6-2 : AJAX로 아이디 중복확인*/
	
	// 회원가입 화면
	// http:localhost:80/lesson06/ex02/sign-up-view
	@GetMapping("/sign-up-view")
	public String signUpView() {
		return "lesson06/signUp";
	}
	
	
	// AJAX 요청
	@ResponseBody
	@GetMapping("/is-duplicated-name")
	public Map<String, Object> isDuplicatedName(
			@RequestParam("name") String name) {
		
		// DB SELECT
		boolean isDuplicated = userBO.isDuplicatedName(name);
		
		
		// 응답값 => Map => JSON String
		// {"code":200, "is_duplicated_name":true}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicated_name", isDuplicated);
		
		return result;
	}
	
	
}
