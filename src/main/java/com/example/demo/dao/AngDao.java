package com.example.demo.dao;

import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.ResponseBean;
import com.example.models.SignUpBeanEntity;

@Repository
public class AngDao {

	@Autowired
	SessionUtils entityManage;

	public String insertNewUser(SignUpBeanEntity sbean) {
		EntityManager entityManager = entityManage.getEntityManager();
		entityManager.getTransaction().begin();
		System.out.println("sbean::::::::::::"+sbean);
		entityManager.persist(sbean);
		entityManager.getTransaction().commit();
		entityManager.close();
		return "You have singup successfully click the Home Button to Login";
	}
	public Date loginUser(SignUpBeanEntity sbean) {
		Session session = entityManage.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from SignUpBeanEntity s where s.email=:email and s.password=:password");
		query.setString("email", sbean.getEmail());
		query.setString("password", sbean.getPassword());
		Object uniqueResult = query.uniqueResult();
		System.out.println(uniqueResult);
		SignUpBeanEntity bean = (SignUpBeanEntity)uniqueResult;
		Date lastLoginDate = null;
		if(uniqueResult !=null) {
			lastLoginDate = bean.getLastLoignDate();
			bean.setLastLoignDate(new Date());
			session.update(bean);
			session.getTransaction().commit();
			return lastLoginDate;
		}
		entityManage.closeSession();
		return lastLoginDate;
	}
	public SignUpBeanEntity getProfile(String  email) {
		Session session = entityManage.getSession();
		Query query = session.createQuery("from SignUpBeanEntity s where s.email=:email");
		query.setString("email", email);
		Object uniqueResult = query.uniqueResult();
		entityManage.closeSession();
		return (SignUpBeanEntity)uniqueResult;
	}
	public ResponseBean updateProfile(SignUpBeanEntity bean) {
		ResponseBean resBean = null;
		Session session = entityManage.getSession();
		session.beginTransaction();
		Object obj = session.get(SignUpBeanEntity.class, bean.getEmail());
		SignUpBeanEntity signupBean = (SignUpBeanEntity)obj;
		signupBean.setFirstName(bean.getFirstName());
		signupBean.setLastName(bean.getLastName());
		signupBean.setPhoneNumber(bean.getPhoneNumber());
		signupBean.setAddress(bean.getAddress());
		session.getTransaction().commit();
		entityManage.closeSession();
		resBean = new ResponseBean();
		resBean.setStatus("success");
		return resBean;
	}
}
