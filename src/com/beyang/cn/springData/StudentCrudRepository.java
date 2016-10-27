package com.beyang.cn.springData;

import org.springframework.data.repository.CrudRepository;

import com.beyang.cn.entity.Student;

public interface StudentCrudRepository extends CrudRepository<Student, Integer>{
	
}
