package com.authenticate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


//@Controller
//@RequestMapping("/hello")
//public class LoginController{
// 
//   @RequestMapping(method = RequestMethod.GET)
//   public String printHello(ModelMap model) {
//      model.addAttribute("message", "Hello!!! <br> This is my First Web Apps using Spring MVC Framework!");
//
//      return "hello";
//   }
//
//}

/* 

@Controller
@RequestMapping("/hello")
public class LoginController{
        @RequestMapping(method = RequestMethod.POST)
        public String verifyLogin(@RequestParam String userId, @RequestParam String password, ModelMap model)
        {
                if(userId.equals("test") && password.equals("test"))
                {
                        model.addAttribute("message", "Welcome!!!");
                        return "hello";
                }
                else if(userId.equals(null) || password.equals(null) || userId.equals("") || password.equals(""))
                {
                        model.addAttribute("loginError", "Invalid User Name or Password");
                        return "failed";
                }
                return "auth";
        }

} 
*/



@Controller
@RequestMapping("/hello")
public class LoginController{
	@RequestMapping(method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userId, @RequestParam String password, ModelMap model)
	{
		if(userId.equals(null) || password.equals(null) || userId.equals("") || password.equals(""))
    	{
    		model.addAttribute("message", "Please enter valid User Name and Password");
    		return "failed";
    	}
		else if(userId!=null && password!=null )
		{
			Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        try
	        {
		        try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
		        	System.out.println("Driver is loaded");
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
		        try
		        {
		        	conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/detail", "root", "admin");
		        	System.out.println("Connection is created");
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
	        
		        String isUserExist = "SELECT * from detail.detail where USERID =  '" + userId + "' and PASSWORD = '" + password + "' ";
		        try
		        {
		        	stmt = conn.createStatement();
	                rs = stmt.executeQuery(isUserExist);
	                System.out.println("Query is executed");
	                if(rs.next()==true)
	                {
	                	String result = rs.getString("username");
	                	model.addAttribute("message", result);
	                	System.out.println("Valid user");
	                    return "hello";
	                }
	                else
	                {
	                	model.addAttribute("message", "Invalid Credential");
	                	System.out.println("Authentication Failed");
	                	return "failed";
	                }
		        }
		        catch(SQLException e)
		        {
		        	e.printStackTrace();
		        }
	        }
	        finally
	        {
	        	try
	        	{
	        		rs.close();
	        		stmt.close();
	        		conn.close();
	        	}
	        	catch(Exception e)
	        	{
	        		e.printStackTrace();
	        	}
	        }
		}		
		return "auth";
	}
}