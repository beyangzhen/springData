package com.beyang.cn.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.beyang.cn.entity.Student;

public class StudentRepositoryImpl implements StudentDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void showMessage() {
		Student student = entityManager.find(Student.class, 5);
		System.out.println("good...." + student);
	}
}
