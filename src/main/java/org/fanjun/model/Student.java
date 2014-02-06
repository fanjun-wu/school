package org.fanjun.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="StudentInfo")
public class Student {
	
	private int studentId;
	private String firstname;
	private String lastname;
	private int yearLevel;
	
	private College college;
	
	private List<Lecture> lectures =new ArrayList<Lecture>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="Student_Lecture",joinColumns={@JoinColumn(name="studentId")},inverseJoinColumns={@JoinColumn(name="LectureId")} )
	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}

	@ManyToOne
	@JoinColumn(name="college_Id")
	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
	private Account account;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name ="pDetail_FK")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	//@Transient
	@Column
	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	
	//@Basic
	@Column
	public int getyearLevel() {
		return yearLevel;
	}

	public void setyearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

	@Id
	@Column(name="StudentId")
	@GeneratedValue(strategy=GenerationType.AUTO)//fro autonumber
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Column
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	
//@Temporal(TemporalType.Date)
}
