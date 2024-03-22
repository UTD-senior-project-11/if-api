/*
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.io.*;
import java.util.*;

@SpringBootApplication
public class DemoApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(Backend.class, args);
		
		try{
			//Establish connection
			String dbURL = "jdbc:mysql://localhost:3306/";
			String dbUser = "UTDesign";
			String dbPass = "UTDesign11";
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

			test(conn);

		} catch(Exception ex){
			System.out.println(ex);
		}
	}

	public static void test(Connection c){
		try{
			//Test 1: Insert basic tuples
			String adminTest1 = "INSERT INTO UTDesign11.Administrator VALUES ('123456789', 'TestUser1', 'TestUser1')";
			Statement stmt = c.createStatement();
			//stmt.executeUpdate(adminTest1);
			adminTest1 = "INSERT INTO UTDesign11.Administrator VALUES ('2', 'TestUser2', 'TestUser2')";
			//stmt.executeUpdate(adminTest1);

			//Test 2: Retrive basic tuples
			String adminTest2 = "SELECT AdminID, AdminUser, AdminPass FROM UTDesign11.Administrator";
			ResultSet rs = stmt.executeQuery(adminTest2);
			while(rs.next()){
				System.out.print(rs.getString("AdminID") + " | ");
				System.out.print(rs.getString("AdminUser") + " | ");
				System.out.println(rs.getString("AdminPass"));
			}

			//Test 3: Insert test image
			PreparedStatement pstmt = c.prepareStatement("INSERT INTO UTDesign11.Image VALUES(?,?,?,?)");
			pstmt.setString(1, "0");
			String fileLocation = "C:\\Users\\cobal\\OneDrive\\Desktop\\UT Dallas\\UTDesign Project\\if-api\\src\\main\\resources\\smileyface.jpg";
			InputStream in = new FileInputStream(fileLocation);
			pstmt.setBlob(2, in);
			pstmt.setString(3, "7.58");
			pstmt.setString(4, "TestUser1");
			//pstmt.execute();

			//Test 4: Retrieve test image
			fileLocation = "C:\\Users\\cobal\\OneDrive\\Desktop\\UT Dallas\\UTDesign Project\\if-api\\src\\main\\resources\\smileyface2.jpg";
			File testFile = new File(fileLocation);
			FileOutputStream fos = new FileOutputStream(testFile);
			byte b[];
			Blob blob;
			pstmt = c.prepareStatement("SELECT ImageData FROM UTDesign11.Image WHERE ImageID = '0'");
			rs = pstmt.executeQuery();
			while(rs.next()){
				blob = rs.getBlob("ImageData");
				b = blob.getBytes(1, (int)blob.length());
				fos.write(b);
			}
			pstmt.close();
			fos.close();
			c.close();

		} catch(Exception ex){
			System.out.println(ex);
		}
	}

}
*/