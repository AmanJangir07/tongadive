package com.example.tongadive.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.tongadive.Model.Student;
import com.example.tongadive.Model.StudentDto;

public interface StudentService {

	Page<StudentDto> getPaginatedStudents(int page, int size);

	void bulkInsertStudents(List<StudentDto> studentsDto);

}
