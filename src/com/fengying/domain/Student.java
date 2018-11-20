package com.fengying.domain;

import java.util.Date;

public class Student {
    private int sid;
    private String sname;
    private String gender;
    private String phone;
    private String hobby;
    private String info;
    private Date birthday;

    public Student(){
        super();
    }

    public Student(String sname, String gender, String phone, String hobby, String info, Date birthday) {
        this.sname = sname;
        this.gender = gender;
        this.phone = phone;
        this.hobby = hobby;
        this.info = info;
        this.birthday = birthday;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getHobby() {
        return hobby;
    }

    public String getInfo() {
        return info;
    }

    public Date getBirthday() {
        return birthday;
    }
}
