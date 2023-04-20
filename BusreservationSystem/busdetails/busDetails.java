package com.qualtechedge.BusreservationSystem.busdetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.qualtechedge.BusreservationSystem.databaseoperation.Dbconnect;

public class busDetails {
    public void BusDetails(String source,String destination) {
    	Connection con = null;
    	try {
    		Dbconnect db = new Dbconnect(); 
       	 con = db.connection();
    		 Statement stmt = con.createStatement();
    		 String sql = "select * from busdetails where starting_from = '"+source+"' and destination = '"+destination+"'";
    		 ResultSet rs = stmt.executeQuery(sql);
    		
    		 if(rs.next()) {
    			 String s = rs.getString("starting_from");
    			 
    			String d = rs.getNString("destination");
    			 String bn = rs.getNString("bus_No");
    			 String dep = rs.getString("departure");
    			 String dis = rs.getString("distance");
//   			 System.out.println("Start");
                 System.out.println(s+" "+d+" "+bn+" "+dep+" "+dis);
    		 }else {
    			 System.out.println("There is no bus in this route...");
    		 }
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
}
