package com.toxic.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toxic.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		
		Session  session = factory.getCurrentSession();
		
		// use session object: create java object and save it into data base
		
		try {
			int studentId=1;
			System.out.println("get student with ID " + studentId);
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);
			
			System.out.println("extracted student = " + student);
			
			student.setFirstName("Toxic");
			
			System.out.println("commit session");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("update all emails");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			System.out.println("commit session");
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}

	}

}
