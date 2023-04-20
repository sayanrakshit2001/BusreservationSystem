//This is for main class.

package com.qualtechedge.BusreservationSystem.registration;
import org.apache.log4j.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.qualtechedge.BusreservationSystem.databaseoperation.Insertdboperation;

public class Main {
	static Logger log=Logger.getLogger(Main.class.getName());

	static ResourceBundle rb=ResourceBundle.getBundle("com.qualtechedge.BusreservationSystem.resource.application",Locale.US);
	public static void main(String[] args) {
		String log4j=rb.getString("com.qualtechedge.BusReservationSystem.resource.log4j");
	PropertyConfigurator.configure(log4j);
		log.info("Successful");
	  //log.error("this is error");
		//log.debug("debugging");
		Insertdboperation dele=new Insertdboperation();
		Scanner sc = new Scanner(System.in);
		System.out.println("You are new user user..yes or no");
		log.info("You are new user user..yes or no");
		//log.error("this is error");
		
		String ans = sc.next();
		if(ans.equalsIgnoreCase("no")) {
		Login lg=new Login();
			lg.logIn();			
//			System.out.println("are you want to update your account??");
//			Insertdboperation up=new Insertdboperation();
//	           String n = sc.next();
//	           if(n.equalsIgnoreCase("yes")) {
//	        	   up.update();
//	          }
	       System.out.println("Are you want to delete your account?");
	   		String del=sc.next();
	   		sc.nextLine();
	   		if(del.equalsIgnoreCase("yes")) {
	   			dele.delete();
	   		}
		}else {
			
		Registration a = new Registration();
		a.register();
		System.out.println("You are registred please log in");
		Login l = new Login();
		l.logIn();
		}
		}
	}


