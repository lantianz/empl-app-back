package com.ltz.emplInfo.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tianzhi
 * @since 2024-02-04
 */
public class Graduate implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer studentId;

    private String name;

    private String gender;

    private String department;

    private String major;

    private String grade;

    private String username;

    private String password;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Graduate{" +
            "studentId = " + studentId +
            ", name = " + name +
            ", gender = " + gender +
            ", department = " + department +
            ", major = " + major +
            ", grade = " + grade +
            ", username = " + username +
            ", password = " + password +
        "}";
    }
}
