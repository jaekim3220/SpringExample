package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Service(BO)영역

@Service // Spring Bean 등록
public class UserBO {
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private UserMapper userMapper;
	
	
	// input : 4개 파라미터
	// output : X
	// MVC Cycle 4-1 예제 : (form 태그와 회원가입)
	public void addtUser(String name, String yyyymmdd, 
			String email, String introduce) {
		// void로 진행할 경우 return 값이 주어지지 않아 변경한 행의 수가 return 되지 않음
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	
	// input : X
	// output : User or Null
	// MVC Cycle 4-2 예제 : (방금 가입한 학생의 id pk 가져오기)
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
}
