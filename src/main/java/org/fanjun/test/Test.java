package org.fanjun.test;

import java.util.ArrayList;
import java.util.List;

import org.fanjun.model.Account;
import org.fanjun.model.College;
import org.fanjun.model.Lecture;
import org.fanjun.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("dd");
			AnnotationConfiguration config=new AnnotationConfiguration();
			config.configure("hibernate-cfg.xml");
			config.addAnnotatedClass(Student.class);
			config.addAnnotatedClass(Account.class);
			config.addAnnotatedClass(College.class);
			config.addAnnotatedClass(Lecture.class);
			
			
			new SchemaExport(config).create(true, true);
			
			SessionFactory Factory =config.buildSessionFactory();
			Session session =Factory.getCurrentSession();
			
			session.beginTransaction();
			
				Account a1= new Account();
				a1.setAccountId(907332);
				a1.setBalance(12);
				a1.setType("Studnet card");
			
				Account a2= new Account();
				a2.setAccountId(907333);
				a2.setBalance(14);
				a2.setType("Studnet card");
				
				Account a3= new Account();
				a3.setAccountId(907334);
				a3.setBalance(13);
				a3.setType("Teacher card");
				
				College c=new College();
			c.setCollegeId(1);
			c.setCollegeName("GroepT");
				
				
			Student fanjun =new Student();
			//fanjun.setStudentId(101);
			fanjun.setfirstname("fanjun");
			fanjun.setyearLevel(2);
			fanjun.setlastname("wu");
			fanjun.setAccount(a1);
			fanjun.setCollege(c);
			
			
			Student lihua =new Student();
			lihua.setfirstname("lihua");
			lihua.setyearLevel(1);
			fanjun.setlastname("chenc");
			lihua.setCollege(c);
			
			lihua.setAccount(a2);
			
			
			Student cheng =new Student();
			cheng.setfirstname("cheng");
			cheng.setyearLevel(2);
			fanjun.setlastname("Xu");
			cheng.setAccount(a3);
			cheng.setCollege(c);
			
			Lecture l1=new Lecture();
			Lecture l2=new Lecture();
			
			l1.setLectureId(1);
			l2.setLectureId(2);
			l1.setLecutreName("DSP");
			l2.setLecutreName("DAQ");
			l1.setProfssor("Koen");
			l2.setProfssor("Luc");
			l1.getStudents().add(fanjun);
			l1.getStudents().add(lihua);
			l2.getStudents().add(lihua);
			l2.getStudents().add(cheng);
			
			
			
			
			session.save(c);
			session.save(fanjun);
			session.save(cheng);
			session.save(lihua);
			
			
			session.save(l1);
			session.save(l2);
			
			
			
			//go to database here
			session.getTransaction().commit();
			
			
			


	}

}
