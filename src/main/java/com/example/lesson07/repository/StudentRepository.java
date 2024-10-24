package com.example.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// 순수 JPA vs Spring Data JPA
	// public StudentEntity save(StudentEntity studentEntity); - Create
	// public StudentEntity findById(int id); - Update
	// => public Optional<StudentEntity> findById(int id); - Update
	// public void delete(StudentEntity studentEntity); - Delete
}