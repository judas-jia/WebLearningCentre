package com.xupt.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.beanutils.ConvertUtils;




public class BaseDao {
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;

	
	public void getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/weblearning_db","root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getConnByPool(){
		try {
			Context cx=new InitialContext();
			DataSource ds=(DataSource)cx.lookup("java:comp/env/jdbc/weblearning_db");
			conn=ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//增删改
	public int update(String sql){
		this.getConn();
		try {
			stmt=conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally{
			close();
		}
	}
	//paper表的增删改
	public int paper_update(String sql,int teacher_id,int genre_id){
		this.getConn();
		try {
			PreparedStatement psql;
			stmt=conn.createStatement();
			psql = conn.prepareStatement(sql);
			psql.setInt(1, teacher_id);
			psql.setInt(2, genre_id);
			
			return psql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally{
			close();
		}
	}
	//question_info表的增删改
	public int question_update(String sql,int paper_id){
		this.getConn();
		try {
			PreparedStatement psql;
			stmt=conn.createStatement();
			psql = conn.prepareStatement(sql);
			psql.setInt(1, paper_id);
			
			return psql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally{
			close();
		}
	}
	//result_info表的增删改
	public int result_update(String sql,int question_num,int result_selection){
		this.getConn();
		try {
			PreparedStatement psql;
			stmt=conn.createStatement();
			psql = conn.prepareStatement(sql);
			psql.setInt(1, question_num);
			psql.setInt(2, 0);
			psql.setInt(3, 0);
			psql.setInt(4, 0);
			psql.setInt(5, 0);
			psql.setInt(result_selection+1, 1);
			return psql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally{
			close();
		}
	}
	//查询方法(升级)
	public List query1(String sql,Class cls){
		List list=new ArrayList();
		this.getConn();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				Object obj=cls.newInstance();
				Field[]fields=cls.getDeclaredFields();
				for (Field field : fields) {
					String fname=field.getName();
					Method method=cls.getDeclaredMethod("set"+fname.substring(0, 1).toUpperCase()+fname.substring(1), field.getType());
					method.invoke(obj, ConvertUtils.convert(rs.getObject(fname), field.getType()));
				}
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}
	public void close(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
