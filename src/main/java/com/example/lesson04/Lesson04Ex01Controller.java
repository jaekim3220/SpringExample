package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

@RequestMapping("/lesson04/ex01")
@Controller // HTML 경로일 경우 @ResponseBody가 없다
public class Lesson04Ex01Controller {

	
	/*lesson04 : MVC Cycle*/
	
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private UserBO userBo;
	
	// 1-1 : form 태그와 회원가입
	// 회원가입 화면
	// http:localhost:80/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // HTML 경로
	}
	
	// 회원가입 데이터를 DB에 INSERT => 결과 화면 이동
	@PostMapping("/add-user")
	public String addUser(
			// 필수 파라미터 불러오기1 : value, required 생략 (추천) - null이 아닌 column
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			
			// 비필수 파라미터 불러오기2 : 기본값 설정 (추천)
			@RequestParam(value = "introduce", required = false) String introduce
			) {
		
		// DB INSERT
		userBo.addtUser(name, yyyymmdd, email, introduce);
		
		// 결과 화면 이동
		return "lesson04/afterAddUser";
	}
	
	
	// 1-2 : 방금 가입한 학생의 id pk 가져오기
	// http:localhost:80/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) {
		
		// DB SELECT Service(BO)영역
		User user = userBo.getLatestUser();
		
		
		// MODEL 데이터 삽입
		// Controller가 Model에 데이터를 삽입
		// HTML(VIEW)가 Model에서 꺼내서 사용
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입한 유저");
		
		
		return "lesson04/latestUser"; // HTML(VIEW) 경로
	}
	
}
