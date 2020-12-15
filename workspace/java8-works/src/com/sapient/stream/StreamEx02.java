package com.sapient.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamEx02 {
	public static void main(String[] args) 
				throws FileNotFoundException, IOException {
		try (
			FileReader fr = new FileReader("sample.txt"); 
			BufferedReader br = new BufferedReader(fr);
		) {
			br.lines().forEach(System.out :: println);
		}
		
		System.out.println("--------------------------------");
		
		try (Stream<String> st = Files.lines(Paths.get("sample.txt"))) {
			st.forEach(System.out :: println);
		}
	}
}
