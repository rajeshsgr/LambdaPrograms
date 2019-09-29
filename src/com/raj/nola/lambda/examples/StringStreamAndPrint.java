package com.raj.nola.lambda.examples;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStreamAndPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	    String[] toppings = {"Cheese", "Pepperoni", "Olives", "Garlic","Pepperoni" };
	    
	    System.out.println("\nArray of Strings\n");
				
		Stream.of(toppings).forEach(System.out::println);
		
		
		System.out.println("\nSorted Array of Strings\n");
		
		Stream.of(toppings).sorted().forEach(System.out::println);
		
		
		List<String> sortedList =Stream.of(toppings).sorted().collect(Collectors.toList());
		
		long count=sortedList.stream().distinct().count();
		
		System.out.println("\nTotal Distinct items:-"+count);
		
		
		System.out.println("\nDistinct Array of Strings\n");
		
		Stream.of(toppings).distinct().forEach(System.out::println);
		
		Map<String,Long> frequencyMap= Stream.of(toppings).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println("\nElements and Count\n");

		frequencyMap.entrySet().stream().forEach(System.out::println);
	}

}
