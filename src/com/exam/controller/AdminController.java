package com.exam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.AdminDao;
import com.exam.dao.MessageDao;
import com.exam.model.Admin;
import com.exam.model.Message;
/**
 * 管理员功能控制类
 * @author 1
 *
 */
public class AdminController extends HttpServlet {

	@Override   //覆盖
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("exit".equalsIgnoreCase(action)) {
			HttpSession session = req.getSession();
			Admin admin = (Admin)session.getAttribute("admin");
			if(admin !=null) {
				//当前用户已经登录，可以执行退出登录
				session.setAttribute("admin", null);
				resp.sendRedirect("./login.jsp");
				return;
			}
				return;
		}else if("register".equalsIgnoreCase(action)) {
			//跳转管理员注册页面
			resp.sendRedirect("./adminregister.jsp");
			return;
		}
		resp.sendRedirect("./login.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("add".equalsIgnoreCase(action)){
			String name = req.getParameter("adminname");
			String password = req.getParameter("password");
			String password1 = req.getParameter("password1");
			String invite = req.getParameter("invite");
			
			//1.password和password1两者内容不相等，跳转错误页面
			if(name == "" || password == "" || password1 == "" || !password.equalsIgnoreCase(password1)) {
				resp.sendRedirect("./error.html");
				return;
			}
			//非特定邀请用户，不接受注册
			if(invite == "" || !"root".equalsIgnoreCase(invite)) {
				resp.sendRedirect("./error.html");
				return;
			}
			//2.两者内容一致且不为空，继续处理
			AdminDao adminDao = new AdminDao();
			Admin admin = new Admin();
			admin.setUsername(name);
			admin.setPassword(password);
			admin.setStatus(1);
			boolean isRegisterSuccess = adminDao.insertAdmin(admin);
			if (isRegisterSuccess){
				resp.sendRedirect("./login.jsp");
				return;
			}else {
				resp.sendRedirect("./error.html");
				return;
			}
		}

		//1. 解析用户登录参数
		String  userName = req.getParameter("username");
		String  password =  req.getParameter("password");
		//2.封装对象
		Admin admin = new Admin();
		admin.setUsername(userName);
		admin.setPassword(password);
		//3.实例化Admin的数据库操作类对象，并调用方法AdminDao
		AdminDao adminDao = new AdminDao();
		//4.调用Dao层代码，实现数据库操作。
		boolean isloginSuccess =  adminDao.login(admin);
		//条件判断
		if(isloginSuccess) {
			//跳转功能管理界面
			//session,cookie
			HttpSession ssion = req.getSession();
			ssion.setAttribute("admin", admin);
			//跳转主界面
			//mess动态变量；携带学生数据
			MessageDao messDao = new MessageDao();
			List<Message> mess = messDao.GetAllMessages();
			req.setAttribute("mess", mess);
			req.setAttribute("admin", admin);
			RequestDispatcher dispatcher = req.getRequestDispatcher("./index.jsp");
			dispatcher.forward(req,resp);
			//跳转主界面
			
		}else {
			
			//返回404.html
			resp.sendRedirect("./error.html");
			
		}
	}
	

}
