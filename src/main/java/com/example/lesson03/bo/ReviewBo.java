package com.example.lesson03.bo;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service // Spring Bean 등록
public class ReviewBo {
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private ReviewMapper reviewMapper;
	
	// input : int(id). 컨트롤러(Domain)한테 받는다
	// output : 컨트롤러한테 제공. Review 단건. 없으면 null.
	// MyBatis 예제 1-1(SELECT)
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);
	}
	
	
	// input : Review
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// MyBatis 1-2 예제1 : 객체화(INSERT)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// input : Parameter들
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// MyBatis 1-2 예제2
	public int addReviewAsField(int storeId, String menu,
			String userName, Double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	
	// input : id, review
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// MyBatis 3-3 예제
	public int updateReviewByID(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
	
	
	// input : id
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// MyBatis 3-4 예제 : DELETE
	public void deleteReviewById(int id) {
		// void로 메서드를 생성할 경우 return 값이 주어지지 않음
		reviewMapper.deleteReviewById(id);
	}
}
