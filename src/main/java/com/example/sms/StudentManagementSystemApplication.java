package com.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sms.entity.Classroom;
import com.example.sms.repository.IClassroomRepository;


@SpringBootApplication
public class StudentManagementSystemApplication {
	@Autowired
	private IClassroomRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}


}
