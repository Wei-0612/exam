package com.exam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.MessageDao;
import com.exam.model.Admin;
import com.exam.model.Message;

/**
 * 考试信息业务逻辑处理
 * @author 1
 *
 */
public class MessageController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin == null) {
			resp.sendRedirect("./error.html");
			return;
		}

		String action = req.getParameter("action");
		if("delete".equalsIgnoreCase(action)) {  

			String mid = req.getParameter("mid");
			MessageDao messageDao = new MessageDao();
			int id = Integer.parseInt(mid);
			boolean isDelete = messageDao.DeleteMessById(id);
			if(isDelete) {

				MessageDao messDao = new MessageDao();
				List<Message> mess = messDao.GetAllMessages();
				req.setAttribute("mess", mess);
				req.setAttribute("admin", admin);
					RequestDispatcher dispatcher = req.getRequestDispatcher("./main.jsp");
					dispatcher.forward(req, resp);
				
			}else {

			resp.sendRedirect("./error.html");
				
			}
		}
		else if("update".equalsIgnoreCase(action)) {  

			String mid = req.getParameter("mid");
			int id = Integer.parseInt(mid);
			MessageDao messDao = new MessageDao();
			Message mess = messDao.GetExInfoById(id);
			if(mess == null) {
				resp.sendRedirect("./error.html");
			}else {

				req.setAttribute("mes", mess);
				RequestDispatcher dispatcher = req.getRequestDispatcher("./updatemes.jsp");
				dispatcher.forward(req, resp);
			}	
		}
		else if("add".equalsIgnoreCase(action)){
			resp.sendRedirect("./add.jsp");
		}
		else if("select".equalsIgnoreCase(action)) {  

			HttpSession ssion = req.getSession();
			ssion.setAttribute("admin", admin);
			MessageDao messDao = new MessageDao();
			List<Message> mess = messDao.GetAllMessages();
			req.setAttribute("mess", mess);
			req.setAttribute("admin", admin);
				RequestDispatcher dispatcher = req.getRequestDispatcher("./main.jsp");
				dispatcher.forward(req, resp);
			}	
		}

	/**
	 * 处理MessageController请求下的POST请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				HttpSession session = req.getSession();
				Admin admin = (Admin)session.getAttribute("admin");
				if(admin == null) {
					resp.sendRedirect("./error.html");
					return;
				}

		String action = req.getParameter("action");
		if("update".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(req.getParameter("mid"));
			Message mes = new Message();
			
			mes.setSubject( req.getParameter("subject"));
			mes.setTeacher(req.getParameter("teacher"));
			mes.setDate(req.getParameter("date"));
			mes.setPlace(req.getParameter("place"));
			mes.setMid(id);
			MessageDao messDao = new MessageDao();
			boolean isUpdateSuccess = messDao.UpdateExaInfo(mes);
			
			if(isUpdateSuccess) {
				List<Message> allMess = messDao.GetAllMessages();
				req.setAttribute("mess", allMess);
				RequestDispatcher dispatcher = req.getRequestDispatcher("./main.jsp");
				dispatcher.forward(req, resp);
			}else {
				resp.sendRedirect("./error.html");
			}
		}
		else if("add".equalsIgnoreCase(action)){
			String subject = req.getParameter("subject");
			String teacher = req.getParameter("teacher");
			String date = req.getParameter("date");
			String place= req.getParameter("place");
			
			Message mes = new Message();
			
			mes.setSubject(subject);
			mes.setTeacher(teacher);
			mes.setDate(date);
			mes.setPlace(place);
			
			MessageDao messDao = new MessageDao();
			boolean isAddSuccess = messDao.AddExaInfo(mes);
			
			if(isAddSuccess) {
				List<Message>allMess = messDao.GetAllMessages();
				req.setAttribute("mess", allMess);
				RequestDispatcher dispatcher = req.getRequestDispatcher("./main.jsp");
				dispatcher.forward(req, resp);
			}else {
				resp.sendRedirect("./error.html");
			}
		}
	}
}
