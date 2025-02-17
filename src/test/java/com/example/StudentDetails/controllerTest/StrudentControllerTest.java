package com.example.StudentDetails.controllerTest;

import com.example.StudentDetails.Controller.StudentController;
import com.example.StudentDetails.entity.StudentDetails;
import com.example.StudentDetails.service.StudentRecordFiltering;
import com.example.StudentDetails.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

	@InjectMocks
	private StudentController studentController;

	@Mock
	private StudentService studentService;

	@Mock
	private StudentRecordFiltering studentRecordFiltering;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetAllStudents() {
		StudentDetails student1 = new StudentDetails("2F432", "Vishal", 13, "7B");
		StudentDetails student2 = new StudentDetails("2F433", "Maitra", 14, "7B");

		List<StudentDetails> students = Arrays.asList(student1, student2);
		when(studentService.getAllStudents()).thenReturn(students);

		List<StudentDetails> response = studentController.getAllStudents();

		assertNotNull(response);
		assertEquals(2, response.size());
		assertEquals("Vishal", response.get(0).getStudentName());
		assertEquals("Maitra", response.get(1).getStudentName());
	}

	@Test
	void testCreateStudent() {
		StudentDetails student = new StudentDetails("2F435", "Ananya", 15, "8A");

		when(studentService.saveStudent(student)).thenReturn(student);

		ResponseEntity<StudentDetails> response = studentController.createStudent(student);

		assertNotNull(response);
		assertEquals(201, response.getStatusCodeValue());
		assertEquals("Ananya", response.getBody().getStudentName());
		assertEquals(15, response.getBody().getAge());
		assertEquals("8A", response.getBody().getStudentClass());
	}

	@Test
	void testGetFilteredStudents() {

		StudentDetails student1 = new StudentDetails("2F432", "Vishal", 13, "7B");
		StudentDetails student2 = new StudentDetails("2F433", "Maitra", 14, "7B");
		StudentDetails student3 = new StudentDetails("2F434", "Mona", 15, "7B");

		List<StudentDetails> students = Arrays.asList(student1, student2, student3);
		when(studentService.getAllStudents()).thenReturn(students);

		when(studentRecordFiltering.countWordsStartingWithM(students)).thenReturn(2);

		int result = studentController.getfilteredStudents(); // this should now return the count of students

		assertEquals(2, result);

	}

	@Test
	void testGetWordsMoreThanFive() {
		StudentDetails student1 = new StudentDetails("2F432", "Vishal", 13, "7B");
		StudentDetails student2 = new StudentDetails("2F433", "Maitra", 14, "7B");
		StudentDetails student3 = new StudentDetails("2F434", "Mona", 15, "7B");

		List<StudentDetails> students = Arrays.asList(student1, student2, student3);
		when(studentService.getAllStudents()).thenReturn(students);

		when(studentRecordFiltering.getWordsLongerThanFive(students)).thenReturn(Arrays.asList("Vishal", "Maitra"));

		List<String> result = studentController.getWordsMoreThanFive();

		assertNotNull(result);
		assertEquals(2, result.size());
		assertTrue(result.contains("Vishal"));
		assertTrue(result.contains("Maitra"));
	}
}
