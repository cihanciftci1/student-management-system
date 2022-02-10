package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;

//JpaRepository already has annotated with Repository.
//JpaRepository already has hibernate queries.
//Because of that we don't need to create a StudentRepository class to define the methods.
public interface IStudentRepository extends JpaRepository<Student, Integer>{
	

}
