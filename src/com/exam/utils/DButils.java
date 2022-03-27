package com.exam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 实现jdbc连接
 */
public class DButils {
	private static Connection Conn;
	/**
	 * 加载JDBC类，连接数据库，返回connection对象
	 * @return
	 */
	public static Connection getConn(){
		if (Conn != null){
			return Conn;
		}
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connUrl = "jdbc:mysql://localhost:3306/exam_info?serverTimezone=GMT%2B8";
		String user = "root";
		String password = "root";
		return DriverManager.getConnection(connUrl,user,password);
		
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return Conn;

 }
}
