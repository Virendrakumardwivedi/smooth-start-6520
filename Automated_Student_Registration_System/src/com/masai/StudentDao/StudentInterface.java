package com.masai.StudentDao;

import java.util.ArrayList;

import com.masai.Exception.StudentException;

public interface StudentInterface {
	
    public boolean login(String name,String pass)throws StudentException ;

	public String SingUpfun(String name,String pass,String email)throws StudentException;
	
	public String update(String Sname)throws StudentException ;

	public ArrayList<String> SeeAllD()throws StudentException;

}
