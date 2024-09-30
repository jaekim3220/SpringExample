package com.example.lesson03.bo;

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
	
	// input : None. 컨트롤러(Domain)한테 받는다
	// output : 컨트롤러한테 제공. Review 단건. 없으면 null.
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);
	}
	
	
}
