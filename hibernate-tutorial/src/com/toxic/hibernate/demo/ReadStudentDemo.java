package com.toxic.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toxic.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		
		Session  session = factory.getCurrentSession();
		
		// use session object: create java object and save it into data base
		
		try {
			System.out.println("create object");
			Student st = new Student("Toxic", "Strelock","toxic@ukr.net");
			
			System.out.println("begin transaction");
			session.beginTransaction();
			
			System.out.println("save object:"+st);
			session.save(st);
			
			System.out.println("commit session");
			session.getTransaction().commit();
			
			System.out.println("generated id = " + st.getId());
			System.out.println("finish actions!");
			
			// new session
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Getting student with id: " + st.getId());
			
			Student newStudent = session.get(Student.class, st.getId());
			
			System.out.println("Retriving student = " + newStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

}
