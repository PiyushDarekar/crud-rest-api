package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	StudentRepo studentRepo;

//	public StudentService(StudentRepo studentRepo) {
//		this.studentRepo = studentRepo;
//	}
	
	public List<Student> findAllStudents(){
		return studentRepo.findAll();
	}
	public Student findStudentById(Long id) {
		return studentRepo.findById(id).get();
	}
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	public Student updateStudentInfo(Long id,Student student) {
		Optional<Student> stud=studentRepo.findById(id);
		if(stud.isPresent()) {
			return studentRepo.save(stud.get());
		}
		throw new RuntimeException();
	}
	public String deleteStudentInfo(Long id) {
		studentRepo.deleteById(id);
		return "Student's info deleted successfully";
	}
}
