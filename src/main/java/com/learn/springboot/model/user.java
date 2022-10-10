package com.learn.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user 
{
	@Id
	private int aid;
	private String aname;
	
	public user()
	{
		
	}
	
	public user(int aid,String aname)
	{
		setAid(aid);
		setAname(aname);
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "AddUser [aid=" + aid + ", aname=" + aname + "]";
	}
	

}
