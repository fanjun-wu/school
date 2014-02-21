package org.fanjun.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.fanjun.dao.StudentDao;
import org.fanjun.model.College;
import org.fanjun.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Component
public class StudentDaoImpl implements StudentDao {
	@Autowired
	@Resource(name="sessionFactory")
	private SessionFactory session;
	
	

	

	@Override
	public void add(Student student) {
		session.getCurrentSession().save(student);
	}

	@Override
	public void edit(Student student) {
		session.getCurrentSession().update(student);
	}

	@Override
	public void delete(int studentId) {		
		session.getCurrentSession().delete(getStudent(studentId));
	}

	@Override
	public Student getStudent(int studentId) {
		return (Student)session.getCurrentSession().get(Student.class, studentId);
	}

	@Override
	public List getAllStudent() {
		return session.getCurrentSession().createQuery("from Student").list();
	}

	@Override
	public void addStudenttoCollege(int studentId, int collegeId) {
		// TODO Auto-generated method stub
		
		System.out.println("Here");
		Student eStudent = (Student)session.getCurrentSession().get(Student.class, studentId);
		System.out.println("Here");
		
		System.out.println("Here");
		// Assign updated values to this person
		eStudent.setCollege((College) session.getCurrentSession().get(College.class, collegeId));
	/*	session.getCurrentSession().save(eStudent);
		session.getCurrentSession().save(eCollege);*/
		System.out.println("Here");
		
		
	}

}
