package com.authenticate;

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