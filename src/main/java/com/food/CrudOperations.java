package com.food;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class CrudOperations {
	
	public void Tables() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Food f1=new Food("salad",150);
		Food f2=new Food("bread",200);
		Food f3=new Food("burger",250);
		Food f4=new Food("chickenbirayani",350);
		Food f5=new Food("roti",90);
		Food f6=new Food("panipuri",10);
		Food f7=new Food("chillichicken",400);
		Food f8=new Food("chciken tikka",600);
		Food f9=new Food("butterchicken",560);
		Food f10=new Food("Fish",890);
		Food f11=new Food("Muttton fry",654);
		Food f12=new Food("Butternan",80);
		Food f13=new Food("Curd rice",189);
		
		session.save(f1);
		session.save(f2);
		session.save(f3);
		session.save(f4);
		session.save(f5);
		session.save(f6);
		session.save(f7);
		session.save(f8);
		session.save(f9);
		session.save(f10);
		session.save(f11);
		session.save(f12);
		session.save(f13);
		

		transaction.commit();
		session.close();
		factory.close();
		
	}
	
	public void insertItems() {
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
          
		System.out.println("Enter the food items to be added");
		Scanner scan=new Scanner(System.in);
		String ch=scan.nextLine();
		System.out.println("Enter the price of food item");
		
		int k=scan.nextInt();
		
		Food te1 = new Food(ch,k);
		session.save(te1);
		
		System.out.println("Updates items list is below");
        
        this.listFoodItems();
		
		
		transaction.commit();
		session.close();
		factory.close();
		
	}
	
	
	
	public void deleteitem() 
	{
		Connection connection=null;
		
		try {
			//Step1
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver Loaded");
			
			//Step2
			String url="jdbc:mysql://localhost:3306/phase-4";
			String username="root";
			String password="Unnathi_1998";
			connection=DriverManager.getConnection(url, username, password);
			//System.out.println("Connection Successful");
			this.listFoodItems();
			System.out.println("Enter the sno of food items to be deleted from above list");
			Scanner scan=new Scanner(System.in);
			int h=scan.nextInt();
			
			//Step3
			Statement statement=connection.createStatement();
			String q1 = "DELETE from food WHERE sno = '" + h +"'";
			
			
            int x = statement.executeUpdate(q1); 
			
            System.out.println("Updates items list is below");
            
            this.listFoodItems();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				//Step6
				connection.close();
				//System.out.println("Connection closed");
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	public void listFoodItems()
	{
		Connection connection=null;
		
		try {
			//Step1
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver Loaded");
			
			//Step2
			String url="jdbc:mysql://localhost:3306/phase-4";
			String username="root";
			String password="Unnathi_1998";
			connection=DriverManager.getConnection(url, username, password);
			//System.out.println("Connection Successful");
			
			//Step3
			Statement statement=connection.createStatement();
			String sql="select * from food";
			
			//Step4
			ResultSet resultSet=statement.executeQuery(sql);
			//System.out.println("Query executed");
			
			//Step5
			
			
			System.out.println("-----------------------------");
			System.out.println("\nFood Details are : ");
			System.out.println("-----------------------------");
			System.out.print("S.No\t"+" food Item\t"+" Price\t"+"\n");
			while(resultSet.next()) {
				
				System.out.print(resultSet.getInt("sno")+"\t\t"+resultSet.getString("fooditems")+"\t\t"+resultSet.getInt("price")+"\n");								
			}
			//System.out.println("Results Processed");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				//Step6
				connection.close();
				//System.out.println("Connection closed");
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	
	
	public String changepassword() {
		 boolean i=true;
		 String Newpwd="";
		while(i) {
			System.out.println("Enter the current password");
			Scanner scan=new Scanner(System.in);
			String pwd=scan.nextLine();
			
			if (pwd.equalsIgnoreCase("admin123")) 
			{
				System.out.println("Enter new password");
				String Newpwd1=scan.nextLine();
				System.out.println("your password has been changed successfully. New password is:"+Newpwd);
				i=false;
				Newpwd=Newpwd1;
				break;
			}
			else 
			{
				System.out.println("Entered password is Incorrect. Please try again");
				continue;
			}
		}

		
		return Newpwd;
		
	}

	public void searchFoodItems(String ch) {

		Connection connection=null;
		
		try {
			//Step1
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver Loaded");
			
			//Step2
			String url="jdbc:mysql://localhost:3306/phase-4";
			String username="root";
			String password="Unnathi_1998";
			connection=DriverManager.getConnection(url, username, password);
			//System.out.println("Connection Successful");
			
			//Step3
			Statement statement=connection.createStatement();
			String sql="select * from food WHERE fooditems = '" + ch +"'";
				
			
			//Step4
			ResultSet resultSet=statement.executeQuery(sql);
			//System.out.println("Query executed");
			
			//Step5
			System.out.println("-----------------------------");
			System.out.println("\nFood Details are : ");
			System.out.println("-----------------------------");
			System.out.print("S.No\t"+" food Item\t"+" Price\t"+"\n");
			while(resultSet.next()) {
				
				System.out.print(resultSet.getInt("sno")+"\t\t"+resultSet.getString("fooditems")+"\t\t"+resultSet.getInt("price")+"\n");								
			}
			//System.out.println("Results Processed");
			
		} 
		
		catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				//Step6
				connection.close();
				//System.out.println("Connection closed");
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}
	
	public int PriceFoodItems(int ch) {

		Connection connection=null;
		int price = 0;
		try {
			//Step1
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver Loaded");
			
			//Step2
			String url="jdbc:mysql://localhost:3306/phase-4";
			String username="root";
			String password="Unnathi_1998";
			connection=DriverManager.getConnection(url, username, password);
			//System.out.println("Connection Successful");
			
			//Step3
			Statement statement=connection.createStatement();
			String sql="select * from food WHERE sno = '" + ch +"'";
				
			
			//Step4
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
			price=resultSet.getInt("price");
			}
			//System.out.println("Query executed");
			
			//Step5
			
		} 
		
		catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				//Step6
				connection.close();
				//System.out.println("Connection closed");
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return price;
		
	}
	
	public String ItemFoodItems(int ch) {

		Connection connection=null;
		String item="";
		try {
			//Step1
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver Loaded");
			
			//Step2
			String url="jdbc:mysql://localhost:3306/phase-4";
			String username="root";
			String password="Unnathi_1998";
			connection=DriverManager.getConnection(url, username, password);
			//System.out.println("Connection Successful");
			
			//Step3
			Statement statement=connection.createStatement();
			String sql="select * from food WHERE sno = '" + ch +"'";
				
			
			//Step4
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
			item=resultSet.getString("fooditems");
			}
			
			//System.out.println("Query executed");
			
			//Step5
			
		} 
		
		catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				//Step6
				connection.close();
				//System.out.println("Connection closed");
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return item;
		
	}
	
	
	public void PaymentGateway(int sno, int qty) {
		
		System.out.println("**************************************************");
		System.out.println("******Payment Gateway Page******************");
		System.out.println("**************************************************");				
		int prices1=this.PriceFoodItems(sno)*qty;				
		float tax1=(float) (prices1*0.18);		
		float totalValue=(float) (prices1*1.18)+50;
		
		System.out.println("Order details");
		System.out.println("Item Name\t"+this.ItemFoodItems(sno));
		System.out.println("Quantity\t"+qty);
		System.out.println("Price\t"+prices1);
		System.out.println("Delivery Charges\t"+50);
		System.out.println("Taxes\t"+tax1);
		System.out.println("---------------------");
		System.out.println("Total Bill Amount=\t"+totalValue);
		System.out.println("---------------------");
		System.out.println("\nSelect from the below options");		
		 	System.out.println("1.Credit Card");
	        System.out.println("2.Debit Card");
			System.out.println("3.Net Banking");
		
			Scanner scan=new Scanner(System.in);
			int temp=scan.nextInt();
			
			switch(temp)
	        {  
				case 1:
				{
					System.out.println("Enter 16 digit credit card number");
					scan.nextLine();
					String c=scan.nextLine();
			        System.out.println("Enter expiry in MM/YY format ");
			        String exp=scan.nextLine();
					System.out.println("Enter CVV");
					int cvv=scan.nextInt();
					System.out.println("Do you want to make payment for Rs."+totalValue+" Yes/No");
					scan.nextLine();
					String cond=scan.nextLine();
					if(cond.equalsIgnoreCase("Yes")) {
						this.PaymentSuccess(totalValue);
					}
					else	
					{
						System.out.println("Transaction was cancelled");
					}
					break;
					
				}
				
				case 2:
				{
					System.out.println("Enter 16 digit debit card number");
					scan.nextLine();
					String c=scan.nextLine();
			        System.out.println("Enter expiry in MM/YY format ");
			        String exp=scan.nextLine();
					System.out.println("Enter CVV");
					int cvv=scan.nextInt();
					System.out.println("Do you want to make payment for Rs."+totalValue+" Yes/No");
					scan.nextLine();
					String cond=scan.nextLine();
					if(cond.equalsIgnoreCase("Yes")) {
						this.PaymentSuccess(totalValue);
					}
					else	
					{
						System.out.println("Transaction was cancelled");
					}
					break;
					
				}
				
				case 3:
				{
					System.out.println("Enter username");
					scan.nextLine();
					String c=scan.nextLine();
			        System.out.println("Enter password ");
			        scan.nextLine();
			        String exp=scan.nextLine();
				
					System.out.println("Do you want to make payment for Rs."+totalValue+" Yes/No");
					scan.nextLine();
					String cond=scan.nextLine();
					if(cond.equalsIgnoreCase("Yes")) {
						this.PaymentSuccess(totalValue);
					}
					else	
					{
						System.out.println("Transaction was cancelled");
					}
					break;
					
				}
	        }
		
	}
	
public void PaymentSuccess(float totval) {
		Random rand = new Random();
		int rand_int1 = rand.nextInt(10);
		int rand_int2 = rand.nextInt(10);
		int rand_int3 = rand.nextInt(10);
		int rand_int4 = rand.nextInt(10);
		int rand_int5 = rand.nextInt(10);
		
		String s=Integer.toString(rand_int1)+Integer.toString(rand_int2)+Integer.toString(rand_int3)+Integer.toString(rand_int4)+Integer.toString(rand_int5);
		
		
		System.out.println("**************************************************");
		System.out.println("******Payment Success page**********");
		System.out.println("**************************************************");				
				
		System.out.println("\nPayment of Rs."+totval+" was successful");
		System.out.println("Your Order Number is "+s);
		
	}
	
	


}
