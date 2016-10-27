package com.beyang.cn.springData;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.beyang.cn.entity.Student;

public interface StudentRepository extends Repository<Student, Integer> {
	Student findStudentById(int id);
	
	Student findStudentByStuName(String stuName);
	
	Student findByStuNameLikeAndAgeGreaterThan(String stuName, int age);

	List<Student> findByStuNameLikeOrAgeGreaterThan(String stuName, int age);
	
	Student findByStuNameStartingWith(String stuName);
	
	List<Student>  findByEmailIn(Collection<String> emails);
	
	@Query(" select s from Student s ")
	List<Student> findStudents();
	
	/**
	 * 	   使用占位符的方式
	 * */
	@Query("select s from Student s where s.stuName= ?1 and s.email= ?2")
	Student findStudentByCondition(String userName, String email);
	
	/**
	 *   使用命名参数的方式
	 * */
	@Query("select s from Student s where s.stuName= :userName and s.email= :userEmail")
	Student findStudentByCondition2(@Param("userName")String userName, @Param("userEmail")String userEmail);
	
	
	/**
	 *   模糊查询
	 * */
//	@Query("select s from Student s where  s.stuName like '%:userName%'")
//	List<Student> findStudentByNameLike(@Param("userName")String userName); 
//	@Query("select s from Student s where  s.stuName like '%?1%'")
//	List<Student> findStudentByNameLike(String userName); 
	@Query("select s from Student s where  s.stuName like ?1")
	List<Student> findStudentByNameLike(String userName); 
	
	/**
	 *   使用原生的sql查询语句
	 * */
	@Query(value=" select * from tb_student where  id = ?1", nativeQuery=true)
	Student findStudentByID(Integer id);
	
	/**
	 * 更新学生信息
	 * */
	@Modifying
	@Query("update Student set stuName= ?1 ,age =?2 where id =?3")
	int updateStudentById(String userName, int age, int id);
	
}
