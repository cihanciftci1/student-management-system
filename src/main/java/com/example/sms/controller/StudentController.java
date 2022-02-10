package com.example.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.IClassroomService;
import com.example.sms.service.IStudentService;

@Controller
public class StudentController {
	private IStudentService studentService;
	private IClassroomService classroomService;

	public StudentController(IStudentService studentService, IClassroomService classroomService) {
		this.studentService = studentService;
		this.classroomService=classroomService;
	}
	
	@GetMapping("/students")
	public String listStudent(Model model){
		model.addAttribute("students", studentService.getAll());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student form data
		model.addAttribute("student", new Student());
		model.addAttribute("classrooms", classroomService.getAll());
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id,Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		model.addAttribute("classrooms", classroomService.getAll());
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student){
		Student studentToUpdate=studentService.getStudentById(id);
		studentToUpdate.setFirstName(student.getFirstName());
		studentToUpdate.setLastName(student.getLastName());
		studentToUpdate.setEmail(student.getEmail());
		studentToUpdate.setClassroom(student.getClassroom());
		studentService.saveStudent(studentToUpdate);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
