package com.xupt.dao;

import java.util.ArrayList;
import java.util.List;

import com.xupt.entity.Admin;
import com.xupt.entity.Genre;
import com.xupt.entity.Paper;
import com.xupt.entity.PaperInfoByTeacher;
import com.xupt.entity.Question;
import com.xupt.entity.QuestionDetail;
import com.xupt.entity.QuestionInfo;
import com.xupt.entity.Result;
import com.xupt.entity.Student;
import com.xupt.entity.Teacher;



public class UserDao extends BaseDao{
	//用于在登录时判断用户名和密码是否正确
//		public boolean isCheckUser(String userName,String password){
//			String sql="select * from user_info";
//			List<LoginUser> list=super.query1(sql, LoginUser.class);
//			boolean flag=false;
//			for (LoginUser loginUser : list) {
//				if(loginUser.getName().equals(userName) && loginUser.getPassword().equals(password)){
//					flag=true;
//					break;
//				}
//			}
//			return flag;
//		}
	//注册学生信息与表中
	public void registerByStudent(String userName,String password){
		String sql = "INSERT INTO student_info VALUES(null,'"+userName+"','"+password+"','"+userName+"')";
		super.update(sql);
		System.out.println("学生信息成功插入");
	}
	//注册教师信息与表中
	public void registerByTeacher(String userName,String password){
		String sql = "INSERT INTO teacher_info VALUES(null,'"+userName+"','"+password+"','"+userName+"')";
		super.update(sql);
		System.out.println("教师信息成功插入");
	}
	//注册学生信息与表中
	public void registerByAdmin(String userName,String password){
		String sql = "INSERT INTO admin_info VALUES(null,'"+userName+"','"+password+"','"+userName+"')";
		super.update(sql);
		System.out.println("管理员信息成功插入");
	}
		
	//用于在登录时判断用户名和密码是否正确通过学生信息表
	public boolean isCheckUserByStudent(String userName,String password){
		String sql="select * from student_info";
		List<Student> list=super.query1(sql, Student.class);
		boolean flag=false;
		for (Student loginUser : list) {
			if(loginUser.getAccount().equals(userName) && loginUser.getPassword().equals(password)){
				flag=true;
				break;
			}
		}
		return flag;
	}
	//用于在登录时判断用户名和密码是否正确通过教师信息表
		public boolean isCheckUserByTeacher(String userName,String password){
			String sql="select * from teacher_info";
			List<Teacher> list=super.query1(sql, Teacher.class);
			boolean flag=false;
			for (Teacher loginUser : list) {
				if(loginUser.getAccount().equals(userName) && loginUser.getPassword().equals(password)){
					flag=true;
					break;
				}
			}
			return flag;
		}
		//用于在登录时判断用户名和密码是否正确通过管理员信息表
				public boolean isCheckUserByAdmin(String userName,String password){
					String sql="select * from admin_info";
					List<Admin> list=super.query1(sql, Admin.class);
					boolean flag=false;
					for (Admin loginUser : list) {
						if(loginUser.getAccount().equals(userName) && loginUser.getPassword().equals(password)){
							flag=true;
							break;
						}
					}
					return flag;
				}
	
		//用于在注册用户时判断数据库中是否存在此用户
		public boolean isExistUser(String userName){
			boolean flag=false;//false是数据库中没有重复的用户
			String sql="select * from student_info";
			List<Student> list=super.query1(sql, Student.class);
			for (Student loginUser : list) {
				if(loginUser.getName().equals(userName)){
					flag=true;//此时数据库中有此用户存在
					break;
				}
			}
			return flag;
		}
		
		//查找sudent_info中所有学生基本信息
		public List<Student> searchAllStudent(){
			String sql = "SELECT * FROM student_info";
			List<Student> list = super.query1(sql, Student.class);
			return list;
		}
		//查找teacher_info中所有教师基本信息
		public List<Teacher> searchAllTeacher(){
			String sql = "SELECT * FROM teacher_info";
			List<Teacher> list = super.query1(sql, Teacher.class);
			return list;
		}
		
		//管理员根据姓名删除对应的教师
		public void deleteTeacherInfo(String name){
			System.out.println("要删除的教师姓名:"+name);
			String sql = "DELETE FROM teacher_info WHERE name = '"+name+"'";
			super.update(sql);
		}
		
		//管理员根据姓名删除对应的学生
		public void deleteStudentInfo(String name){
			System.out.println("要删除的教师姓名:"+name);
			String sql = "DELETE FROM student_info WHERE name = '"+name+"'";
			super.update(sql);
		}
		
		//返回用户在查找到的相应的学生用户姓名
		public String searchStudentInfo(String account){
			String sql="select * from student_info";
			List<Student> list=super.query1(sql, Student.class);
			for (Student loginUser : list) {
				if(loginUser.getAccount().equals(account)){
					return loginUser.getName();
					//break;
				}			
			}
			return "";
		}
		
		//返回用户在查找到的相应的教师用户姓名
		public String searchTeacherInfo(String account){
			String sql="select * from teacher_info";
			List<Teacher> list=super.query1(sql, Teacher.class);
			for (Teacher loginUser : list) {
				if(loginUser.getAccount().equals(account)){
					return loginUser.getName();
					//break;
				}			
			}
			return "";
		}
		
		//根据教师出的题向数据库中插入相关数据(返回套题的id)
		public int addQuestion(Question info){
			String title = info.getTitle();
			String description = info.getDescription();
			String teacherName = info.getTeacher_name();
			String question = info.getQuestion();
			String answer1 = info.getAnswerA1();
			String answer2 = info.getAnswerB1();
			String answer3 = info.getAnswerC1();
			String answer4 = info.getAnswerD1();
			int resultSelection = info.getResult_selection();
			
			int genre_id = info.getGenre_id();
			int teacher_id = 1;
			int paper_id = 0;//更新完之后套题的id
			int question_num = 0;//更新完之后题目的id
			System.out.println("获取到教师的姓名："+teacherName+" Title:"+title);
			
			//根据教师姓名查找到对应教师ID
			String sql = "select * from teacher_info";
			List<Teacher> list=super.query1(sql, Teacher.class);
			for (Teacher loginUser : list) {
				if(loginUser.getName().equals(teacherName)){
					teacher_id = loginUser.getId();//获取到教师ID
					break;
				}			
			}
			
			//向paper_info表中插入数据
			sql = "INSERT INTO paper_info VALUES(null,'"+title+"','"+description+"',?,?)";
			super.paper_update(sql, teacher_id, genre_id);
			System.out.println("paper_info更新完毕");
			
			//查找到更新后题的paper_id
			sql = "SELECT * FROM paper_info";
			List<Paper> list1 = super.query1(sql, Paper.class);
			for (Paper loginUser : list1) {
				if(loginUser.getTitle().equals(title)){
					paper_id = loginUser.getId();//获取到Paper中题目ID
					break;
				}			
			}
			
			//向question_info表中插入数据
			System.out.println("接收到的question:"+question+" answer1:"+answer1+"paper_id:"+paper_id);
			sql = "INSERT INTO question_info VALUES(null,'"+question+"','"+answer1+"','"+answer2+"','"+answer3+"','"+answer4+"',?)";
			super.question_update(sql, paper_id);
			System.out.println("question_info更新完毕");
			
			//查找到更新后question_info中id
			sql = "SELECT * FROM question_info";
			List<QuestionInfo> list2 = super.query1(sql, QuestionInfo.class);
			for (QuestionInfo loginUser : list2) {
				if(loginUser.getQuestion().equals(question)){
					question_num = loginUser.getId();//获取到更新后题目的id
					break;
				}			
			}
			
			//向result_info中插入数据
			sql = "INSERT INTO result_info VALUES(null,?,?,?,?,?)";
			super.result_update(sql, question_num, resultSelection);
			System.out.println("result_info更新完毕");
			
			return paper_id;
		}
		
		//根据教师出的题向数据库中插入相关数据
				public void addQuestionNext(Question info){
					//String title = info.getTitle();
					//String description = info.getDescription();
					//String teacherName = info.getTeacher_name();
					System.out.println("进入questionNext处理增加");
					String question = info.getQuestion();
					String answer1 = info.getAnswerA1();
					String answer2 = info.getAnswerB1();
					String answer3 = info.getAnswerC1();
					String answer4 = info.getAnswerD1();
					int resultSelection = info.getResult_selection();
					int paper_id = info.getPaper_id();//取到套题的id
					int question_num = 0;//更新完之后题目的id
					//int genre_id = info.getGenre_id();
					//int teacher_id = 1;
					//int paper_id = 0;//更新完之后套题的id
					//int question_num = 0;//更新完之后题目的id
					//System.out.println("获取到教师的姓名："+teacherName+" Title:"+title);
					
//					//根据教师姓名查找到对应教师ID
//					String sql = "select * from teacher_info";
//					List<Teacher> list=super.query1(sql, Teacher.class);
//					for (Teacher loginUser : list) {
//						if(loginUser.getName().equals(teacherName)){
//							teacher_id = loginUser.getId();//获取到教师ID
//							break;
//						}			
//					}
					
//					//向paper_info表中插入数据
//					sql = "INSERT INTO paper_info VALUES(null,'"+title+"','"+description+"',?,?)";
//					super.paper_update(sql, teacher_id, genre_id);
//					System.out.println("paper_info更新完毕");
//					
//					//查找到更新后题的paper_id
//					sql = "SELECT * FROM paper_info";
//					List<Paper> list1 = super.query1(sql, Paper.class);
//					for (Paper loginUser : list1) {
//						if(loginUser.getTitle().equals(title)){
//							paper_id = loginUser.getId();//获取到Paper中题目ID
//							break;
//						}			
//					}
					
					//向question_info表中插入数据
					System.out.println("接收到的question:"+question+" answer1:"+answer1+"paper_id:"+paper_id);
					String sql = "INSERT INTO question_info VALUES(null,'"+question+"','"+answer1+"','"+answer2+"','"+answer3+"','"+answer4+"',?)";
					super.question_update(sql, paper_id);
					System.out.println("question_info更新完毕");
					
					//查找到更新后question_info中id
					sql = "SELECT * FROM question_info";
					List<QuestionInfo> list2 = super.query1(sql, QuestionInfo.class);
					for (QuestionInfo loginUser : list2) {
						if(loginUser.getQuestion().equals(question)){
							question_num = loginUser.getId();//获取到更新后题目的id
							break;
						}			
					}
					
					//向result_info中插入数据
					sql = "INSERT INTO result_info VALUES(null,?,?,?,?,?)";
					super.result_update(sql, question_num, resultSelection);
					System.out.println("result_info更新完毕");
				}		
		
		//返回用户在查找到的相应的市场人员信息
//		public List<UserMarket> searchUserMarket(String title){
//			String sql="select * from usermarket_info where title="+title;
//			List<UserMarket> list=super.query1(sql, UserMarket.class);
//			return list;
//		}
		
		//将新用户账号和密码信息存入数据库中vote_user表中未修改！！！！！！！
//		public void saveUser(String userName,String password){
//			String sql="insert into user_info values(null,'"+userName+"','"+password+"',1);";
//			super.update(sql);
//			
//		}
		//根据paper_id查找出所有题目基本信息
		public List<QuestionDetail> searchAllQuestion(int paper_id){
			String sql = "SELECT * FROM question_info";
			List<QuestionInfo> list = super.query1(sql, QuestionInfo.class);//读取Question——info中的所有数据
			List<QuestionDetail> list1 = new ArrayList<QuestionDetail>();
			
			for (QuestionInfo loginUser : list) {
				if(loginUser.getPaper_id()==paper_id){//若是和已知套题的id相同
					QuestionDetail questionDetail = new QuestionDetail();
					questionDetail.setId(loginUser.getId());
					questionDetail.setQuestion(loginUser.getQuestion());
					questionDetail.setAnswer1(loginUser.getAnswer1());
					questionDetail.setAnswer2(loginUser.getAnswer2());
					questionDetail.setAnswer3(loginUser.getAnswer3());
					questionDetail.setAnswer4(loginUser.getAnswer4());
					questionDetail.setPaper_id(loginUser.getPaper_id());
					//temp = loginUser;
					int question_num = loginUser.getId();//获取到题目的编号
					sql = "SELECT * FROM result_info";
					List<Result> list2 = super.query1(sql, Result.class);//查询所有题目的答案
					for (Result loginUser1 : list2) {
						if(loginUser1.getQuestion_num() == question_num){//若是题号和答案中的题号相同
							System.out.println("question_num:"+question_num+"result中的id:"+loginUser1.getId());
							if(loginUser1.getSelection1()==1){
								questionDetail.setResult("A");
							}else if(loginUser1.getSelection2()==1){
								questionDetail.setResult("B");
							}else if(loginUser1.getSelection3()==1){
								questionDetail.setResult("C");
							}else if(loginUser1.getSelection4()==1){
								questionDetail.setResult("D");
							}
							//break;
						}
					}
					//System.out.println("add之前查找的"+questionDetail.getQuestion());
					System.out.println("改变。。。");
					list1.add(questionDetail);
					//System.out.println("add之后查找的"+list1.get(0).getQuestion());
					//System.out.println("add之后的size:"+list1.size());
					//System.out.println("-----------"+list1.get(list1.size()-1).getQuestion());
				}
				//System.out.println("-----------"+list1.get(0).getQuestion());
			}
			//System.out.println("size："+list1.size()+" -----"+list1.get(2).getQuestion());
			return list1;
		}
		
				
		//查询出所有题目信息的情况
		public List<Paper> searchAllPaper(){
			String sql = "SELECT * FROM paper_info";
			List<Paper> list = super.query1(sql, Paper.class);
			//Paper temp = new Paper();
			List<Paper> list1 = new ArrayList<Paper>();
			for (Paper loginUser : list) {
				//if(loginUser.getGenre_id()==1){
					//temp = loginUser;
					list1.add(loginUser);					
				//}			
			}	
			return list1;
		}
		
		//根据老师姓名查出对应的卷子
		public List<PaperInfoByTeacher> searchAllPaperByTeacher(String teacherName){
			//根据教师姓名取出对应的id
			int teacher_id=0;
			String sql = "SELECT * FROM teacher_info";
			List<Teacher> list = super.query1(sql, Teacher.class);
			List<PaperInfoByTeacher> list0 = new ArrayList<PaperInfoByTeacher>();
			for (Teacher loginUser : list) {
				if(loginUser.getName().equals(teacherName)){
					teacher_id = loginUser.getId();
					break;				
				}			
			}
			
			//根据教师id查找对应的卷子，并存在list中
			sql = "SELECT * FROM paper_info";
			List<Paper> list2 = super.query1(sql, Paper.class);
			for (Paper loginUser : list2) {
				if(loginUser.getTeacher_id() == teacher_id){
					//根据分类的id在genre_info表中查找到对应的类型
					String genreName="";
					String sql1 = "SELECT * FROM genre_info";
					List<Genre> tempList = super.query1(sql1, Genre.class);
					for (Genre lo : tempList) {
						if(lo.getId() == loginUser.getGenre_id()){//若genreid相同
							genreName = lo.getGenre();
							break;				
						}			
					}
					PaperInfoByTeacher paperInfo = new PaperInfoByTeacher();
					paperInfo.setId(loginUser.getId());
					paperInfo.setTitle(loginUser.getTitle());
					paperInfo.setDescription(loginUser.getDescription());
					paperInfo.setTeacher_name(teacherName);
					paperInfo.setGenre(genreName);
					list0.add(paperInfo);					
				}			
			}
			return list0;
		}
		
		//根据paper_id查找到相应的具体题目信息
		public List<QuestionInfo> searchAllQuestion2(){
			String sql = "SELECT * FROM question_info";
			List<QuestionInfo> list = super.query1(sql, QuestionInfo.class);
			List<QuestionInfo> list1 = new ArrayList<QuestionInfo>();
			for (QuestionInfo loginUser : list) {
				if(loginUser.getPaper_id()==1){
					//temp = loginUser;
					list1.add(loginUser);					
				}			
			}
			return list1;
		}
		
		public static void main(String[] args){
			UserDao ud=new UserDao();
			List<Paper> list = ud.searchAllPaper();
			System.out.println("查找到paper_info中的信息:"+list.get(0).getDescription());
			List<QuestionInfo> list1 = ud.searchAllQuestion2();
			System.out.println("查找到Question中的信息:"+list1.get(1).getQuestion());
		}
}
