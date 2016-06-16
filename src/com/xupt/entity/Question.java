package com.xupt.entity;

public class Question {
	private String title;
	private String description;
	private int teacher_id;
	private String teacher_name;
	private int genre_id;
	private int paper_id;
	private String question;
	private String answerA1;
	private String answerB1;
	private String answerC1;
	private String answerD1;
	private int result_selection;
	
	
	public int getPaper_id() {
		return paper_id;
	}
	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswerA1() {
		return answerA1;
	}
	public void setAnswerA1(String answerA1) {
		this.answerA1 = answerA1;
	}
	public String getAnswerB1() {
		return answerB1;
	}
	public void setAnswerB1(String answerB1) {
		this.answerB1 = answerB1;
	}
	public String getAnswerC1() {
		return answerC1;
	}
	public void setAnswerC1(String answerC1) {
		this.answerC1 = answerC1;
	}
	public String getAnswerD1() {
		return answerD1;
	}
	public void setAnswerD1(String answerD1) {
		this.answerD1 = answerD1;
	}
	public int getResult_selection() {
		return result_selection;
	}
	public void setResult_selection(int result_selection) {
		this.result_selection = result_selection;
	}
	
	
	
}
