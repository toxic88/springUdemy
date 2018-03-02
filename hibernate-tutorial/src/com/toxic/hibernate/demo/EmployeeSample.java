package com.toxic.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeSample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Employee anton = new Employee("Anton", "Soroka", "home");
			Employee sasha = new Employee("Sasha", "Volkovskyi", "astral");
			
			System.out.println("anton="+anton);
			System.out.println("sasha="+sasha);
			
			session.beginTransaction();
			
			session.save(anton);
			session.save(sasha);
			
			session.getTransaction().commit();
			
			int antonId = anton.getId();
			System.out.println("anton id is " + antonId);
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			anton = session.get(Employee.class, antonId);
			System.out.println("[update]anton="+anton);
			anton.setCompany("astral[inc]");
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			List<Employee> employees = session.createQuery("from Employee").getResultList();
			
			for (Employee employee : employees) {
				System.out.println("employee="+employee);
			}
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			sasha = session.load(Employee.class, sasha.getId());
			
			session.delete(sasha);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
