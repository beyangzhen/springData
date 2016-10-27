package com.beyang.cn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="tb_student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String stuName;
	private int age;
	private String email;
	
	
	public Student() {
	}

	public Student(String stuName, int age, String email) {
		this.stuName = stuName;
		this.age = age;
		this.email = email;
	}

	public Student(int id, String stuName, int age, String email) {
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age + ", email=" + email + "]";
	}
	
}
