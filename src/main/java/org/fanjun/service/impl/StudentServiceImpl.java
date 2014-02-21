package org.fanjun.service.impl;

import java.util.List;

import org.fanjun.dao.StudentDao;
import org.fanjun.model.Student;
import org.fanjun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	
	public void add(Student student) {
		studentDao.add(student);
	}

	public void edit(Student student) {
		studentDao.edit(student);
	}


	public void delete(int studentId) {
		studentDao.delete(studentId);
	}


	public Student getStudent(int studentId) {
		return studentDao.getStudent(studentId);
	}

	
	public List getAllStudent() {
		return studentDao.getAllStudent();
	}

	
	public void addStudenttoCollege(int studentId, int collegeId) {
		// TODO Auto-generated method stub
		studentDao.addStudenttoCollege(studentId, collegeId);
	}

}
