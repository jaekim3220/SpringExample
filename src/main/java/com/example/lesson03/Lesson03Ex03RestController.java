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
public class Lesson03Ex03RestController {

	/*3-3 : MyBatis(UPDATE)*/
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private ReviewBo reviewBo;
	
	// http:localhost:80/lesson03/ex03?id=23&review=도미노 피자는 역시 맛있다!!!
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천)
			@RequestParam("id") int id,
			@RequestParam("review") String review
			) {
		int rowCount = reviewBo.updateReviewByID(id, review);
		return "변경 완료 : " + rowCount;
	}
	
}
