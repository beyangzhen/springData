package com.beyang.cn.springData;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beyang.cn.dao.StudentDao;
import com.beyang.cn.entity.Student;

public interface StudentRepository2 extends StudentDao, JpaRepository<Student, Integer> {

}
