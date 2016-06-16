package com.xupt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xupt.dao.UserDao;
import com.xupt.entity.Student;
import com.xupt.entity.Teacher;

import sun.misc.UCDecoder;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("进入Loginservlet");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String userType = request.getParameter("usertype");
		//System.out.println("类型"+userType);
		String username = request.getParameter("username");//获取到前端输入的用户名
		String password = request.getParameter("password");//获取到前端输入的密码
		if(userType.equals("student")){
			UserDao dao = new UserDao();
			if(dao.isCheckUserByStudent(username, password)==true){
				String loginName = dao.searchStudentInfo(username);
				
				System.out.println("学生用户名称:"+loginName);
				session.setAttribute("loginName", loginName);
				List paperList = dao.searchAllPaper();
				System.out.println("查找到的所有题目信息总数:"+paperList.size());
				session.setAttribute("paperList", paperList);
				int temp = paperList.size();
				session.setAttribute("paperLength", temp);
				request.getRequestDispatcher("studentLoginedIndex.jsp").forward(request, response);
				//response.sendRedirect("studentLoginedIndex.jsp");
			}else{
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else if(userType.equals("teacher")){
			UserDao dao = new UserDao();
			if(dao.isCheckUserByTeacher(username, password)==true){
				String loginName = dao.searchTeacherInfo(username);
				System.out.println("教师用户名称:"+loginName);
				session.setAttribute("loginName", loginName);
				request.getRequestDispatcher("ShowTeacherAllQuestionServlet").forward(request, response);
			}else{
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else if(userType.equals("administrator")){
			UserDao dao = new UserDao();
			if(dao.isCheckUserByAdmin(username, password)==true){
				String loginName = username;
				System.out.println("管理员用户名称:"+loginName);
				session.setAttribute("loginName", loginName);
				List<Student> list = dao.searchAllStudent();
				session.setAttribute("allStudentInfoList", list);
				List<Teacher> list2 = dao.searchAllTeacher();
				session.setAttribute("allTeacherInfoList", list2);
				request.getRequestDispatcher("managerLoginedIndex.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
