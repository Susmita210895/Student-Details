package com.example.StudentDetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.StudentDetails.entity.StudentDetails;

@Service
public class StudentRecordFiltering {

	public int countWordsStartingWithM(List<StudentDetails> studentList) {
		List<String> studentNameList = studentList.stream().map(student -> student.getStudentName())
				.collect(Collectors.toList());

		int count = 0;

		for (String studentName : studentNameList) {
			if (studentName != null && !studentName.isEmpty()
					&& (studentName.charAt(0) == 'M' || studentName.charAt(0) == 'm')) {
				count++;
			}
		}
		return count;
	}

	public List<String> getWordsLongerThanFive(List<StudentDetails> studentList) {
		if (studentList != null) {
			return studentList.stream().map(student -> student.getStudentName()).filter(word -> word.length() > 5)
					.collect(Collectors.toList());
		}

		return null;
	}
}
