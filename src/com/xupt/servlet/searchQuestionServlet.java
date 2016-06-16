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
import com.xupt.entity.QuestionDetail;
import com.xupt.entity.QuestionInfo;

public class searchQuestionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public searchQuestionServlet() {
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
		System.out.println("进入GET答题的servlet");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int paper_id = Integer.valueOf(request.getParameter("paper_id"));
		UserDao dao = new UserDao();
		List<QuestionDetail> list = dao.searchAllQuestion(paper_id);
		session.setAttribute("allQuestionInfo", list);
		System.out.println("查找没有问题准备跳转");
		request.getRequestDispatcher("doQuestion.jsp").forward(request, response);
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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int paper_id = Integer.valueOf(request.getParameter("paper_id"));
		UserDao dao = new UserDao();
		List<QuestionDetail> list = dao.searchAllQuestion(paper_id);
		System.out.println("查找到的答案:"+list.get(0).getResult());
		session.setAttribute("allQuestionInfo", list);
		request.getRequestDispatcher("doQuestion.jsp").forward(request, response);
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
