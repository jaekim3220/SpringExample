package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

/*
DB연동 : View영역 <--> Controller영역(Domain) <--> Service(BO)영역 <--> Repository영역(Mapper) <--> DB영역 
*/

// Repository영역

@Mapper // mybatis 라이브러리
public interface UsedGoodsMapper {

	// input : None BO(Service)한테 받아옴.
	// output : BO한테 돌려줌. List<store> selectusedGoodsList
	public List<UsedGoods> selectusedGoodsList();
	
}
