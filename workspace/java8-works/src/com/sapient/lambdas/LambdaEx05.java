package com.sapient.lambdas;

import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class LambdaEx05 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<500; i++) {
					System.out.println("i value is " + i +" in " + Thread.currentThread().getName());
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start(); 
		
		// in lambda way 
		new Thread ( () ->  {
			IntStream.range(0, 100).forEach((t) -> System.out.println(t));
		}).start(); 
		
	
}
}