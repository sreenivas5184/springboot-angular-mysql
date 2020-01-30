package com.example.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle_New")
public class Vehicle {

	@Id
	int vid;
	String vname;
	String vmodel;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "login_id")
	SignUpBeanEntity  beanEntity;
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVmodel() {
		return vmodel;
	}
	public void setVmodel(String vmodel) {
		this.vmodel = vmodel;
	}
	
}
