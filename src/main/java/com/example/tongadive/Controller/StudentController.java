package com.example.tongadive.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tongadive.Model.Student;
import com.example.tongadive.Model.StudentDto;
import com.example.tongadive.Service.StudentService;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/bulk-insert")
    public ResponseEntity<String> bulkInsertStudents(@RequestBody List<StudentDto> studentsDTO) {
        studentService.bulkInsertStudents(studentsDTO);
        return ResponseEntity.ok("Bulk insert successful");
    }

	@GetMapping("")
	public ResponseEntity<Page<StudentDto>> getPaginatedStudents(
	        @RequestParam(name = "page", defaultValue = "0") int page,
	        @RequestParam(name = "size", defaultValue = "10") int size) {

	    Page<StudentDto> studentDtos = studentService.getPaginatedStudents(page, size);
	    return ResponseEntity.ok(studentDtos);
	}

}
