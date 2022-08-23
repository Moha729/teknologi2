package com.mo.teknologi2.model;

public class Student {

    private int id;
    private String name;
    private int age;
    private String education;

    public Student(int id, String name, int age, String education) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.education = education;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
