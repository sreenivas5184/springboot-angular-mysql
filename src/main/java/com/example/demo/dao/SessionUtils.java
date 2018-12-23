package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionUtils {

	SessionFactory factory = null; 
	Session session = null;

	public EntityManager getEntityManager() {
		EntityManagerFactory emngrf = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = emngrf.createEntityManager();
		return entityManager;
	}

	public Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate-config.xml"); 
		factory = cfg.buildSessionFactory();
		session = factory.openSession();
		return session;
	}
	
	public void closeSession() {
		if(factory !=null) {
			factory.close();
		}
		if(session !=null) {
			session.clear();
		}
	}
}
