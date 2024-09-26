package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody
// @Controller : Spring Bean 등록, @ResponseBody : return되는 값을 저장
public class Lesson01Ex01RestController {
	
	
	/*1-1 : HttpMessageConverter와 Annotation (RestController)*/

	// http:localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "<h3>@RestController(@Controller + @ResponseBody)를 사용해서 String 리턴</h3>";
	}
	
	
	// http:localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, Object> ex01_4() {
		Map<String, Object> map = new HashMap<>();
		map.put("aaa", "ZZZ");
		map.put("BBB", "ZZZ");
		map.put("CCC", "QQQ");
		return map;
	}
	
	
	// http:localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() { // 클래스 생성
		Data data = new Data(); // java bean
		data.setId(1);
		data.setName("김재현");
		
		return data; // Object를 Json String으로 응답
	}
	
	
	// http:localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	// ResponseEntity를 사용해 `Status Code`를 변경할 수 있음
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(3);
		data.setName("바다");
		
		return new ResponseEntity<>(data, HttpStatus.CREATED);
	}
	
	
}
