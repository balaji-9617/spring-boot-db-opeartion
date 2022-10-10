package com.learn.springboot;

import java.util.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.*;
import org.springframework.stereotype.Component;
import com.learn.springboot.model.user;

@Aspect
@Component
public class LoggingAspect 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.learn.springboot.UserController.getUsers())")
	public void Beforlog()
	{
		//System.out.println("getUsers method called from aspect");
		LOGGER.info("getUsers method called from aspect");
	}
	
	
	@After("execution(public * com.learn.springboot.UserController.getUsers())")
	public void Afterlog()
	{
		//System.out.println("getUsers method called from aspect");
		LOGGER.info("after final getUsers  aspect");
	}
	
	
	@AfterReturning("execution(public * com.learn.springboot.UserController.getUsers())")
	public void AfterReturnlog()
	{
		//System.out.println("getUsers method called from aspect");
		LOGGER.info("after return getUsers  aspect");
	}
	
	
	@AfterThrowing("execution(public * com.learn.springboot.UserController.getUsers())")
	public void AfterThrowinglog()
	{
		//System.out.println("getUsers method called from aspect");
		LOGGER.info("after throwing getUsers  aspect");
	}
}
