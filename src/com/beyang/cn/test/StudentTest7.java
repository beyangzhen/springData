package com.beyang.cn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beyang.cn.springData.StudentRepository2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class StudentTest7 {
	@Autowired
	private StudentRepository2 studentRepository;
	
	@Test
	public void test1(){
		studentRepository.showMessage();
	}
}
