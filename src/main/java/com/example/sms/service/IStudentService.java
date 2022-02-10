package com.example.sms.service;

import java.util.List;

import com.example.sms.entity.Student;

public interface IStudentService {
	List<Student> getAll();
	void saveStudent(Student student);
	void deleteStudentById(int id);
	Student getStudentById(int id);
}
