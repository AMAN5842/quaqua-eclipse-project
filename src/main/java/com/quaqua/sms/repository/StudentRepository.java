package com.quaqua.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quaqua.sms.student.StudentDetails;
	
	 
	public interface StudentRepository extends JpaRepository<StudentDetails, Long> {
	 
	}


