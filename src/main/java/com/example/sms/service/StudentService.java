package com.example.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService{
	private IStudentRepository studentRepository;
	
	//Eğer sadece bean içinde sadece bir constructor varsa Autowired kullanmaya gerek yok.
	public StudentService(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);		
	}


	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();		
	}
	

}
