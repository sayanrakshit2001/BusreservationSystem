// This is for login.



package com.qualtechedge.BusreservationSystem.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.qualtechedge.BusreservationSystem.databaseoperation.Dbconnect;
import com.qualtechedge.BusreservationSystem.profile.Show_Profile;

public class Login {
	static Logger log=Logger.getLogger(Main.class.getName());
	   public void logIn() {
		   Connection con = null;
		   try {
			   String p = "";String a = "" , ot = null , d = "";
			   boolean b ;
			   Scanner sc = new Scanner(System.in);
			   Dbconnect db = new Dbconnect(); 
			   con = db.connection();
				Statement stmt = con.createStatement();
			   System.out.println("Enter your User_Id number");
			  log.info("Enter your User_Id number to login");
			   int u = (sc.nextInt());
			    log.info(u);
			   System.out.println("Enter your phone number");
			   log.info("Enter your phone number to login");
			   String st = sc.next();
			   
			   
				   String sql = "select Phone_No from registration where User_Id = '"+u+"'";
				   ResultSet r = stmt.executeQuery(sql);
				    if(r.next()) {
				    	a = r.getString("Phone_No");
				    }
				    if(!a.equals(st)) {
				    	System.out.println("Enter right phone number...");
				    	System.out.println("Forget phone number...yes or no");
				    	String ans = sc.next();
				    	if(ans.equalsIgnoreCase("yes")) {
				    		String h = "select Phone_No from login where User_Id = '"+u+"'";
				    		ResultSet sr = stmt.executeQuery(h);
				    		if(sr.next()) {
				    			ot = sr.getString("Phone_No");
				    		}
				    		System.out.println("enter your updated Phone Num");
				    		log.info("Enter updated phone number to login");
			    			  String phn = sc.next();
			    			  sc.nextLine();
				    		if(!(ot==null)) {
				    		
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
			    			  String px = "update profile set Phone_No = ? where User_Id = ?";
			    			  PreparedStatement y1 = con.prepareStatement(px);
			    			  y1.setString(1, phn);
			    			  y1.setInt(2, u);
			    			  y1.executeUpdate();
			    			  System.out.println("your phone number updated successfully");
			    			  log.info("your phone number updated successfully");
						    	System.out.println("Enter your password");
						    	log.info("Enter your password");
								   String pass = sc.next();
								   
									String q1 = "select Password from registration where User_Id = '"+u+"'";
									ResultSet  rs =  stmt.executeQuery(q1);
									if(rs.next()) {
										 p = rs.getString("Password");
									}
									Forgetpassword cv = new Forgetpassword();
									if(!p.equals(pass)) {
										cv.forget();
									}else {
								         b = (stmt.execute("insert into login values('"+u+"','"+phn+"','"+pass+"')"));
									
//									System.out.println(b);
									if(!b) {
										System.out.println("you are logged in");
										log.info("you are logged in");
									}
								}
				    		}
				    		else {
				    			String e = "update registration set Phone_Num = ? where User_Id = ?";
				    			  PreparedStatement q = con.prepareStatement(e);
				    			  q.setString(1, phn);
				    			  q.setInt(2, u);
				    			  q.executeUpdate();
				    			  String px = "update profile set Phone_Num = ? where User_Id = ?";
				    			  PreparedStatement y1 = con.prepareStatement(px);
				    			  y1.setString(1, phn);
				    			  y1.setInt(2, u);
				    			  y1.executeUpdate();
			    			  System.out.println("your phone number updated successfully");
			    			 log.info("your phone number updated successfully");
			    			  d = phn;
						    	System.out.println("Enter your password");
								   String pass = sc.next();
								   
									String q2 = "select Password from registration where User_Id = '"+u+"'";
									ResultSet  rs =  stmt.executeQuery(q2);
									if(rs.next()) {
										 p = rs.getString("Password");
									}
									Forgetpassword cv = new Forgetpassword();
									if(!p.equals(pass)) {
										cv.forget();
									}else {
								         b = (stmt.execute("insert into login values('"+u+"','"+d+"','"+pass+"')"));
									
//									System.out.println(b);
									if(!b) {
										System.out.println("you are logged in");
										log.info("you are logged in");
									}
								}
			    			  
				    		}
			    			  
				    	}
				    }if(a.equals(st)) {
				    	System.out.println("Enter your password");
				    	log.info("Enter your password");
						   String pass = sc.next();
						   
							String q = "select Password from registration where User_Id = '"+u+"'";
							ResultSet  rs =  stmt.executeQuery(q);
							if(rs.next()) {
								 p = rs.getString("Password");
							}
							Forgetpassword cv = new Forgetpassword();
							if(!p.equals(pass)) {
								cv.forget();
							}else {
						         b = (stmt.execute("insert into login values('"+u+"','"+st+"','"+pass+"')"));
							
//							System.out.println(b);
							if(!b) {
								System.out.println("you are logged in");
								log.info("you are logged in");
							}
						}
				    }
				    Show_Profile  pf = new Show_Profile();
				pf.showProfile(u);
			
		   }catch(Exception e) {
			   System.out.println(e);
		   }

	   }
	}