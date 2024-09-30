package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBo;
import com.example.lesson03.domain.Review;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

@RestController // 어노테이션 (Spring Bean 등록)
public class Lesson03Ex01RestController {

	/*3-1 : MyBatis(SELECT)*/
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private ReviewBo reviewBo;
	
	// http:localhost:80/lesson03/ex01?id=13
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천)
			// @RequestParam("id") int id
			
			// 필수 파라미터 불러오기2
			// @RequestParam(value = "id", required = true) int id
			
			// 필수 파라미터 불러오기3
			// @RequestParam(value = "id") int id
			
			// 비필수 파라미터 불러오기1
			// @RequestParam(value = "id", required = false) Integer id
			
			// 비필수 파라미터 불러오기2 : 기본값 설정 (추천)
			 @RequestParam(value = "id", defaultValue = "1") int id // 기본값 : 1
			) {
		// 비필수 파라미터 불러오기1
//		if (id == null) {
//			id = 1;
//		}
		return reviewBo.getReviewById(id); // response, html view 경로
	}
	
	
}
