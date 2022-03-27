package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.exam.model.Teacher;
import com.exam.utils.DButils;

/**
 * 教师数据库操作类
 * @author 1
 *
 */
public class TeacherDao {
	private Connection conn;
	
	/**
	 * StudentDao的构造方法
	 */
	public TeacherDao() {
		conn = DButils.getConn();
	}
	/**
	 * 保存新记录到数据库
	 * @param message
	 * @return
	 */
	public boolean AddTExaInfo(Teacher teacher) {
		try {
			PreparedStatement pst = conn.prepareStatement(" insert into teacher(tname,password,age,gender) values(?,?,?,?)");
			pst.setString(1, teacher.getTname());
			pst.setString(2, teacher.getPassword());
			pst.setString(3, teacher.getAge());
			pst.setString(4, teacher.getGender());
			int result = pst.executeUpdate();
			return result>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
	/**
	 * 修改考试信息到数据库
	 * @param message
	 * @return
	 */
	public boolean UpdateTExaInfo(Teacher teacher) {
		try {
			PreparedStatement pst = conn.prepareStatement("update teacher set tname =?, password= ?, age = ?, gender = ? where tid = ?");
			pst.setString(1, teacher.getTname());
			pst.setString(2, teacher.getPassword());
			pst.setString(3, teacher.getAge());
			pst.setString(4, teacher.getGender());
			pst.setInt(5,teacher.getTid());
			int result = pst.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Teacher GetTExInfoById(int tid) {
		try {
			PreparedStatement pst = conn.prepareStatement("select * from teacher where tid = ?");
			pst.setInt(1, tid);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				Teacher tea = new Teacher();
				tea.setTid(rst.getInt("tid"));
				tea.setTname(rst.getString("tname"));
				tea.setGender(rst.getString("gender"));
				tea.setPassword(rst.getString("password"));
				tea.setAge(rst.getString("age"));			
				return tea;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean DeleteTeachById(int tid) {
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("delete from teacher where tid = ?");
			pst.setInt(1, tid);
			int result = pst.executeUpdate();
			return result>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * 获取教师信息并返回
	 * @return
	 */
	public List<Teacher> GetAllTeachers() {
		List<Teacher> teac = new ArrayList<Teacher>();
		try {
			Statement st = conn.createStatement();
			ResultSet rst = st.executeQuery("select * from teacher");
			
			while(rst.next()) {
				Teacher tea = new Teacher();
				tea.setTid(rst.getInt("tid"));
				tea.setTname(rst.getString("tname"));
				tea.setGender(rst.getString("gender"));
				tea.setPassword(rst.getString("password"));
				tea.setAge(rst.getString("age"));			
				teac.add(tea);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teac;
	}

}
