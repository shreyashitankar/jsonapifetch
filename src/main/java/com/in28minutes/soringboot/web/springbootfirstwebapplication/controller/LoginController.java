package com.in28minutes.soringboot.web.springbootfirstwebapplication.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class LoginController {
	
	//model => controller data to view
	
//	@RequestMapping("/login")
//	public String loginMessage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		return "login";
//	}
	
	
	
	@RequestMapping("/fetchdata")
	public static String get(ModelMap model1) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT name,address FROM students");
			ResultSet result = statement.executeQuery();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			ArrayList<students> array = new ArrayList<students>();
			while(result.next()) {
				students std = new students();
				System.out.println(result.getString("name"));
				System.out.println(result.getString("address"));
				System.out.println(" ");
				String a= result.getString("name");
				String b= result.getString("address");
				std.setName(a);
				std.setAddress(b);
				
				array.add(std);
				System.out.println(array);
			}
			
			String response = gson.toJson(array);
			
			System.out.println("All records has been selected");
			System.out.println(response);
			model1.put("result",response);
			return "login";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return null;
		
	}
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "manager";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to database");
			
			return conn;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return null;
	}
}

