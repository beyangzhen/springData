package com.beyang.cn.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beyang.cn.entity.Student;
import com.beyang.cn.service.StudentService;
import com.beyang.cn.springData.StudentRepository;


// 表示整合Junit4进行测试，需要加入spring-test.jar包
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring配置文件
@ContextConfiguration(locations={"classpath:spring.xml"})
public class StudentTest2 {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testQuery() {
//		Student student=studentRepository.findByStuNameLikeAndAgeGreaterThan("%d%", 20);
//		System.out.println(student);
		
//		List<Student> students=studentRepository.findByStuNameLikeOrAgeGreaterThan("%d%", 20);
//		System.out.println(Arrays.asList(students));
		
//		Student student=studentRepository.findByStuNameStartingWith("b");
//		System.out.println(student);
		
		List<String> emails = new ArrayList<>();
		emails.add("aaa@Yeah.net");
		emails.add("bb@yeah.net");
		List<Student> students = studentRepository.findByEmailIn(emails);
		System.out.println(Arrays.asList(students));
	}
	
	/*
	 * 根据名字查询学生信息
	 * */
	@Test
	public void testFindStudentByName() {
		Student student=studentRepository.findStudentByStuName("did");
		System.out.println(student);
	}
	
	@Test
	public void  testFindStudent() {
		System.out.println(studentRepository.getClass().getName());
		Student student=studentRepository.findStudentById(1);
		System.out.println(student);
	}
	
	@Test
	public void testStudentByCondition() {
		Student student = studentRepository.findStudentByCondition("did@qq.com", "did");
		System.out.println(student);
	
		List<Student> studentList = studentRepository.findStudentByNameLike("%d%");
		System.out.println(Arrays.asList(studentList));
		
		Student stu = studentRepository.findStudentByID(1);
		System.out.println(stu);
	}
	
	@Test
	public void testAll() {
		List<Student> studens = studentRepository.findStudents();
		System.out.println(Arrays.asList(studens));
	}
	
	@Test
	public void testUpdataStudent(){
		int i = studentRepository.updateStudentById("uuuu", 120, 1);
		System.out.println(i);
	}
	
	@Test
	public void testUpdataStudent2(){
		int i = studentService.updateStudent("uuuu", 120, 1);
		System.out.println(i);
	}
	
}
