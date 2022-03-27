package com.exam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.exam.dao.TeacherDao;
import com.exam.model.Admin;
import com.exam.model.Teacher;

/**
 * 教师信息业务逻辑处理
 * @author 1
 *
 */
public class TeacherController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//权限判断，是否已经登陆
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin == null) {
			resp.sendRedirect("./error.html");
			return;
		}
		
		//删除功能：根据记录编号
		
		//1.解析请求参数
		String action = req.getParameter("action");
		if("delete".equalsIgnoreCase(action)) {  
			//2.执行删除操作
			String tid = req.getParameter("tid");
			TeacherDao teacherDao = new TeacherDao();
			int id = Integer.parseInt(tid);
			boolean isDelete = teacherDao.DeleteTeachById(id);
			if(isDelete) {
				List<Teacher> teac = teacherDao.GetAllTeachers();
				req.setAttribute("teac", teac);
				req.setAttribute("admin", admin);
					RequestDispatcher dispatcher = req.getRequestDispatcher("./teacher.jsp");
					dispatcher.forward(req, resp);
				
			}else {
				//4.跳转异常，error.html
			resp.sendRedirect("./error.html");
				
			}
		}
		else if("update".equalsIgnoreCase(action)) {   //修改信息逻辑
			//获取到Mid值，调用并传递到Dao层的方法，执行数据库操作查询
			String tid = req.getParameter("tid");
			int id = Integer.parseInt(tid);
			TeacherDao teacherDao = new TeacherDao();
			Teacher teac = teacherDao.GetTExInfoById(id);
			if(teac == null) {
				//错误，跳转error页
				resp.sendRedirect("./error.html");
			}else {
				//成功，跳转update页
				req.setAttribute("tea", teac);
				RequestDispatcher dispatcher = req.getRequestDispatcher("./updatetea.jsp");
				dispatcher.forward(req, resp);
			}	
		}
		else if("add".equalsIgnoreCase(action)){
			resp.sendRedirect("./addteacher.jsp");
		}
		else if("select".equalsIgnoreCase(action)) {   //修改信息逻辑
			//获取到Mid值，调用并传递到Dao层的方法，执行数据库操作查询
			HttpSession ssion = req.getSession();
			ssion.setAttribute("admin", admin);
			TeacherDao teacherDao = new TeacherDao();
			List<Teacher> teac = teacherDao.GetAllTeachers();
			req.setAttribute("teac", teac);
			req.setAttribute("admin", admin);
				RequestDispatcher dispatcher = req.getRequestDispatcher("./teacher.jsp");
				dispatcher.forward(req, resp);
			}	
		}
		//将解析请求参数传给DAO层，执行数据库操作
	/**
	 * 处理TeacherController请求下的POST请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//权限判断，是否已经登陆
				HttpSession session = req.getSession();
				Admin admin = (Admin)session.getAttribute("admin");
				if(admin == null) {
					resp.sendRedirect("./error.html");
					return;
				}
		//获取请求参数
		String action = req.getParameter("action");
		//根据参数值判断操作流程
		if("update".equalsIgnoreCase(action)) {
			//拿到from表单中的数据，封装对象
			int id = Integer.parseInt(req.getParameter("tid"));
//			int age = Integer.parseInt(req.getParameter("age"));
			Teacher tea = new Teacher();
			
			tea.setTname(req.getParameter("tname"));
			tea.setPassword(req.getParameter("password"));
			tea.setAge(req.getParameter("age"));
			tea.setGender(req.getParameter("gender"));
			tea.setTid(id);
			TeacherDao teacherDao = new TeacherDao();
			boolean isUpdateSuccess = teacherDao.UpdateTExaInfo(tea);
			
			if(isUpdateSuccess) {
				//如果成功,信息列表页面main.jsp
				List<Teacher> allTeac = teacherDao.GetAllTeachers();
				req.setAttribute("teac", allTeac);
				RequestDispatcher dispatcher = req.getRequestDispatcher("./teacher.jsp");
				dispatcher.forward(req, resp);
			}else {
				//失败，error.html
				resp.sendRedirect("./error.html");
			}
		}
		else if("add".equalsIgnoreCase(action)){
			//解析参数
			String tname = req.getParameter("tname");
			String password = req.getParameter("password");
			String age = req.getParameter("age");
			String gender= req.getParameter("gender");
			Teacher tea = new Teacher();	
			tea.setTname(tname);
			tea.setPassword(password);
			tea.setAge(age);
			tea.setGender(gender);
			TeacherDao teacherDao = new TeacherDao();
			boolean isAddSuccess = teacherDao.AddTExaInfo(tea);
			
			if(isAddSuccess) {
				List<Teacher>allTeac = teacherDao.GetAllTeachers();
				req.setAttribute("teac", allTeac);
				RequestDispatcher dispatcher = req.getRequestDispatcher("./teacher.jsp");
				dispatcher.forward(req, resp);
			}else {
				resp.sendRedirect("./error.html");
			}
		}
	}
}
