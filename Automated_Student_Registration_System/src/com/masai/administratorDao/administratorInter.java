package com.masai.administratorDao;


import java.util.List;

import com.masai.Exception.administratorException;
import com.masai.been.Course;
import com.masai.been.studentDetail;

public interface administratorInter {
	
	public boolean login(String name,String password) throws administratorException ;
	
	public String feesUpdate(String name,int fees)throws administratorException;
	
	public String addNewCourse(Course course)throws administratorException;
	
	public String deleteCourse(int batchNum)throws administratorException;
	
	
	public String SearchInfoCourse(String name) throws administratorException;
	
	public String CreateBatchUnderC(String name,int seats) throws administratorException;
	
	public String UpdateSeats(int batchNum, int Seats) throws administratorException;
	
	public List<studentDetail> allStudentEveryB()throws administratorException;
	
	
	//public String allocate(String name,String Course)throws administratorException;



}
