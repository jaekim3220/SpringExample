package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBo;
import com.example.lesson02.domain.UsedGoods;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// View영역

@RestController
public class Lesson02Ex01RestController {

	/*2-1 : DB 연동과 스프링 동작 흐름*/
	
	// 어노테이션(Annotation)
	@Autowired // DI(Dependency Injection) : 의존성 주입
	private UsedGoodsBo usedGoodsBo;
	
	// 요청 URL : http://localhost:80/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		List<UsedGoods> usedGoodsList = usedGoodsBo.getUsedGoodsList();
		
		return usedGoodsList; // JSON String response
	}
	
}
