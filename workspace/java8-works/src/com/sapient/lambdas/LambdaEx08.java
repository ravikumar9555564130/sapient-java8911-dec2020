package com.sapient.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaEx08 {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,5,-9,-7,-12,-77, 555);
		
		Predicate<Integer> positive =   i -> i>0; 
		
		list.stream().filter(positive).
			collect(Collectors.toList()).forEach(System.out :: println);
		
		// to check on the string if its not empty 
		
		List<String> strList = 
				Arrays.asList("Hello", "", "how", "are", "you", "", "today");
		
		List<String> filterString = strList.stream().filter(s -> !s.isEmpty())
					    .collect(Collectors.toList()); 
		
		filterString.forEach(System.out ::println);
		
		// to generate random number in sorted order 
		Random random = new Random(); 
		random.ints().limit(10).sorted().forEach(System.out ::println);

	}
}

















