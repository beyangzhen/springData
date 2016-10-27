package com.beyang.cn.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beyang.cn.entity.Student;
import com.beyang.cn.springData.StudentCrudRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class StudentTest3 {
	@Autowired(required=false)
	private StudentCrudRepository studentCrudRepository;
	
	/**
	 * 增
	 * */
	@Test
	public void testAdd(){
		Student student = new Student("popo", 30, "pp@yeah.net");
		Student student1 = studentCrudRepository.save(student);
		System.out.println(student1);
		System.out.println(student == student1);
	}
	
	/**
	 * 删
	 * */
	@Test
	public void testDelete(){
		studentCrudRepository.delete(2); 
	}
	
	/**
	 * 改
	 * */
	@Test
	public void testUpdate(){
		Student student = new Student(9, "pop" , 50, "pp0@yeah.net");
		studentCrudRepository.save(student);
	}
	
	/**
	 * 查
	 * */
	@Test
	public void testQuery(){
		Student student = studentCrudRepository.findOne(7);
		System.out.println(student);
	}
	
	/**
	 * 查所有
	 * */
	@Test
	public void testQueryAll(){
//		Iterable<Student> it = studentCrudRepository.findAll();
//		System.out.println(Arrays.asList(it));
		
		ArrayList<Integer> ids = new ArrayList<>();
		ids.add(3);
		ids.add(4);
		ids.add(5);
		Iterable<Student> it = studentCrudRepository.findAll(ids);
		System.out.println(Arrays.asList(it));
		
	}
	
}
