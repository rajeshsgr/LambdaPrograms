package com.raj.nola.lambda.examples;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.raj.nola.lambda.examples.model.Employee;


public class GroupbyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee emp1 = new Employee("Chris", 39, "HR", "Kenner",70000);
		Employee emp2 = new Employee("Andreas", 25, "IT", "Metairie",100000);
		Employee emp3 = new Employee("Mike", 29, "IT", "Metairie",85000);
		Employee emp4 = new Employee("Ryan", 30, "Support", "Gretna",60000);
		Employee emp5 = new Employee("Ronald", 35, "HR", "Jefferson",90000);
		Employee emp6 = new Employee("Godwin", 40, "IT", "Jefferson",600000);
		Employee emp7 = new Employee("Dexter", 26, "Support", "Kenner",110000);
		Employee emp8 = new Employee("Scott", 32, "Legal", "Kenner",860000);
		Employee emp9 = new Employee("William", 25, "Legal", "Kenner",55000);
		Employee emp10 = new Employee("Steve", 34, "HR", "Metairie",65000);

		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);
		employeeList.add(emp5);
		employeeList.add(emp6);
		employeeList.add(emp7);
		employeeList.add(emp8);
		employeeList.add(emp9);
		employeeList.add(emp10);
		
		
		 Map<String, List<Employee>> result =employeeList.stream().collect(Collectors.groupingBy(Employee::getCity));
		 
	     System.out.println("\n***Grouped by City****");

		 
	     result.forEach((key, value) -> System.out.println(key + ":" + value));
	     
	     
	     //Employee::getAge
	     //p->p.getAge()
	     
	     Map<String, Double> map= employeeList.stream().collect(Collectors.groupingBy
	    		 (Employee::getCity, 
	    		 Collectors.averagingDouble(p->p.getAge())
	    		 ));
	     
	     System.out.println("\n***Grouped by Average Age in Department****");
	     
	     map.forEach((key, value) -> System.out.println(key + ":" + Math.round(value)  ));
	     
	     
	     
	     
	     Map<String, Double> averageSalaryMap= employeeList.stream().collect(Collectors.groupingBy
	    		 (Employee::getDepartment,
	    				 Collectors.averagingDouble(Employee::getSalary)
	    				 ));
	     
	     System.out.println("\n***Grouped by Average Salary in Department****");
	     
	     NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

	     averageSalaryMap.forEach( (key,value) -> System.out.println(key + ": " + currencyFormat.format(value)) );
	   
	     
	     Optional<Employee> minByAge = employeeList
	    	      .stream()
	    	      .min(Comparator.comparing(Employee::getAge));
	     
	     
	     if(minByAge.isPresent()) {
	    	 System.out.println("\nMinimum Age in group :-"+ minByAge.get().getAge());
	     }
	     
	     double employeeSalarySum= employeeList
	      .stream().distinct().collect(Collectors.summingDouble(Employee::getSalary));
	     
	     
	     System.out.println("\nTotal Salary  :-"+ currencyFormat.format(employeeSalarySum) );
	     
	}

	

}
