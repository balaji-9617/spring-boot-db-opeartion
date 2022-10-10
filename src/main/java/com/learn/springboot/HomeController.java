package com.learn.springboot;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.learn.springboot.model.user;

@Controller
public class HomeController 
{
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.print("Homepage controller test");
//		InternalResourceViewResolver viewTemplate = new InternalResourceViewResolver();
//		viewTemplate.setPrefix("/webapp/");
//		viewTemplate.setSuffix(".jsp");
		
		return "index";
	}
	
//	@RequestMapping("add")
//	public String add(HttpServletRequest req)
//	{
//		int a = Integer.parseInt(req.getParameter("number1"));
//		int b = Integer.parseInt(req.getParameter("number2"));
//		int c = a+b;
//		
//		HttpSession ses = req.getSession();
//		ses.setAttribute("num3", c);
//		
//		return "result.jsp";
//	}
//	
//	@RequestMapping("add")
//	public String add( @RequestParam("number1") int a,@RequestParam("number2") int b, HttpSession ses)
//	{
//		int c = a+b;
//		
//		ses.setAttribute("num3", c);
//		
//		return "result.jsp";
//	}
//	
	
//	@RequestMapping("add")
//	public ModelAndView add( @RequestParam("number1") int a,@RequestParam("number2") int b)
//	{
//		int c = a+b;
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		mv.addObject("num3", c);
//			
//		return mv;
//	}
	
	@ModelAttribute
	public void addDataToModel(Model m) {
		m.addAttribute("name", "Aliean");
	}
	
	@RequestMapping("add")
	public String add( @RequestParam("number1") int a,@RequestParam("number2") int b,Model m)
	{
		int c = a+b;
		
		m.addAttribute("num3", c);
			
		return "result";
	}
	
	@RequestMapping("addUser1")
	public String addUser(@RequestParam("aid")int aid,@RequestParam("aname")String aName,Model m) 
	{
		//AddUser user = new AddUser();
		user user = new user(aid,aName);
		user.setAid(aid);
		user.setAname(aName);
		m.addAttribute("userDetail", user);
		
		return "user";
	}
	
//	@RequestMapping("addUser")
//	public String addUser(@ModelAttribute AddUser user,Model m) 
//	{
//		m.addAttribute("userDetail", user);
//		
//		return "user";
//	}
	
	@RequestMapping("addUser")
	public String addUser(@ModelAttribute("userDetail") user user,Model m) 
	{
		userRepo.save(user);
		m.addAttribute("name", user.getAname());
		
		return "user";
	}
	
	@RequestMapping("getIDSpecificUser")
	public String getUser(@RequestParam int aid,Model m)
	{
		System.out.print("Inside get user");
		m.addAttribute("userData", userRepo.getOne(aid));
		
		return "details";
	}
	
	@GetMapping("getUserByName")
	public String getUser(@RequestParam("aname") String aname,Model m)
	{
		m.addAttribute("userData", userRepo.searchUserByAnameFirstName(aname));
		return "details";
	}
	
	
	@RequestMapping("getAllUsers")
	public String getUser(Model m)
	{
		System.out.print("Inside get user");
		m.addAttribute("userData", userRepo.findAll());
		
		return "details";
	}
}
