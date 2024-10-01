package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBo;
import com.example.lesson03.domain.Review;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

@RequestMapping("/lesson03/ex02")
@RestController // 어노테이션 (Spring Bean 등록)
public class Lesson03Ex02RestController {

	/*3-2 : MyBatis(INSERT)*/
	
	@Autowired
	private ReviewBo reviewBo;
	
	// http:localhost:80/lesson03/ex02/1
	@RequestMapping("/1")
	public String ex02_1() {
		// INSERT 객체 생성
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삽겹혼밥세트");
		review.setUserName("바다");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 적당해요~");
		
		// 생성 객체 INSERT, 성공한 행의 갯수 return
		int rowCount = reviewBo.addReview(review);
		return "성공한 행의 갯수 : " + rowCount;
	}
	
	// http:localhost:80/lesson03/ex02/2
	@RequestMapping("/2")
	public String ex02_2() {
		// INSERT 객체 생성
		// storeId, menu, userName, point, review
		int rowCount = reviewBo.addReviewAsField(4, "콤비네이션R", "신보람", 5.0, "역시 맛있다!!!");
		return "성공한 행의 갯수 : " + rowCount;
		
	}
	
}
