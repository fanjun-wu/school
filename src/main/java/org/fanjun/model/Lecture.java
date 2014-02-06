package org.fanjun.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
@Entity
public class Lecture {
	
	private int LectureId;
	private String LecutreName;
	private String Profssor;
	private List<Student> students=new ArrayList<Student>();
	
	@ManyToMany
	@JoinTable(name="Student_Lecture",joinColumns={@JoinColumn(name="LectureId")},inverseJoinColumns={@JoinColumn(name="studentId")} )
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getLectureId() {
		return LectureId;
	}
	public void setLectureId(int lectureId) {
		LectureId = lectureId;
	}
	public String getLecutreName() {
		return LecutreName;
	}
	public void setLecutreName(String lecutreName) {
		LecutreName = lecutreName;
	}
	public String getProfssor() {
		return Profssor;
	}
	public void setProfssor(String profssor) {
		Profssor = profssor;
	}

}
