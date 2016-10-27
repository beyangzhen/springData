package com.beyang.cn.springData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.beyang.cn.entity.Student;

public interface StudentJpaSpecificationExecutor extends JpaSpecificationExecutor<Student>, JpaRepository<Student, Integer> {

}
