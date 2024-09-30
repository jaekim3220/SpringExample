package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson03.domain.Review;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface ReviewMapper {

	// input : None. BO(Service)한테 받아옴.
	// output : BO한테 돌려줌. Review 단건. 없으면 null.
	public Review selectReviewById(int id);
	
	
}
