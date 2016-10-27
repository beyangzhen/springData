package com.beyang.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beyang.cn.springData.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 *  SpringData 是只读事务
	 *  -->  @Transactional 可以改变SpringData提供的默认事务方式（即：可以提供修改）
	 */
	@Transactional
	public int updateStudent(String userName, int age, int id){
		return studentRepository.updateStudentById(userName, age, id);
	}
}
