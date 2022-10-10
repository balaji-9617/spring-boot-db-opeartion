package com.learn.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.model.user;
import java.util.*;


@RestController
public class UserController 
{
	@Autowired
	UserRepo userRepo;
	
	@GetMapping(path="getUsers",produces = {"application/xml"})
	@ResponseBody
	public List<user> getUsers()
	{
		System.out.print("Inside get users");
		List<user> userList = userRepo.findAll();
		int a = 10/0;
		System.out.println("data fetched...");
		return userList;
		
	}
	
//	@GetMapping("getUser/{aid}")
//	@ResponseBody
//	public user getUser(@PathVariable("aid") int aid)
//	{
//		user usr = userRepo.findById(aid).orElse(new user(0,"")); 
//		return usr;
//	}
	
	@GetMapping("getUser/{aid}")
	public user getUser(@PathVariable("aid") int aid)
	{
		user usr = userRepo.findById(aid).orElse(new user(0,"")); 
		return usr;
	}
	
	@PostMapping(path="addUserUsingREST",consumes = {"application/xml"})
	public void addUser(@RequestBody user usr)
	{
		userRepo.save(usr);
	}
	
}
