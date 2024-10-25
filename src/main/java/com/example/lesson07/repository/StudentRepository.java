package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// 순수 JPA vs Spring Data JPA
	// public StudentEntity save(StudentEntity studentEntity); - Create
	// public StudentEntity findById(int id); - Update
	// => public Optional<StudentEntity> findById(int id); - Update
	// public void delete(StudentEntity studentEntity); - Delete
	
	// 조회
	// public List<StudentEntity> findAll(); - Select(내장형)
	
	// ex02/select1 => JPQL 메소드 생성 (메소드 규칙을 활용)
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> name);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String keyword);
	public List<StudentEntity> findByNameStartingWith(String keyword);
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	
	// ex02/select2 => JPQL 메소드 생성 (쿼리문처럼 생겼지만 엔티티에 조회) - SQL 쿼리문이 아님

	// Entity 조회
//	@Query(value = "select s from StudentEntity as s where s.dreamJob = :dreamJob") // value에는 JPQL문이 들어감
//	public List<StudentEntity> findBydreamJob(@Param("dreamJob") String dreamJob);
	
	// SQL 쿼리문 - Native Query (DB의 종류에 맞게 해당 SQL 문으로 변환)
	@Query(value = "select * from `new_student` where dreamJob = :dreamJob", nativeQuery = true) // 변수가 아닌 @Param에 있는 값으로 조회
	public List<StudentEntity> findBydreamJob(@Param("dreamJob") String dreamJob);
	
}