package com.oracle.vo;

public class Student implements java.io.Serializable{
	private int stuid;
	private String name;
	private String se;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSe() {
		return se;
	}
	public void setSe(String se) {
		this.se = se;
	}
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", name=" + name + ", se=" + se + "]";
	}
	public Student(int stuid, String name, String se) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.se = se;
	}
	public Student() {
		super();
	}
	
	
	
}
