package com.example.tongadive.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.tongadive.Model.Student;
import com.example.tongadive.Model.StudentAdditionalData;
import com.example.tongadive.Model.StudentAdditionalDataDTO;
import com.example.tongadive.Model.StudentDto;
import com.example.tongadive.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
    public void bulkInsertStudents(List<StudentDto> studentsDto) {
		List<Student> students = new ArrayList<>();
        
        for (StudentDto studentDto : studentsDto) {
            Student student = new Student();
            student.setName(studentDto.getName());
            student.setAge(studentDto.getAge());

            if (studentDto.getStuAdditionalData() != null) {
                StudentAdditionalData additionalData = new StudentAdditionalData();
                additionalData.setAddress(studentDto.getStuAdditionalData().getAddress());
                additionalData.setPhoneNumber(studentDto.getStuAdditionalData().getPhoneNumber());
                additionalData.setFatherName(studentDto.getStuAdditionalData().getFatherName());
                additionalData.setMotherName(studentDto.getStuAdditionalData().getMotherName());
                additionalData.setSchoolName(studentDto.getStuAdditionalData().getSchoolName());
                additionalData.setGrade(studentDto.getStuAdditionalData().getGrade());
                additionalData.setDateOfBirth(studentDto.getStuAdditionalData().getDateOfBirth());

                additionalData.setStudent(student);

                student.setStuAdditionalData(additionalData);
            }
            students.add(student);
        }
        studentRepository.saveAll(students);
    }

	@Override
	public Page<StudentDto> getPaginatedStudents(int page, int size) {
	    PageRequest pageable = PageRequest.of(page, size); 

	    Page<Student> studentPage = studentRepository.findAll(pageable);  
	    List<StudentDto> studentDtoList = studentPage.getContent().stream().map(student -> {
	        StudentDto studentDto = new StudentDto();
	        studentDto.setName(student.getName()); 
	        studentDto.setAge(student.getAge());   

	        if (student.getStuAdditionalData() != null) {
	            StudentAdditionalDataDTO additionalDataDTO = new StudentAdditionalDataDTO();
	            additionalDataDTO.setAddress(student.getStuAdditionalData().getAddress());
	            additionalDataDTO.setPhoneNumber(student.getStuAdditionalData().getPhoneNumber());
	            additionalDataDTO.setFatherName(student.getStuAdditionalData().getFatherName());
	            additionalDataDTO.setMotherName(student.getStuAdditionalData().getMotherName());
	            additionalDataDTO.setSchoolName(student.getStuAdditionalData().getSchoolName());
	            additionalDataDTO.setGrade(student.getStuAdditionalData().getGrade());
	            additionalDataDTO.setDateOfBirth(student.getStuAdditionalData().getDateOfBirth());

	            studentDto.setStuAdditionalData(additionalDataDTO);  
	            }

	        return studentDto; 
	    }).collect(Collectors.toList());

	    return new PageImpl<>(studentDtoList, pageable, studentPage.getTotalElements());
	}

	
}
