package com.xupt.dao;

public class TestDB {

	public static void main(String[] args) {
		UserDao ud=new UserDao();
		System.out.println(ud.isExistUser("sunny"));
		
	}

}
