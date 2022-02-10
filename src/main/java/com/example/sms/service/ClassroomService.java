package com.example.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sms.entity.Classroom;
import com.example.sms.repository.IClassroomRepository;

@Service
public class ClassroomService implements IClassroomService{
	private IClassroomRepository repository;

	public ClassroomService(IClassroomRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Classroom> getAll() {
		return repository.findAll();
	}
	
	
}
