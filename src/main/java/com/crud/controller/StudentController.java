package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dao.StudentRepository;
import com.crud.model.Student;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repo;
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){

		return repo.findAll();
	}


	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {

		return repo.save(student);
	}

	@PutMapping(path="/student")
	public Student saveOrUpdateStudent(@RequestBody Student student)
	{
		repo.save(student);
		return student;
	}



	@GetMapping("/student/{id}")
	public Optional<Student> getPatient(@PathVariable("id")int id)
	{
		return repo.findById(id);


	} 

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		Student a = repo.getOne(id);
		repo.delete(a);
		return "deleted";
	}
}
