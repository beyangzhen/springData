package com.beyang.cn.springData;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.beyang.cn.entity.Student;
public interface StudentPagingAndSortingRepository extends PagingAndSortingRepository<Student, Integer> {

}
