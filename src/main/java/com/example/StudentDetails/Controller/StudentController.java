package com.example.StudentDetails.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.StudentDetails.entity.StudentDetails;
import com.example.StudentDetails.service.StudentRecordFiltering;
import com.example.StudentDetails.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	private StudentRecordFiltering studentRecordFiltering;

	@Autowired
	public StudentController(final StudentService studentService, final StudentRecordFiltering studentRecordFiltering) {
		this.studentService = studentService;
		this.studentRecordFiltering = studentRecordFiltering;
	}

	@GetMapping
	public List<StudentDetails> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping
	public ResponseEntity<StudentDetails> createStudent(@RequestBody StudentDetails student) {
		StudentDetails savedStudent = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
	}

	@GetMapping("/startWithM")
	public int getfilteredStudents() {
		List<StudentDetails> allStudents = studentService.getAllStudents();
		return studentRecordFiltering.countWordsStartingWithM(allStudents);
	}

	@GetMapping("/countWordsMoreThanFive")
	public List<String> getWordsMoreThanFive() {
		List<StudentDetails> allStudents = studentService.getAllStudents();
		return studentRecordFiltering.getWordsLongerThanFive(allStudents);
	}
}
