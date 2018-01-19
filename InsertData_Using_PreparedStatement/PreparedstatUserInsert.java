package org.com.java.jdbc;
import java.sql.*;  
import java.io.*; 
public class PreparedstatUserInsert {
	
	 // Oracle Driver. 
	 
	public static void main(String args[])throws Exception{  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","2701");
	  //                                        ("--------------URL--------------------","Username","Password"); 
	PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");  
	  
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
	  
	do{  
	System.out.println("enter studentid:");  
	int studentid=Integer.parseInt(br.readLine());  
	System.out.println("Enter Student Name:");  
	String name=br.readLine();  
	System.out.println("enter Student age:");  
	int age=Integer.parseInt(br.readLine());  
	  
	ps.setInt(1,studentid);  
	ps.setString(2,name);  
	ps.setInt(3,age);  
	int i=ps.executeUpdate();  
	System.out.println(i+" records affected");  
	  
	System.out.println("Do you want to continue: y/n");  
	String s=br.readLine();  
	if(s.startsWith("n")){  
	break;  
	}  
	}while(true);  
	  
	con.close();  
	}}


