package com.beyang.cn.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beyang.cn.entity.Student;
import com.beyang.cn.springData.StudentPagingAndSortingRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class StudentTest5 {
	@Autowired(required=false)
	private StudentPagingAndSortingRepository studentPagingAndSortingRepository;
	
	@Test
	public void testSave(){
		studentPagingAndSortingRepository.save(new Student());
	}
	
	/*
	 *  排序
	 * */
	@Test
	public void testSort(){
		Order order = new Sort.Order(Direction.ASC, "age");
		Order order1 = new Sort.Order(Direction.DESC, "stuName");
		List<Order> orderList = new ArrayList<>();
		orderList.add(order);
		orderList.add(order1);
//		Sort sort = new Sort(order);
//		Sort sort = new Sort(orderList);
		Sort sort = new Sort("stuName");
		Iterable<Student> studentList = studentPagingAndSortingRepository.findAll(sort);
		System.out.println(Arrays.asList(studentList));
	}
	
	/**
	 *  分页
	 * */
	@Test
	public void testPage(){
		int page = 2 - 1;
		int size = 3;
		Pageable pageable = new PageRequest(page, size);
		Page<Student> pageList=studentPagingAndSortingRepository.findAll(pageable);
		System.out.println("当前是第几页：" + (pageList.getNumber()+1));
		System.out.println("当前页的数量：" + pageList.getNumberOfElements());
		System.out.println("每页的数量：" + pageList.getSize());
		System.out.println("总页数： " + pageList.getTotalPages());
		System.out.println("当前页的数据集合： " + pageList.getContent());
	}	
}
