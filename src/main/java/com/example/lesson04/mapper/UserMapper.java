package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.User;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface UserMapper {

	// input : 4개 파라미터
	// output : X
	// MVC Cycle 4-1 예제 : (form 태그와 회원가입)
	public void insertUser(
			// parameter를 두 개 이상 XML로 보낼 수 없다.
			// 때문에 하나의 Map으로 구성해야 하는데, @Param을 사용해 맵으로 생성이 가능.
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("email") String email, 
			@Param("introduce") String introduce);
	
	
	// input : X
	// output : User or Null
	// MVC Cycle 4-2 예제 : (방금 가입한 학생의 id pk 가져오기)
	public User selectLatestUser();
	
	
	// input : name
	// output : boolean t(0이 아닌 수):중복 f(0):중복 아님
	// 6-2 : AJAX로 아이디 중복확인
	public boolean isDuplicatedName(String name);
	
}
