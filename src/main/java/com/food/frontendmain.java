package com.food;

import java.util.Scanner;

public class frontendmain {

	public static void main(String[] args) {
		CrudOperations m2=new CrudOperations();
		System.out.println("**************************************************");
		System.out.println("**************************************************");
		System.out.println("*******Welcome to Kitchen story******************");
		System.out.println("**************************************************");
		System.out.println("**************************************************");	
		
		System.out.println("Search for Item you want to purchase");
		Scanner scan=new Scanner(System.in);
		String ch=scan.nextLine();
		m2.searchFoodItems(ch);
		System.out.println("Enter S.No of item you want to purchase from above list");		
		int sno=scan.nextInt();
		System.out.println("Enter the quantity");
		int quantity=scan.nextInt();
		m2.PaymentGateway(sno, quantity);
		
		
	}

}
