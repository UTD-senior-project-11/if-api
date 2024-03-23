package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.io.*;
import java.util.*;

@SpringBootApplication
public class Backend {

	public static void main(String[] args) {
		SpringApplication.run(Backend.class, args);

		try{
			//Establish connection
			String dbURL = "jdbc:mysql://mysql:3306/";
			String dbUser = "root";
			String dbPass = "test";
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

			/*
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO UTDesign11.Administrator VALUES (?, ?, ?)");
            	pstmt.setString(1, "123");
            	pstmt.setString(2, "hello");
            	pstmt.setString(3, "there");
            	pstmt.executeUpdate();
			*/

			//Create blank Account object
			Account userAccount = new Account();

		} catch(Exception ex){
			System.out.println(ex);
		}
	}

	//Create a new administrator account to manipulate the database
	public static void createAccount(Connection c, Account user){
		try{
			//Generate random administrator ID
			String newID = generateAdminID();

			//Validate new administrator ID
			PreparedStatement pstmt = c.prepareStatement("SELECT AdminID FROM UTDesign11.Administrator WHERE AdminID = ?");
			pstmt.setString(1, newID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				newID = generateAdminID();
				pstmt.setString(1, newID);
				rs = pstmt.executeQuery();
			}

			//Blank strings for user-entered values
			String enteredUser = "";
			String enteredPass = "";

			//Add connector to frontend to get values

			//Check for invalid characters and invalid length(REPLACE/MODIFY THIS)
			/*
			while(Pattern.matches("'", enteredUser) || Pattern.matches("'", enteredPass) || enteredUser.length() < 5 || enteredPass.length() < 5){
				System.out.print("Invalid Credentials");
				//Request new user/password
			}
			*/

			//Insert new administrator
			pstmt = c.prepareStatement("INSERT INTO UTDesign11.Administrator VALUES (?, ?, ?)");
			pstmt.setString(1, newID);
			pstmt.setString(2, enteredUser);
			pstmt.setString(3, enteredPass);
			pstmt.executeUpdate();

		} catch(Exception ex){
			System.out.println(ex);
		}
	}

	//Generate random string of numbers for an id
	//This can be modified to add letters as well
	public static String generateAdminID(){
		StringBuilder temp = new StringBuilder();
		String idCharSet = "0123456789";
		Random rand = new Random();
		int randIndex;
		
		for(int i = 0; i < 9; i++){
			randIndex = rand.nextInt(10);
			temp.append(idCharSet.charAt(randIndex));
		}
		
		String id = temp.toString();
		
		return id;
	}

	//Validate the login entered in the frontend
	public static void checkLogin(Connection c, Account user){
		try{
			//Blank strings for user-entered values
			String enteredUser = "";
			String enteredPass = "";
		
			//Add connector to frontend to get values

			//Validate entered login credentials (REPLACE/MODIFY THIS)
			/*
			while(Pattern.matches("'", enteredUser) || Pattern.matches("'", enteredPass)){
				System.out.print("Invalid Credentials");
				//Request login credentials
			}
			*/

			//Check database to see if administrator account is present; if so, store as Account
			PreparedStatement pstmt = c.prepareStatement("SELECT AdminUser, AdminPass from UTDesign11.Administrator WHERE AdminUser = ? AND AdminPass = ?");
			pstmt.setString(1, enteredUser);
			pstmt.setString(2, enteredPass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() == false){
				System.out.println("ERROR: Account Not Found");
				return;
			} else {
				user.setAccountUsername(rs.getString("AdminUser"));
				user.setAccountPassword(rs.getString("AdminPass"));
			}

		} catch(Exception ex){
			System.out.println(ex);
		}
	}

	public static void pullImageInfo(Connection c){
		try{
			
		} catch(Exception ex){
			System.out.println(ex);
		}
	}

	public static void sendImageAI(Connection c){
		try{
			//Insert some mumbo jumbo where it passes information to the AI subsystem to train it
		} catch(Exception ex){
			System.out.println(ex);
		}
	}

}
