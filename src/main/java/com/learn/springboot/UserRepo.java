package com.learn.springboot;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learn.springboot.model.user;

public interface UserRepo extends JpaRepository<user, Integer> 
{

	ArrayList<user> getUserByAname(String aname);

	@Query("from user where aname like :aname%")
	ArrayList<user> searchUserByAnameFirstName(String aname);
	

}
