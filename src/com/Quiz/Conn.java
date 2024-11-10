package com.Quiz;
import java.sql.*;
public class Conn {
	 Connection con;
	 ResultSet rs;
	 Statement stmt;
public Conn() {
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz","root","Kartik@5151");
	stmt=con.createStatement();
	}catch(Exception E) {
		E.printStackTrace();
	}
}
}
