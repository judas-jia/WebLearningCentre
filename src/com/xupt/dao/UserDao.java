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
	//�����ڵ�¼ʱ�ж��û����������Ƿ���ȷ
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
	//ע��ѧ����Ϣ�����
	public void registerByStudent(String userName,String password){
		String sql = "INSERT INTO student_info VALUES(null,'"+userName+"','"+password+"','"+userName+"')";
		super.update(sql);
		System.out.println("ѧ����Ϣ�ɹ�����");
	}
	//ע���ʦ��Ϣ�����
	public void registerByTeacher(String userName,String password){
		String sql = "INSERT INTO teacher_info VALUES(null,'"+userName+"','"+password+"','"+userName+"')";
		super.update(sql);
		System.out.println("��ʦ��Ϣ�ɹ�����");
	}
	//ע��ѧ����Ϣ�����
	public void registerByAdmin(String userName,String password){
		String sql = "INSERT INTO admin_info VALUES(null,'"+userName+"','"+password+"','"+userName+"')";
		super.update(sql);
		System.out.println("����Ա��Ϣ�ɹ�����");
	}
		
	//�����ڵ�¼ʱ�ж��û����������Ƿ���ȷͨ��ѧ����Ϣ��
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
	//�����ڵ�¼ʱ�ж��û����������Ƿ���ȷͨ����ʦ��Ϣ��
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
		//�����ڵ�¼ʱ�ж��û����������Ƿ���ȷͨ������Ա��Ϣ��
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
	
		//������ע���û�ʱ�ж����ݿ����Ƿ���ڴ��û�
		public boolean isExistUser(String userName){
			boolean flag=false;//false�����ݿ���û���ظ����û�
			String sql="select * from student_info";
			List<Student> list=super.query1(sql, Student.class);
			for (Student loginUser : list) {
				if(loginUser.getName().equals(userName)){
					flag=true;//��ʱ���ݿ����д��û�����
					break;
				}
			}
			return flag;
		}
		
		//����sudent_info������ѧ��������Ϣ
		public List<Student> searchAllStudent(){
			String sql = "SELECT * FROM student_info";
			List<Student> list = super.query1(sql, Student.class);
			return list;
		}
		//����teacher_info�����н�ʦ������Ϣ
		public List<Teacher> searchAllTeacher(){
			String sql = "SELECT * FROM teacher_info";
			List<Teacher> list = super.query1(sql, Teacher.class);
			return list;
		}
		
		//����Ա��������ɾ����Ӧ�Ľ�ʦ
		public void deleteTeacherInfo(String name){
			System.out.println("Ҫɾ���Ľ�ʦ����:"+name);
			String sql = "DELETE FROM teacher_info WHERE name = '"+name+"'";
			super.update(sql);
		}
		
		//����Ա��������ɾ����Ӧ��ѧ��
		public void deleteStudentInfo(String name){
			System.out.println("Ҫɾ���Ľ�ʦ����:"+name);
			String sql = "DELETE FROM student_info WHERE name = '"+name+"'";
			super.update(sql);
		}
		
		//�����û��ڲ��ҵ�����Ӧ��ѧ���û�����
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
		
		//�����û��ڲ��ҵ�����Ӧ�Ľ�ʦ�û�����
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
		
		//���ݽ�ʦ�����������ݿ��в����������(���������id)
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
			int paper_id = 0;//������֮�������id
			int question_num = 0;//������֮����Ŀ��id
			System.out.println("��ȡ����ʦ��������"+teacherName+" Title:"+title);
			
			//���ݽ�ʦ�������ҵ���Ӧ��ʦID
			String sql = "select * from teacher_info";
			List<Teacher> list=super.query1(sql, Teacher.class);
			for (Teacher loginUser : list) {
				if(loginUser.getName().equals(teacherName)){
					teacher_id = loginUser.getId();//��ȡ����ʦID
					break;
				}			
			}
			
			//��paper_info���в�������
			sql = "INSERT INTO paper_info VALUES(null,'"+title+"','"+description+"',?,?)";
			super.paper_update(sql, teacher_id, genre_id);
			System.out.println("paper_info�������");
			
			//���ҵ����º����paper_id
			sql = "SELECT * FROM paper_info";
			List<Paper> list1 = super.query1(sql, Paper.class);
			for (Paper loginUser : list1) {
				if(loginUser.getTitle().equals(title)){
					paper_id = loginUser.getId();//��ȡ��Paper����ĿID
					break;
				}			
			}
			
			//��question_info���в�������
			System.out.println("���յ���question:"+question+" answer1:"+answer1+"paper_id:"+paper_id);
			sql = "INSERT INTO question_info VALUES(null,'"+question+"','"+answer1+"','"+answer2+"','"+answer3+"','"+answer4+"',?)";
			super.question_update(sql, paper_id);
			System.out.println("question_info�������");
			
			//���ҵ����º�question_info��id
			sql = "SELECT * FROM question_info";
			List<QuestionInfo> list2 = super.query1(sql, QuestionInfo.class);
			for (QuestionInfo loginUser : list2) {
				if(loginUser.getQuestion().equals(question)){
					question_num = loginUser.getId();//��ȡ�����º���Ŀ��id
					break;
				}			
			}
			
			//��result_info�в�������
			sql = "INSERT INTO result_info VALUES(null,?,?,?,?,?)";
			super.result_update(sql, question_num, resultSelection);
			System.out.println("result_info�������");
			
			return paper_id;
		}
		
		//���ݽ�ʦ�����������ݿ��в����������
				public void addQuestionNext(Question info){
					//String title = info.getTitle();
					//String description = info.getDescription();
					//String teacherName = info.getTeacher_name();
					System.out.println("����questionNext��������");
					String question = info.getQuestion();
					String answer1 = info.getAnswerA1();
					String answer2 = info.getAnswerB1();
					String answer3 = info.getAnswerC1();
					String answer4 = info.getAnswerD1();
					int resultSelection = info.getResult_selection();
					int paper_id = info.getPaper_id();//ȡ�������id
					int question_num = 0;//������֮����Ŀ��id
					//int genre_id = info.getGenre_id();
					//int teacher_id = 1;
					//int paper_id = 0;//������֮�������id
					//int question_num = 0;//������֮����Ŀ��id
					//System.out.println("��ȡ����ʦ��������"+teacherName+" Title:"+title);
					
//					//���ݽ�ʦ�������ҵ���Ӧ��ʦID
//					String sql = "select * from teacher_info";
//					List<Teacher> list=super.query1(sql, Teacher.class);
//					for (Teacher loginUser : list) {
//						if(loginUser.getName().equals(teacherName)){
//							teacher_id = loginUser.getId();//��ȡ����ʦID
//							break;
//						}			
//					}
					
//					//��paper_info���в�������
//					sql = "INSERT INTO paper_info VALUES(null,'"+title+"','"+description+"',?,?)";
//					super.paper_update(sql, teacher_id, genre_id);
//					System.out.println("paper_info�������");
//					
//					//���ҵ����º����paper_id
//					sql = "SELECT * FROM paper_info";
//					List<Paper> list1 = super.query1(sql, Paper.class);
//					for (Paper loginUser : list1) {
//						if(loginUser.getTitle().equals(title)){
//							paper_id = loginUser.getId();//��ȡ��Paper����ĿID
//							break;
//						}			
//					}
					
					//��question_info���в�������
					System.out.println("���յ���question:"+question+" answer1:"+answer1+"paper_id:"+paper_id);
					String sql = "INSERT INTO question_info VALUES(null,'"+question+"','"+answer1+"','"+answer2+"','"+answer3+"','"+answer4+"',?)";
					super.question_update(sql, paper_id);
					System.out.println("question_info�������");
					
					//���ҵ����º�question_info��id
					sql = "SELECT * FROM question_info";
					List<QuestionInfo> list2 = super.query1(sql, QuestionInfo.class);
					for (QuestionInfo loginUser : list2) {
						if(loginUser.getQuestion().equals(question)){
							question_num = loginUser.getId();//��ȡ�����º���Ŀ��id
							break;
						}			
					}
					
					//��result_info�в�������
					sql = "INSERT INTO result_info VALUES(null,?,?,?,?,?)";
					super.result_update(sql, question_num, resultSelection);
					System.out.println("result_info�������");
				}		
		
		//�����û��ڲ��ҵ�����Ӧ���г���Ա��Ϣ
//		public List<UserMarket> searchUserMarket(String title){
//			String sql="select * from usermarket_info where title="+title;
//			List<UserMarket> list=super.query1(sql, UserMarket.class);
//			return list;
//		}
		
		//�����û��˺ź�������Ϣ�������ݿ���vote_user����δ�޸ģ�������������
//		public void saveUser(String userName,String password){
//			String sql="insert into user_info values(null,'"+userName+"','"+password+"',1);";
//			super.update(sql);
//			
//		}
		//����paper_id���ҳ�������Ŀ������Ϣ
		public List<QuestionDetail> searchAllQuestion(int paper_id){
			String sql = "SELECT * FROM question_info";
			List<QuestionInfo> list = super.query1(sql, QuestionInfo.class);//��ȡQuestion����info�е���������
			List<QuestionDetail> list1 = new ArrayList<QuestionDetail>();
			
			for (QuestionInfo loginUser : list) {
				if(loginUser.getPaper_id()==paper_id){//���Ǻ���֪�����id��ͬ
					QuestionDetail questionDetail = new QuestionDetail();
					questionDetail.setId(loginUser.getId());
					questionDetail.setQuestion(loginUser.getQuestion());
					questionDetail.setAnswer1(loginUser.getAnswer1());
					questionDetail.setAnswer2(loginUser.getAnswer2());
					questionDetail.setAnswer3(loginUser.getAnswer3());
					questionDetail.setAnswer4(loginUser.getAnswer4());
					questionDetail.setPaper_id(loginUser.getPaper_id());
					//temp = loginUser;
					int question_num = loginUser.getId();//��ȡ����Ŀ�ı��
					sql = "SELECT * FROM result_info";
					List<Result> list2 = super.query1(sql, Result.class);//��ѯ������Ŀ�Ĵ�
					for (Result loginUser1 : list2) {
						if(loginUser1.getQuestion_num() == question_num){//������źʹ��е������ͬ
							System.out.println("question_num:"+question_num+"result�е�id:"+loginUser1.getId());
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
					//System.out.println("add֮ǰ���ҵ�"+questionDetail.getQuestion());
					System.out.println("�ı䡣����");
					list1.add(questionDetail);
					//System.out.println("add֮����ҵ�"+list1.get(0).getQuestion());
					//System.out.println("add֮���size:"+list1.size());
					//System.out.println("-----------"+list1.get(list1.size()-1).getQuestion());
				}
				//System.out.println("-----------"+list1.get(0).getQuestion());
			}
			//System.out.println("size��"+list1.size()+" -----"+list1.get(2).getQuestion());
			return list1;
		}
		
				
		//��ѯ��������Ŀ��Ϣ�����
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
		
		//������ʦ���������Ӧ�ľ���
		public List<PaperInfoByTeacher> searchAllPaperByTeacher(String teacherName){
			//���ݽ�ʦ����ȡ����Ӧ��id
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
			
			//���ݽ�ʦid���Ҷ�Ӧ�ľ��ӣ�������list��
			sql = "SELECT * FROM paper_info";
			List<Paper> list2 = super.query1(sql, Paper.class);
			for (Paper loginUser : list2) {
				if(loginUser.getTeacher_id() == teacher_id){
					//���ݷ����id��genre_info���в��ҵ���Ӧ������
					String genreName="";
					String sql1 = "SELECT * FROM genre_info";
					List<Genre> tempList = super.query1(sql1, Genre.class);
					for (Genre lo : tempList) {
						if(lo.getId() == loginUser.getGenre_id()){//��genreid��ͬ
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
		
		//����paper_id���ҵ���Ӧ�ľ�����Ŀ��Ϣ
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
			System.out.println("���ҵ�paper_info�е���Ϣ:"+list.get(0).getDescription());
			List<QuestionInfo> list1 = ud.searchAllQuestion2();
			System.out.println("���ҵ�Question�е���Ϣ:"+list1.get(1).getQuestion());
		}
}
