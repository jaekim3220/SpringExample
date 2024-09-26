package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson02Ex01RestController {

	// 요청 URL : http://localhost:80/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		return "";
	}
	
	
}
