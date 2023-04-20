package com.qualtechedge.BusreservationSystem.databaseoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.ResourceBundle;

public class Dbconnect {
	Connection con;
 /*public Connection connection() {
     	
	     try {
	     Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","Sayan@2001");
	    	// con = DriverManager.getConnection(rs.getString("com.qualtechedge.BusReservationSystem.db.url"),rs.getString("com.qualtechedge.BusReservationSystem.db.userid"),rs.getString("com.qualtechedge.BusReservationSystem.db.password"));
	    	
	    	 //System.out.println("connection established");
	    	 
	    	
	     }catch(Exception e) {
	    	 System.out.println(e);
	     }
	     return con;
    }
}*/


	 ResourceBundle rb=ResourceBundle.getBundle("com.qualtechedge.BusreservationSystem.resource.application",Locale.US);
   
        public Connection connection() {
        	
		     try {
		     Class.forName(rb.getString("com.qualtechedge.BusReservationSystem.db.class"));
		    // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","Sayan@2001");
		    	 con = DriverManager.getConnection(rb.getString("com.qualtechedge.BusReservationSystem.db.url"),rb.getString("com.qualtechedge.BusReservationSystem.db.userid"),rb.getString("com.qualtechedge.BusReservationSystem.db.password"));
		    	
		    	 //System.out.println("connection established");
		    	 
		    	
		     }catch(Exception e) {
		    	 System.out.println(e);
		     }
		     return con;
        }
	}

