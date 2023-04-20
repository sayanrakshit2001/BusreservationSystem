//This is for Showing profile.


package com.qualtechedge.BusreservationSystem.profile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.qualtechedge.BusreservationSystem.databaseoperation.Dbconnect;
import com.qualtechedge.BusreservationSystem.databaseoperation.Insertdboperation;
import com.qualtechedge.BusreservationSystem.ticketbooking.Booking;

public class Show_Profile {

	  public void showProfile(int u) {
		  Scanner sc = new Scanner(System.in);
		  Connection con = null; 
		  Insertdboperation ud = new Insertdboperation();
		  try {
			  Dbconnect db = new Dbconnect(); 
		  	  con = db.connection(); 
		  	Statement stmt = con.createStatement();
		  	String sql = "select User_Id,First_Name,Last_Name,Email_id,Phone_No,Address,DOB,Pincode from profile where User_Id = '"+u+"'";
		  	ResultSet result = stmt.executeQuery(sql);
		  	while(result.next()) {
		  		int user = result.getInt("User_Id");
		  		String fn = result.getString("First_Name");
		  		String ln = result.getString("Last_Name");
		  		String em = result.getString("Email_id");
		  		String ph = result.getString("Phone_No");
		  		String add = result.getString("Address");
		  		String dob = result.getString("DOB");
		  		String pn = result.getString("Pincode");
		  		System.out.println("Welcome"+" "+fn);
//		  		System.out.println("User_Id First_Name Last_Name Email Phone_Num Address DOB Pin");
		  		System.out.println(user+" "+fn+" "+ln+" "+em+" "+ph+" "+add+" "+dob+" "+pn);
		  		
		  	}
		  	System.out.println("You want to update your profile...");
		  	String a = sc.next();
		  	if(a.equalsIgnoreCase("yes")) {
		  		ud.update();
		  	}else {
		  		System.out.println("You want to booked ticket");
		  		Booking bk = new Booking();
		  		if(sc.next().equalsIgnoreCase("yes"))
			  		bk.ticketBooking();
		  	}
		  }catch(Exception e) {
			  System.out.println(e);
		  }
	  }
	}

