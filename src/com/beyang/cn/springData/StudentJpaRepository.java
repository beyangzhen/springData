package com.beyang.cn.springData;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beyang.cn.entity.Student;

public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
}
