//This is for book bus.


package com.qualtechedge.BusreservationSystem.ticketbooking;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.qualtechedge.BusreservationSystem.busdetails.busDetails;
import com.qualtechedge.BusreservationSystem.databaseoperation.Dbconnect;

public class Booking {
		 Scanner sc = new Scanner(System.in);
		 busDetails bd=new busDetails();
	    public void ticketBooking() {
	    	System.out.println("Choose your journey start from : ");
	    	String stat = sc.next();
	    	System.out.println("Choose your destination : ");
	    	String desti = sc.next();
	    	System.out.println("Enter your departure date : YYYY:MM:DD");
	    	String dat = sc.next();
	    	try {
	    		Dbconnect db = new Dbconnect(); 
	       	 Connection con = db.connection();
	    	 Statement stmt = con.createStatement();
	   
	    	System.out.println("Enter number of passenger : ");
	    	int t = sc.nextInt();
	    	System.out.println("Enter number of male passenger : ");
	    	int m = sc.nextInt();
	    	System.out.println("Enter number of female passenger : ");
	    	int f = sc.nextInt();
	    	String sql = "insert into booking values('"+stat+"','"+desti+"','"+dat+"','"+t+"','"+m+"','"+f+"')";
	    	stmt.execute(sql);
	    	System.out.println("Available bus for you : ");
	    	bd.BusDetails(stat, desti);
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    }
	}
