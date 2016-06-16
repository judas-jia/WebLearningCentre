package com.xupt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xupt.dao.UserDao;
import com.xupt.entity.Question;

public class MakeHtml5QuestionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MakeHtml5QuestionServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		System.out.println("标题为："+title);
		String description = request.getParameter("description");
		String question1 = request.getParameter("question1");
		String answerA1 = request.getParameter("answerA1");
		String answerB1 = request.getParameter("answerB1");
		String answerC1 = request.getParameter("answerC1");
		String answerD1 = request.getParameter("answerD1");
		int answerSelect = Integer.parseInt(request.getParameter("usertype1"));//接收到正确答案的序号
		
		Question question = new Question();
		question.setTitle(title);
		question.setDescription(description);
		question.setTeacher_name((String)session.getAttribute("loginName"));
		question.setGenre_id(3);
		question.setQuestion(question1);
		question.setAnswerA1(answerA1);
		question.setAnswerB1(answerB1);
		question.setAnswerC1(answerC1);
		question.setAnswerD1(answerD1);
		question.setResult_selection(answerSelect);
		UserDao dao = new UserDao();
		int paper_id = dao.addQuestion(question);
		
		String question2 = request.getParameter("question2");
		String answerA2 = request.getParameter("answerA2");
		String answerB2 = request.getParameter("answerB2");
		String answerC2 = request.getParameter("answerC2");
		String answerD2 = request.getParameter("answerD2");
		int answerSelect2 = Integer.parseInt(request.getParameter("usertype2"));//接收到正确答案的序号
		question.setQuestion(question2);
		question.setAnswerA1(answerA2);
		question.setAnswerB1(answerB2);
		question.setAnswerC1(answerC2);
		question.setAnswerD1(answerD2);
		question.setResult_selection(answerSelect2);
		question.setPaper_id(paper_id);
		dao.addQuestionNext(question);
		
		String question3 = request.getParameter("question3");
		String answerA3 = request.getParameter("answerA3");
		String answerB3 = request.getParameter("answerB3");
		String answerC3 = request.getParameter("answerC3");
		String answerD3 = request.getParameter("answerD3");
		int answerSelect3 = Integer.parseInt(request.getParameter("usertype3"));//接收到正确答案的序号
		question.setQuestion(question3);
		question.setAnswerA1(answerA3);
		question.setAnswerB1(answerB3);
		question.setAnswerC1(answerC3);
		question.setAnswerD1(answerD3);
		question.setResult_selection(answerSelect3);
		question.setPaper_id(paper_id);
		dao.addQuestionNext(question);
		
		String question4 = request.getParameter("question4");
		String answerA4 = request.getParameter("answerA4");
		String answerB4 = request.getParameter("answerB4");
		String answerC4 = request.getParameter("answerC4");
		String answerD4 = request.getParameter("answerD4");
		int answerSelect4 = Integer.parseInt(request.getParameter("usertype4"));//接收到正确答案的序号
		question.setQuestion(question4);
		question.setAnswerA1(answerA4);
		question.setAnswerB1(answerB4);
		question.setAnswerC1(answerC4);
		question.setAnswerD1(answerD4);
		question.setResult_selection(answerSelect4);
		question.setPaper_id(paper_id);
		dao.addQuestionNext(question);
		
		String question5 = request.getParameter("question5");
		String answerA5 = request.getParameter("answerA5");
		String answerB5 = request.getParameter("answerB5");
		String answerC5 = request.getParameter("answerC5");
		String answerD5 = request.getParameter("answerD5");
		int answerSelect5 = Integer.parseInt(request.getParameter("usertype5"));//接收到正确答案的序号
		question.setQuestion(question5);
		question.setAnswerA1(answerA5);
		question.setAnswerB1(answerB5);
		question.setAnswerC1(answerC5);
		question.setAnswerD1(answerD5);
		question.setResult_selection(answerSelect5);
		question.setPaper_id(paper_id);
		dao.addQuestionNext(question);
		request.getRequestDispatcher("ShowTeacherAllQuestionServlet").forward(request, response);
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
