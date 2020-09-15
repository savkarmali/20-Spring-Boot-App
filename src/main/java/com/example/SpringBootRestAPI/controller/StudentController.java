package com.example.SpringBootRestAPI.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.SpringBootRestAPI.dao.StudentRepository;
import com.example.SpringBootRestAPI.exception.StudentNotFoundException;
import com.example.SpringBootRestAPI.model.Student;

import lombok.RequiredArgsConstructor;

@RestController
//@RequiredArgsConstructor
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> retriveAllStudents(){ 
		System.out.println("Success");
		return studentRepository.findAll();
	}
	@GetMapping("/students/{id}")
	public Student retriveStudent(@PathVariable Long id) throws StudentNotFoundException {
		
		Optional<Student> student=studentRepository.findById(id);
		
		if(!student.isPresent())
			throw new StudentNotFoundException("id-"+id);
		
		return student.get();
	}
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentRepository.deleteById(id);
	}
	/*
	 * @PostMapping("/students") public ResponseEntity<Object>
	 * createStudent(@RequestBody Student student){ Student savedStudent =
	 * studentRepository.save(student); URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	 * .buildAndExpand(((Object) savedStudent).getId()).toUri();
	 * 
	 * return ResponseEntity.created(location).build(); }
	 */
	
}
