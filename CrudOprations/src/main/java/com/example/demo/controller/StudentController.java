package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	StudentService studentService;

//	public StudentController(StudentService studentService) {
//		super();
//		this.studentService = studentService;
//	}
	@GetMapping(value="/students")
	public List<Student> getAll(){
		return studentService.findAllStudents(); 
	}
	@GetMapping(value="/students/{id}")
	public Student getById(@PathVariable Long id){
		return studentService.findStudentById(id);
	}
	@PostMapping(value="/students")
	public Student add(Student student) {
		return studentService.addStudent(student);
	}
	@PutMapping(value="/students/{id}", consumes="application/json")
	public Student update(@PathVariable Long id,@RequestBody Student student) {
		return studentService.updateStudentInfo(id, student);
	}
	@DeleteMapping(value="/students/{id}")
	public String delete(@PathVariable Long id) {
		return studentService.deleteStudentInfo(id);
	}
}
