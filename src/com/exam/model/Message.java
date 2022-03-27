package com.exam.model;



/**
 * 监考信息封装类对象
 * @author 1
 *
 */
public class Message {
	private int mid;  //信息编号
	private String subject;//考试科目
	private String teacher;//监考人员
	private String date;//时间
	private String place;//地点
	public int getMid() {
		return mid;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Student [mid=" + mid + ", subject=" + subject + ", teacher=" + teacher + ", date=" + date + ", place="
				+ place + "]";
	}
	

	

}
