package com.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.user;

public class app {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cgf.xml")
				.addAnnotatedClass(user.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			//user user = new user(2,"sam","sam@gmail.com");
			user user1= new user(); 
			session.beginTransaction();
			user1=session.get(user.class,2);
			System.out.println(user1);
			user1=session.get(user.class,2);
			
			user1.setUser_name("Sam1");
			//session.save(user);
			session.getTransaction().commit();
			System.out.println("Row added");
			System.out.println(user1);

		}finally {
			session.close();
			factory.close();
		}
	
	}

}
