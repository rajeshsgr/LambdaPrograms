package com.raj.nola.lambda.examples.model;

public class Employee {

	public String name;
	public double age;
	public String department;
	public String city;
	public double salary;
	
	
	
	
	public Employee(String name, double age, String department, String city, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
		this.city = city;
		this.salary = salary;
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", department=" + department + ", city=" + city + ", salary="
				+ salary + "]";
	}

	
	
	

}
