package com.beyang.cn.test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beyang.cn.entity.Student;
import com.beyang.cn.springData.StudentJpaSpecificationExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class StudentTest6 {
	@Autowired(required=false)
	private StudentJpaSpecificationExecutor studentJpaSpecificationExecutor;
	
	@Test
	public void testQuery(){
		int page = 2-1;
		int size = 3;
		
		Pageable pageable = new PageRequest(page, size);
		Specification<Student> spec = new Specification<Student>(){
			/**
			 *  root : 代表查询的实体类
			 *  query： 可以从中获取到root对象，告诉JPA Criteria对象要查询哪个实体类，还可以来添加查询条件
			 *  	       还可以结合EntityManager对象获取最终的查询的TypeedQuery对象
			 *  cb   : CriteriaBuilder 对象，用于创建 Criteria相关的对象的工厂。可以从中获取Predicate对象
			 * */
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 查找ID > 6的所有的学生信息
				Path path = root.get("id");
				Predicate predicate = cb.gt(path, 6);
				return predicate;
			}
		};
		
		Page<Student>  pageList = studentJpaSpecificationExecutor.findAll(spec, pageable);
		
		System.out.println("当前是第几页：" + (pageList.getNumber()+1));
		System.out.println("当前页的数量：" + pageList.getNumberOfElements());
		System.out.println("每页的数量：" + pageList.getSize());
		System.out.println("总页数： " + pageList.getTotalPages());
		System.out.println("当前页的数据集合： " + pageList.getContent());
	}
	
}
