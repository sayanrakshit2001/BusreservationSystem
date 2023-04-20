package com.qualtechedge.BusreservationSystem.databaseoperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class Insertdboperation {
	 public void insert(String sql,ArrayList<String> list) {
		 int u=-1;
		 try {
	    	 Dbconnect db = new Dbconnect(); 
	 		 Connection con = db.connection();
	 		 Statement stmt = con.createStatement();
	     	 PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	         //stmt.execute("insert into registration(First_Name,Last_Name,Email,Password,Confirm_Password,Phone_Num,Address,DOB,Pin) values('"+f_name+"','"+l_name+"','"+email+"','"+pass+"','"+cpass+"','"+ph+"','"+adds+"','"+dob+"','"+pin+"',')");
		     int i=0; 
		     
	     	 ArrayList<String> l = list;
	     	for(int j=1;j<=list.size();j++) {
	     		pstmt.setString(j,l.get(i++));
	     	 }
		    	 pstmt.executeUpdate();
		    	 ResultSet rs = pstmt.getGeneratedKeys();
			    	if(rs.next()) {
			    		u = rs.getInt(1);
			    		 System.out.println("Your User Id is : "+rs.getInt(1));
			    	 }
			    	stmt.execute("insert into profile(User_Id,First_Name,Last_Name,Email_id,Phone_No,Address,DOB,Pincode) values('"+u+"','"+l.get(0)+"','"+l.get(1)+"','"+l.get(2)+"','"+l.get(4)+"','"+l.get(5)+"','"+l.get(6)+"','"+l.get(7)+"')");
		 		 
		      }catch(Exception e) {
		    	  System.out.println(e);
		      }
	 }
	  public void update() {
		  Connection con = null;
		  try {
   		  Dbconnect db = new Dbconnect(); 
   	 	  con = db.connection(); 
   	 	 Scanner sc = new Scanner(System.in);
   	 	 System.out.println("Enter your User Id : ");
  		     int u = sc.nextInt();
   	  while(true) {
   		  System.out.println("Which field you want to update : ");
   		  
   		  System.out.println("Press 1 for First_Name");
   		  
   		  System.out.println("Press 2 for Last_Name");
   		  
   		  System.out.println("Press 3 for Email");
   		  
   		  System.out.println("Press 4 for Password");
   		  
   		  System.out.println("Press 5 for Phone Number");
   		  
   		  System.out.println("Press 6 for Address");
   		  
   		  System.out.println("Press 7 for Date of Birth");
   		  
   		  System.out.println("Press 8 for Pin code");
   		  int ans = sc.nextInt();
   		  switch(ans) {
   		  case 1:
   			  System.out.println("enter your updated first name");
   			  String fn = sc.next();
   			  sc.nextLine();
   			  String a = "update registration set First_Name = ? where User_Id = ?";
   			  PreparedStatement psmt = con.prepareStatement(a);
   			  psmt.setString(1, fn);
   			  psmt.setInt(2, u);
   			  psmt.executeUpdate();
   			  break;
   		  case 2:
   			  System.out.println("enter your updated Last name");
   			  String ln = sc.next();
   			  sc.nextLine();
   			  String b = "update registration set Last_Name = ? where User_Id = ?";
   			  PreparedStatement pmt = con.prepareStatement(b);
   			  pmt.setString(1, ln);
   			  pmt.setInt(2, u);
   			  pmt.executeUpdate();
   			  break;
   		  case 3:
   			  System.out.println("enter your updated Email_id");
   			  String em = sc.next();
   			  sc.nextLine();
   			  String c = "update registration set Email_id = ? where User_Id = ?";
   			  PreparedStatement pt = con.prepareStatement(c);
   			  pt.setString(1, em);
   			  pt.setInt(2, u);
   			  pt.executeUpdate();
   			  break;
   		  case 4:
   			  System.out.println("enter your updated Password");
   			  String pw = sc.next();
   			  sc.nextLine();
   			  String d = "update registration set Password = ? where User_Id = ?";
   			  PreparedStatement p = con.prepareStatement(d);
   			  p.setString(1, pw);
   			  p.setInt(2, u);
   			  p.executeUpdate();
   			  break;
   		  case 5:
   			  System.out.println("enter your updated Phone Num");
   			  String phn = sc.next();
   			  sc.nextLine();
   			  String e = "update registration set Phone_No = ? where User_Id = ?";
   			  PreparedStatement q = con.prepareStatement(e);
   			  q.setString(1, phn);
   			  q.setInt(2, u);
   			  q.executeUpdate();
   			  String x = "update login set Phone_No = ? where User_Id = ?";
   			  PreparedStatement y = con.prepareStatement(x);
   			  y.setString(1, phn);
   			  y.setInt(2, u);
   			  y.executeUpdate();
   			  break;
   		  case 6:
   			  System.out.println("enter your updated Address");
   			  String add = sc.next();
   			  sc.nextLine();
   			  String f = "update registration set Address = ? where User_Id = ?";
   			  PreparedStatement r = con.prepareStatement(f);
   			  r.setString(1, add);
   			  r.setInt(2, u);
   			  r.executeUpdate();
   			  break;
   		  case 7:
   			  System.out.println("enter your updated Date of Birth");
   			  String dob = sc.next();
   			  sc.nextLine();
   			  String g = "update registration set DOB = ? where User_Id = ?";
   			  PreparedStatement s = con.prepareStatement(g);
   			  s.setString(1, dob);
   			  s.setInt(2, u);
   			  s.executeUpdate();
   			  break;
   		  case 8:
   			  System.out.println("enter your updated Pin");
   			  String pn = sc.next();
   			  sc.nextLine();
   			  String h = "update registration set Pincode = ? where User_Id = ?";
   			  PreparedStatement i = con.prepareStatement(h);
   			  i.setString(1, pn);
   			  i.setInt(2, u);
   			  i.executeUpdate();
   			  break;
   		  default:
   			  System.out.println("you choose nothing");
   			  break;
   		  }
   		  System.out.println("You want to update more field...yes or no");
   		  String st = sc.next();
   		  if(st.equalsIgnoreCase("yes")) {
   			  continue;
   		  }else {
   			  break;
   		  }
   	  }
      }catch(Exception e) {
   	   System.out.println(e);
      }
	  } 
	  public void delete() {
		  try {
			  Scanner sc = new Scanner(System.in);
			   System.out.println("Enter your User_Id number");
			   int u = sc.nextInt();
			   System.out.println("Enter your phone number");
			   String st = sc.next();
			  Dbconnect db = new Dbconnect(); 
		 		 Connection con = db.connection();
		 		 Statement stmt = con.createStatement();
		 		stmt.execute("delete from login Where user_id='"+u+"' and '"+st+"'"); 
		 		stmt.execute("delete from registration Where user_id='"+u+"' and '"+st+"'"); 
		  }catch(Exception e) {
			  System.out.println(e);
		  }
	  }
	  }

