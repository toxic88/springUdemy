package com.toxic.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toxic.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		
		Session  session = factory.getCurrentSession();
		
		// use session object: create java object and save it into data base
		
		try {
			
			System.out.println("begin transaction");
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").getResultList(); 
			
			printStudents(students);
			
			students = session.createQuery("from Student s where s.lastName='Soroka'").getResultList();
			
			System.out.println("with where condition");
			
			printStudents(students);
			
			students = session.createQuery("from Student s where s.lastName='Soroka' OR s.firstName='Toxic'").getResultList();
			
			System.out.println("with OR condition");
			
			printStudents(students);
			
			students = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			
			System.out.println("condition with email");
			
			printStudents(students);
			
			System.out.println("commit session");
			session.getTransaction().commit();
			
			System.out.println("finish actions!");
			
		} finally {
			factory.close();
		}

	}

	private static void printStudents(List<Student> students) {
		for (Student st:students) {
			System.out.println(st);
		}
	}

}
