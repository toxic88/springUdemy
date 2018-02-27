package com.toxic.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toxic.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		
		Session  session = factory.getCurrentSession();
		
		// use session object: create java object and save it into data base
		
		try {
			System.out.println("cretae object");
			Student st = new Student("Anton", "Soroka","toxic@gmail.com");
			
			System.out.println("begin transaction");
			session.beginTransaction();
			
			System.out.println("save object");
			
			session.save(st);
			
			System.out.println("commit session");
			session.getTransaction().commit();
			
			System.out.println("finish actions!");
			
		} finally {
			factory.close();
		}

	}

}
