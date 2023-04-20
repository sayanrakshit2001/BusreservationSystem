package com.qualtechedge.BusreservationSystem.checkvalidation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.qualtechedge.BusreservationSystem.databaseoperation.Dbconnect;

public class Validation {
	public boolean existingPhn(String num) {
		Connection con = null;
		boolean b = false;
		try {
		Dbconnect db = new Dbconnect(); 
  	 	con = db.connection();
  	 	Statement stmt = con.createStatement();
  	 	String sql = "select Phone_No from registration where Phone_No = '"+num+"'";
  	 	ResultSet rs = stmt.executeQuery(sql);
  	 	b = rs.isBeforeFirst();
		}catch(Exception e) {
			System.out.println(e);
		}
		return b;
	}

	public boolean phnValidation(String ph) {
		if(ph.length()==10 && ph.charAt(0)!='0' && ph.charAt(0)!=' ') {
			for(int i=0;i<ph.length();i++) {
				if(ph.charAt(i)>=48 && ph.charAt(i)<=57) {
					continue;
				}
				else {
					System.out.println("enter numeric value only : ");
					return false;
				}
			}
		}
		else {
			System.out.println("enter right phone number : ");
			return false;
		}
		return true;
	}
}
