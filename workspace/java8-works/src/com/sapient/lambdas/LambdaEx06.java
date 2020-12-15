package com.sapient.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaEx06 {
	public static void main(String[] args) {
		List<Account> list = Arrays.asList(
				new Account(123, 8787, "Rahul", "male"), 
				new Account(554, 3500, "Shweta", "female"), 
				new Account(43, 1234, "Pawan", null), 
				new Account(44, 4321, "Sandeep", "male"), 
				new Account(666, 5566, null, "male"), 
				new Account(168, 7894, "Rohit", "male"), 
				new Account(45, 8366, "Chaitra", "female") 
		); 
		/*
		List<Account> onlyMaleList = AccountPredicate.filterAccounts(list, AccountPredicate.onlyMale());
		System.out.println("-------- only male-----------");
		onlyMaleList.forEach(System.out :: println);
		
		System.out.println("------- with more than 5000 ---------- ");
		
		List<Account> onBalanceCheckList 
				= AccountPredicate.filterAccounts(list, AccountPredicate.onBalanceCheck(5000));
		
		onBalanceCheckList.forEach(System.out ::println);
		
		// only male and more than 5000 ???? 
		
		Predicate<Account> onlyMaleAndBalanceCheckPredicate 
				= AccountPredicate.onlyMale().and(AccountPredicate.onBalanceCheck(5000)); 
		
		List<Account> onlyMaleAndBalanceCheckList 
				= AccountPredicate.filterAccounts(list, onlyMaleAndBalanceCheckPredicate); 
		
		System.out.println("----- only male & over 5000 -------------");
		onlyMaleAndBalanceCheckList.forEach(System.out :: println);
		
		// only female but dont create a predicate 
		
		System.out.println("---- only female (negage of male)---------");
		Predicate<Account> onlyFemale = AccountPredicate.onlyMale().negate(); 
		System.out.println(AccountPredicate.filterAccounts(list, onlyFemale)); 
		
		// comparing multiple fields 
		
		System.out.println("****************************************************");
		 Comparator<Account> orderBySexByBalance = 
				 								   Comparator.comparing(Account :: getSex)
									.thenComparing(Comparator.comparing(Account :: getBalance)); 
		
		 list.sort(orderBySexByBalance);
		 list.forEach(System.out :: println);
		 */ 
		
		 /// printing null first sex 
		
		Comparator<Account> nullsFirstSex= 
				Comparator.comparing(Account :: getSex, 
				Comparator.nullsFirst(Comparator.naturalOrder())); 
		
		
//		 Comparator<Account> nullsFirstSex = Comparator.nullsFirst(Comparator.comparing(Account:: getSex));
		
		
		 list.sort(nullsFirstSex);
		 list.forEach(System.out:: println);
	}
	
	// List of predicates goes here 
	private static class AccountPredicate {
		static Predicate<Account> onlyMale() {
			return p -> p.getSex().equals("male"); 
		}
		
		static Predicate<Account> onBalanceCheck(double balance) {
			return p -> p.getBalance() > balance; 
		}
		
		// based on the predicates filter 
		static List<Account> filterAccounts (List<Account> accounts, Predicate<Account> predicate) {
			return accounts.stream().filter(predicate).collect(Collectors.<Account>toList()); 
		}
		
		
	} 
	
	
	
	
	
}
