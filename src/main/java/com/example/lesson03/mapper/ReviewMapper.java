package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface ReviewMapper {

	// input : int(id). BO(Service)한테 받아옴.
	// output : BO한테 돌려줌. Review 단건. 없으면 null.
	// MyBatis 3-1 예제 : (SELECT)
	public Review selectReviewById(int id);
	
	
	// input : Review(테이블)
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// MyBatis 3-2 예제2 : 객체화(INSERT)
	public int insertReview(Review review);
	
	// input : Parameter들
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// MyBatis 3-2 예제2 : (INSERT)
	public int insertReviewAsField(
			// parameter를 두 개 이상 XML로 보낼 수 없다.
			// 때문에 하나의 Map으로 구성해야 하는데, @Param을 사용해 맵으로 생성이 가능.
			@Param("storeId") int storeId, 
			@Param("menu") String menu,
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	
	// input : id, review
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// MyBatis 3-3 예제 : UPDATE
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
	
	
	// input : id
	// output : int(수정된 행의 갯수) => Mybatis가 성공된 행의 갯수를 제공
	// MyBatis 3-4 예제 : DELETE
	public int deleteReviewById(int id);
	
}
