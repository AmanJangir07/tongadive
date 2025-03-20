package com.example.tongadive.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGE", nullable = false)
    private int age;

    // One-to-One mapping with StudentAdditionalData
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private StudentAdditionalData stuAdditionalData;

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

    public StudentAdditionalData getStuAdditionalData() {
        return stuAdditionalData;
    }

    public void setStuAdditionalData(StudentAdditionalData stuAdditionalData) {
        this.stuAdditionalData = stuAdditionalData;
    }
}
