package com.mini;

public class Student extends BaseDTO {
    private Long id;
    private String name;
    private String sex;
    private Integer age;
    private String course;
    private Integer score;
    private String  country;

    public Student() {
    }

    public Student(String name, String sex, Integer age, String course, Integer score) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.score = score;
    }

    public Student(Long id, String name, String sex, Integer age, String course, Integer score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.score = score;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
