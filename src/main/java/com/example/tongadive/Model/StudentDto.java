package com.example.tongadive.Model;


public class StudentDto {
    
    private Long id;
    private String name;
    private int age;
    private StudentAdditionalDataDTO stuAdditionalData;
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentAdditionalDataDTO getStuAdditionalData() {
        return stuAdditionalData;
    }

    public void setStuAdditionalData(StudentAdditionalDataDTO stuAdditionalData) {
        this.stuAdditionalData = stuAdditionalData;
    }
}
