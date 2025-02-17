package com.example.StudentDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentDetails.entity.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, String> {
}
