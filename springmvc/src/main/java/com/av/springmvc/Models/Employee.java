package com.av.springmvc.Models;

public class Employee {
	
	private int id;
	private String name;
	private short age;
	
	public Employee(int id, String name, short age) {
		this.setId(id);
		this.name = name;
		this.age = age;
	}
	
	public Employee(String name, short age) {
		this. name = name;
		this.age = age;
	}
	
	public Employee() {}
	
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

	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}