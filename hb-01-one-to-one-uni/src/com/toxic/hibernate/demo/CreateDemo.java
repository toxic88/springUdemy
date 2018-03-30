package com.toxic.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toxic.hibernate.entity.Instructor;
import com.toxic.hibernate.entity.InstructorDetail;

public class CreateDemo {

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
//			Instructor instructor = new Instructor("Anton", "Soroka", "antonsoroka@ukr.net");
//			
//			InstructorDetail detail = new InstructorDetail("lineage 2", "programming");
			
			Instructor instructor = new Instructor("Sasha", "Volkovskyi", "b1gs@ukr.net");
			
			InstructorDetail detail = new InstructorDetail("heroes of might and magic", "smoking");
			
			instructor.setInstructorDetail(detail);
			
			System.out.println("begin transaction");
			session.beginTransaction();
			
			System.out.println("saving="+instructor);
			session.save(instructor);
			
			System.out.println("commit session");
			session.getTransaction().commit();
			
			System.out.println("finish actions!");
			
		} finally {
			factory.close();
		}

	}

}
