package com.moyu.nicespring.entity;

public class Student {
    private String studentUsername;

    private Integer studentDomitoryid;

    private String studentPassword;

    private String studentName;

    private String studentSex;

    private String studentClass;

    private String studentState;

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername == null ? null : studentUsername.trim();
    }

    public Integer getStudentDomitoryid() {
        return studentDomitoryid;
    }

    public void setStudentDomitoryid(Integer studentDomitoryid) {
        this.studentDomitoryid = studentDomitoryid;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass == null ? null : studentClass.trim();
    }

    public String getStudentState() {
        return studentState;
    }

    public void setStudentState(String studentState) {
        this.studentState = studentState == null ? null : studentState.trim();
    }
}