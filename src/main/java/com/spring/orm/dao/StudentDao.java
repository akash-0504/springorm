package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entites.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	// save student
	@Transactional
	public int insert(Student student) {

		// insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	// Get the single data(object)
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	// get all student(all rows)
	public List<Student> getallstudentsList() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//delete the data
	@Transactional
	public void deleteStudent( int StudentId) {
		 Student student = this.hibernateTemplate.get(Student.class, StudentId);
		this.hibernateTemplate.delete(student);
	}
	
	//updateing the data 
	@Transactional
	public void upadteStudent (Student student ) {
		  this.hibernateTemplate.update(student);
		 	
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}