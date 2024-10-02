package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBo;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

@RestController // 어노테이션 (Spring Bean 등록)
public class Lesson03Ex04RestController {

	/*3-4 : MyBatis(DELETE)*/
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private ReviewBo reviewBo;
	
	// http:localhost:80/lesson03/ex04?id=23
	@RequestMapping("/lesson03/ex04")
	public String ex04(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천)
			@RequestParam("id") int id) {
		
		// void로 진행할 경우 return 값이 주어지지 않아 변경한 행의 수가 return 되지 않음
		reviewBo.deleteReviewById(id);
		return "삭제 성공";
	}
	
}
