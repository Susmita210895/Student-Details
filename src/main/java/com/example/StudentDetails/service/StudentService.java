package com.example.StudentDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentDetails.entity.StudentDetails;
import com.example.StudentDetails.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<StudentDetails> getAllStudents() {
		return studentRepository.findAll();
	}

	public StudentDetails saveStudent(StudentDetails student) {
		return studentRepository.save(student);
	}
}
