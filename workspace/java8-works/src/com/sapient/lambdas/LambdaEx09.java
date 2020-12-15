package com.sapient.lambdas;

import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;

// to show working of method references 
public class LambdaEx09 {
	public static void main(String[] args) {
		
		// in lambda way 
		IntFunction<String> intToString1 = num -> Integer.toString(num); 
		System.out.println("Expected Value 4 : " + 
				intToString1.apply(1234).length());
		
		// method reference 
		IntFunction<String> intToString = Integer :: toString;
		System.out.println("Expected Value 4 : " + 
		intToString.apply(1234).length()); 
		
		Consumer<String> print = System.out :: println;
		print.accept("Hello How are you");
		
		// constructor
		Function<String, BigInteger> newBigInt = BigInteger :: new; 
		System.out.println(newBigInt.apply("123456"));
		
		
	}
}
