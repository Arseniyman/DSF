package com.av.springmvc.Models;

public class Employee extends Model {
	
	private String name;
	private short age;
	
	public Employee(int id, String name, short age) {
		super(id);
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
}