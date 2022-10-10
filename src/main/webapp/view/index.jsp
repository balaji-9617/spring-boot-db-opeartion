<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<meta charser="UTF-8">
	<title>no title</title>
	<body>
		Hello balaji
		
		<!--<form action="add">
			Enter 1st num : <input type="text" name="number1"><br>
			Enter 2nd num : <input type="text" name="number2"><br>
			<input type="submit" ><br><br>
		</form>-->
		
		<h2>Add user to db:</h2>
		<form action="addUser" method="post">
			Enter user id : <input type="text" name="aid"><br>
			Enter user name: <input type="text" name="aname"><br>
			<input type="submit" ><br><br>
		</form>
		<hr>
		<h2>get specific user from  db by ID:</h2>
		<form action="getIDSpecificUser" method="get">
			Enter user id : <input type="text" name="aid"><br>
			<input type="submit"><br>
		</form>
		<hr>
		<h2>get specific user from  db by name:</h2>
		<form action="getUserByName" method="get">
			Enter user name : <input type="type" name="aname">
			<input type="submit">		
		</form>
	</body>
</html>
