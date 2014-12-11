package com.javabrains.service;

public class LoginService {
	
	public boolean authenticate(String userId, String password)
	{
		if(password == null || password.trim() == "")
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
