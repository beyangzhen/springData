package com.beyang.cn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beyang.cn.entity.Student;
import com.beyang.cn.springData.StudentJpaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class StudentTest4 {
	@Autowired(required=false)
	private StudentJpaRepository studentJpaRepository;
	
	@Test
	public void testSaveFlush() {
		studentJpaRepository.saveAndFlush(new Student("100", 1, "100@yeah.net"));
		studentJpaRepository.saveAndFlush(new Student("88", 88, "88@yeah.net"));
	}
	
}
