package com.food;

import java.util.Scanner;



public class Main {

public static void main(String[] args) {
		
		CrudOperations m2=new CrudOperations();
		String password="admin123";
			//m2.Tables();
			boolean again=true;
		      while(again) 
		      {
				System.out.println("**************************************************");
				System.out.println("**************************************************");
				System.out.println("*******Welcome to Kitchen story******************");
				System.out.println("**************************************************");
				System.out.println("**************************************************");	          		
			    while(true){
			    	
			    	        System.out.println("Enter username");
			    
			    	        Scanner scan=new Scanner(System.in);
			    	        
			    	       	String u=scan.nextLine();
			    	       	System.out.println("Enter password");
			    	       	String z=scan.nextLine();
			    	       	
			    	       	if(u.equals("admin123") && z.equals(password)) {
			    	       		System.out.println("You have logged in successfully as admin");
			    	       		break;
			    	       		}
			    	       	    
			    	       	else
			    	       		System.out.println("retry again ");
			    }
			    
			    
				
				
		        
		        System.out.println("Please select from the below options"); 
		        System.out.println("--------------------------------------");
		        System.out.println("1.List fooditems");
		        System.out.println("2.Add fooditems");
				System.out.println("3.delete food items");
				System.out.println("4.Change login password");
			
				
		        
		        Scanner scan=new Scanner(System.in);
		        int option=scan.nextInt();
		        System.out.flush(); 
		        switch(option)
		        {  
		        	
						 
			             
		        	
		        	case 1:
		        	{
		        		
		               m2.listFoodItems();
		        		break;
		        		
		        	}
		        	
		        	case 2:
					{
		             
		        		m2.insertItems();
		        		
		        		break;
					}
					
		        	case 3:
		        	{
		        	     m2.deleteitem();
		        		 break;
		        	}
		        	
		        	
		        	case 4:
		        	{
		        		     password=m2.changepassword();
		        		     
		        	}
		      }
		       
	    		
	    		System.out.println("Do you want to continue again Y or N??");
		        
		        scan.nextLine();
		        String temp=scan.nextLine();
		        if (temp.equalsIgnoreCase("Y"))
		        	again=true;
		        else
		        	again=false;
		      
	}
		      System.out.println("Thanks for using the application");
	    		System.exit(0);
}

}
