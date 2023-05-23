package com.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findAll();

}
