package com.example.StudentDetails.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentDetails {

	@Id
	private String rollNumber;
	private String studentName;
	private int age;
	private String studentClass;

	public StudentDetails() {
	}

	public StudentDetails(String rollNumber, String studentName, int age, String studentClass) {
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.age = age;
		this.studentClass = studentClass;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
}
