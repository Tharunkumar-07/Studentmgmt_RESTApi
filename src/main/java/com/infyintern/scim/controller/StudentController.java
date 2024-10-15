package com.infyintern.scim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.infyintern.scim.entity.Student;
import com.infyintern.scim.repository.StudentRepository;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentRepository repo;
    @GetMapping
	public List<Student> getAllStudents(){
		List<Student> students=repo.findAll();
		return students;
	}
	@GetMapping("/{id}")
    public Student getStudentbyid(@PathVariable int id) {
		Student student=repo.findById(id).get();
    	return student;
    	
    }
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createstudent(@RequestBody Student student) {
		repo.save(student);
		
	}
	
	@PutMapping("/update/{id}")
	public Student updatestudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
	    student.setName("shahrukh khan");
	    student.setPercentage(99.7f);
	    student.setBranch("viscom");
	   
		repo.save(student);
		return student;
		
	}
	@DeleteMapping("/delete/{id}")
	public void deletestudent(@PathVariable int id) {
		
		Student student=repo.findById(id).get();
		repo.delete(student);
		
		
	}
}
