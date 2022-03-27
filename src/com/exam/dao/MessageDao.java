package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.exam.model.Message;
import com.exam.utils.DButils;

/**
 * 信息数据库操作类
 * @author 1
 *
 */
public class MessageDao {
	private Connection conn;
	
	/**
	 * StudentDao的构造方法
	 */
	public MessageDao() {
		conn = DButils.getConn();
	}
	/**
	 * 保存新记录到数据库
	 * @param message
	 * @return
	 */
	public boolean AddExaInfo(Message message) {
		try {
			PreparedStatement pst = conn.prepareStatement(" insert into message(subject,teacher,date,place) values(?,?,?,?)");
			pst.setString(1, message.getSubject());
			pst.setString(2, message.getTeacher());
			pst.setString(3, message.getDate());
			pst.setString(4, message.getPlace());
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
	public boolean UpdateExaInfo(Message message) {
		try {
			PreparedStatement pst = conn.prepareStatement("update message set subject =?, teacher= ?, date = ?, place = ? where mid = ?");
			pst.setString(1, message.getSubject());
			pst.setString(2,message.getTeacher() );
			pst.setString(3, message.getDate());
			pst.setString(4, message.getPlace());
			pst.setInt(5,message.getMid());
			int result = pst.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Message GetExInfoById(int mid) {
		try {
			PreparedStatement pst = conn.prepareStatement("select * from message where mid = ?");
			pst.setInt(1, mid);
			ResultSet rst = pst.executeQuery();
			if(rst.next()) {
				Message mes = new Message();
				mes.setMid(rst.getInt("mid"));
				mes.setSubject(rst.getString("subject"));
				mes.setTeacher(rst.getString("teacher"));
				mes.setDate(rst.getString("date"));
				mes. setPlace(rst.getString("place"));
				return mes;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean DeleteMessById(int mid) {
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("delete from message where mid = ?");
			pst.setInt(1, mid);
			int result = pst.executeUpdate();
			return result>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * 获取所有考试信息并返回
	 * @return
	 */
	public List<Message> GetAllMessages() {
		List<Message> mess = new ArrayList<Message>();
		try {
			Statement st = conn.createStatement();
			ResultSet rst = st.executeQuery("select * from message");
			
			while(rst.next()) {
				Message mes = new Message();
				mes.setMid(rst.getInt("mid"));
				mes.setSubject(rst.getString("subject"));
				mes.setTeacher(rst.getString("teacher"));
				mes.setDate(rst.getString("date"));
				mes. setPlace(rst.getString("place"));
				mess.add(mes);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mess;
	}

}
