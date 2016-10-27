package com.beyang.cn.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beyang.cn.entity.Student;
import com.beyang.cn.springData.StudentRepository;

public class StudentTest {
	@Test
	public void  testFindStudent() {
		ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
		StudentRepository studentRepository = act.getBean(StudentRepository.class);
		System.out.println(studentRepository.getClass().getName());
		Student student = studentRepository.findStudentById(1);
		System.out.println(student);
	}
}
