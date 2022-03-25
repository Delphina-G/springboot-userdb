package com.example.pmdemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class UserPOJO {
	
	@Id
	@Column(name="ID")
	private int id;
	

	@Column(name="NAME",nullable=false)
	private  String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
