package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AngDao;
import com.example.models.ResponseBean;
import com.example.models.SignUpBeanEntity;

@Service
public class AngService {

	@Autowired
	AngDao signUpDao;
	
	public String signUpUser(SignUpBeanEntity sbean) {
		return signUpDao.insertNewUser(sbean);
	}
	public Date loginUpUser(SignUpBeanEntity sbean) {
		return signUpDao.loginUser(sbean);
	}
	public SignUpBeanEntity getProfile(String email) {
		return signUpDao.getProfile(email);
	}
	
	public ResponseBean updateProfile(SignUpBeanEntity sbean) {
		return signUpDao.updateProfile(sbean);
	}
}
