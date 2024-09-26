package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 이동
@Controller // spring bean 등록, HTML로 보낼 때는 @ResponseBody가 절대 있으면 안됨!
public class Lesson01Ex02Controller {

	// 요청 URL : http://localhost:80/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // request
	public String ex02() {
		// return되는 String은 HTML의 `경로`.
		// @ResponseBody가 없어야 한다.
		
		// /template/	lesson01/ex02.html
		return "lesson01/ex02"; // response, html view 경로
	}
	
}
