package com.toxic.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toxic.hibernate.entity.Instructor;
import com.toxic.hibernate.entity.InstructorDetail;
import com.toxic.hibernate.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		// create session
		
		Session  session = factory.getCurrentSession();
		
		// use session object: create java object and save it into data base
		
		try {
			
			System.out.println("begin transaction");
			session.beginTransaction();
			
			int id=1;
			Instructor instructor = session.get(Instructor.class,id);
			
			System.out.println("instructor="+instructor);
			
			if (instructor!=null) {
				
				session.delete(instructor);
				
			}
			
			session.getTransaction().commit();
			
			System.out.println("finish actions!");
			
		} finally {
			factory.close();
		}

	}

}
