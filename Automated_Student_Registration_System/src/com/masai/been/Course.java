package com.masai.been;

public class Course {
	
	private int C_id;
	private String C_name;
	private int C_fees;
	private String C_duration;
	
	
	public Course(int c_id, String c_name, String c_duration) {
		super();
		C_id = c_id;
		C_name = c_name;
		C_duration = c_duration;
	}


	public Course() {
		// TODO Auto-generated constructor stub
	}


	public int getC_id() {
		return C_id;
	}


	public void setC_id(int c_id) {
		C_id = c_id;
	}


	public String getC_name() {
		return C_name;
	}


	public void setC_name(String c_name) {
		C_name = c_name;
	}


	public int getC_fees() {
		return C_fees;
	}


	public void setC_fees(int c_fees) {
		C_fees = c_fees;
	}


	public String getC_duration() {
		return C_duration;
	}


	public void setC_duration(String c_duration) {
		C_duration = c_duration;
	}


	@Override
	public String toString() {
		return "Course [C_id=" + C_id + ", C_name=" + C_name + ", C_fees=" + C_fees + ", C_duration=" + C_duration
				+ "]";
	}
	
	

}
