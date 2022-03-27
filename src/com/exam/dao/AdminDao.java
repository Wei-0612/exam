package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.model.Admin;
import com.exam.utils.DButils;

/**
 * 管理员数据库操作类
 * @author 1
 *
 */
public class AdminDao {
	
	private static Connection conn;
	public AdminDao(){
		conn = DButils.getConn();
	}
	
	/**
	 * 保存一条数据到数据库
	 * @param admin
	 * @return
	 */
	public boolean insertAdmin(Admin admin) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into admin (username, password,status) values(?,?,?)");
			pst.setString(1, admin.getUsername());
			pst.setString(2, admin.getPassword());
			pst.setInt(3, admin.getStatus());
			int result = pst.executeUpdate();
			return result >0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询操作数据库并判断操作是否成功并返回结果。
	 * @param admin
	 * @return
	 */
	public boolean login(Admin admin) {
		//创建一个PreparedStatement
		String sql = "select * from admin where username= ? and password = ?";
		try {
			//准备Prepared对象
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getUsername());
			pst.setString(2, admin.getPassword());
			//执行exeute操作
			ResultSet rst = pst.executeQuery();
			//请求处理
			if(rst.next()) {
				System.out.println(rst.getString(1));
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

}
