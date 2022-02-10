package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Classroom;

public interface IClassroomRepository extends JpaRepository<Classroom, Integer> {

}
