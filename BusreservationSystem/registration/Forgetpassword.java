package com.qualtechedge.BusreservationSystem.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.qualtechedge.BusreservationSystem.databaseoperation.Dbconnect;

public class Forgetpassword{
		

	public void forget() {
		Connection con = null;
		try {
		Dbconnect db = new Dbconnect(); 
  	 	con = db.connection(); 
		Scanner sc = new Scanner(System.in);
		System.out.println("Wrong password...");
		System.out.println("you want to change your password...yes or no");
		
		String ans = sc.next();
		if(ans.equalsIgnoreCase("yes")) {
		System.out.println("enter your User_Id : ");
		int u = sc.nextInt();
		System.out.println("enter your new password : ");
		String pw = sc.next();
		String d = "update registration set Password = ? where User_Id = ?";
		  PreparedStatement p = con.prepareStatement(d);
		  p.setString(1, pw);
		  p.setInt(2, u);
		  p.executeUpdate();
			String e = "update login set Password = ? where User_Id = ?";
			  PreparedStatement q = con.prepareStatement(e);
			  q.setString(1, pw);
			  q.setInt(2, u);
			  q.executeUpdate();
			  System.out.println("your password changed successfully");
		}else {
			System.out.println("you can not log in");
			System.out.println("Pleasr try again..");
			Login lg = new Login();
			lg.logIn();
		} 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
