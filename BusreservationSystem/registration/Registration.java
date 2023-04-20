//This is for Registration.

package com.qualtechedge.BusreservationSystem.registration;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.qualtechedge.BusreservationSystem.checkvalidation.Validation;
import com.qualtechedge.BusreservationSystem.databaseoperation.Insertdboperation;

public class Registration {
	 ResourceBundle rb=ResourceBundle.getBundle("com.qualtechedge.busreservationProject.resource.sql",Locale.US);
	 public void register() {
    	Validation cv=new Validation();
    	//Validation cv=null;
    	
    	//System.out.println(cv instanceof Validation);
    	
		 Scanner sc = new Scanner(System.in);
		 ArrayList<String> list = new ArrayList<>();
		 System.out.println("enter your first name:");
     	 list.add(sc.nextLine());
     	 System.out.println("enter your Last name:");
     	 list.add(sc.nextLine());
     	 System.out.println("enter your email_id:");
     	 list.add(sc.nextLine());
     	 System.out.println("enter your Password:");
     	 list.add(sc.nextLine());
     	System.out.println("enter your Phone number:");
     	String ph = sc.next();
     	while(true) {
     	if(cv.phnValidation(ph)) {
     		if(!cv.existingPhn(ph)) {
     			list.add(ph);
     			break;
     		}
     		else {
     			System.out.println("Excisting user,Please try another number");
     			ph=sc.next();
     			
     		}
     		list.add(ph);
     		break;
     	}else {
     	 	System.out.println("please try again...");
     	 	ph = sc.next();
     	}
     	}
        	 System.out.println("enter your Address:");
        	 list.add(sc.next());
        	 sc.nextLine();
        	 System.out.println("enter your date of birth:");
        	 list.add(sc.nextLine());
        	 System.out.println("enter your pincode:");
        	 list.add(sc.nextLine());
        	
        	 Insertdboperation db = new Insertdboperation();
        	 
        	 String sql = rb.getString("com.qualtechedge.resource.registration.sql.query")+ "values(?,?,?,?,?,?,?,?)";
        	 db.insert(sql,list);
           
//      //	String sql= "insert into registration(First_Name,Last_Name,Email_id,Password,Confirm_Password,Phone_No,Address,DOB,Pincode) values('"+f_name+"','"+l_name+"','"+email+"','"+pass+"','"+cpass+"','"+ph+"','"+adds+"','"+dob+"','"+pin+"')";
//            Insertdboperation idb=new Insertdboperation(); 
//          	 idb.insert(sql);
//          	 
// }
////       	if(rs.next()) {
////	    		 System.out.println("Your User Id is : "+rs.getInt(1));
////	    	 }
////  	 }else {
////  		 System.out.println("enter same pasword");
////  	 }
           	 //String sql = "insert into registration(First_Name,Last_Name,Email_id,Password,Confirm_Password,Phone_No,Address,DOB,Pincode) values(?,?,?,?,?,?,?,?,?)";
           	// PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
   	    	 //stmt.execute("insert into registration(First_Name,Last_Name,Email,Password,Confirm_Password,Phone_Num,Address,DOB,Pin) values('"+f_name+"','"+l_name+"','"+email+"','"+pass+"','"+cpass+"','"+ph+"','"+adds+"','"+dob+"','"+pin+"',')");
   	    	// pstmt.setString(1,f_name);
   	    	// pstmt.setString(2,l_name);
   	    	// pstmt.setString(3,email);
   	    	// pstmt.setString(4,pass);
   	    	// pstmt.setString(5,cpass);
   	    	//pstmt.setString(6,ph);
   	    	//pstmt.setString(7,adds);
   	    	//pstmt.setString(8,dob);
   	    	//pstmt.setString(9,pin);
   	    	//int i = pstmt.executeUpdate();
   	    	// System.out.println(i+" "+"data inserted");
   	    	// ResultSet rs = pstmt.getGeneratedKeys();*/
           	 
   	    	 /**/
           	
//   	 }catch(Exception e) {
//   		 System.out.println(e);
 	 }
	 }



/*CREATE TABLE REGISTRATION (USER_NAME VARCHAR2(20),
FIRST_NAME VARCHAR2(255),
LAST_NAME VARCHAR2(255),
PASSWORD VARCHAR2(20),
CONFIRM_PASSWORD VARCHAR2(20),
EMAIL_ID VARCHAR2(30),
PHONE_NO NUMBER(15) PRIMARY KEY,
ADDRESS VARCHAR2(20),
DOB VARCHAR2(15),
PINCODE NUMBER(7),
CREATED_DATE VARCHAR2(20),
UPDATED_DATE VARCHAR2(20)
)*/