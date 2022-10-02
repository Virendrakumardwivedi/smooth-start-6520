package com.masai.StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.masai.Exception.StudentException;
import com.masai.utility.DBconnaction;







public class studentimpl implements StudentInterface {

	@Override
	public boolean login(String name, String pass) throws StudentException{
try (Connection conn=DBconnaction.connect()){
			
			PreparedStatement pr =conn.prepareStatement("select * from student where S_name=? and S_password=? " );
			pr.setString(1, name);
			pr.setString(2, pass);

	     	ResultSet result=pr.executeQuery();
	     	if(result.next()) {
               
	     		return true;
			
	     	}else {
	     		
	     		return false;
	     	}
				
			} catch (SQLException e) {
				throw new StudentException(e.getMessage());
				// TODO: handle exception
			}
	

	}
	
	//*****************************************************************************************************************//

	
	
	@Override
	public String SingUpfun(String name, String pass, String email) throws StudentException {
		
		
		
		 
		  try (Connection conn = DBconnaction.connect()){ 
			PreparedStatement ps =   conn.prepareStatement("select * from student where S_name=? ");
			ps.setString(1, name);
			
			
			ResultSet rs=ps.executeQuery();
	     	if(rs.next()) {
	     		
	     		throw new StudentException("user name already there please use another");

	     		
	     	}else {
			
			
	     		PreparedStatement pst =conn.prepareStatement("insert into Student(S_name,S_password,S_email) values(?,?,?)" );
	    		pst.setString(1, name);
	    		pst.setString(2, pass);
	    		pst.setString(3, email);
	    		
	    		int x=pst.executeUpdate();
	    		
	    		if(x>0) {
	    			return "signup successfull";
	    		}else {
	    		
	    			throw new StudentException("error...!");
	    		}
			
			
	     	}
			
		
		  }catch(SQLException e) {
		throw new StudentException(e.getMessage());
		  }
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//*****************************************************************************************************************//

	



	@Override
	public String update(String Sname) throws StudentException {
	
		try(Connection con = DBconnaction.connect() ){
			
			Scanner sce=new Scanner(System.in);
			System.out.println();
			System.out.println("please select a operation you want to perform");
			System.out.println("1 : update username");
			System.out.println("2 : update password");
			System.out.println("3 : update email");
			System.out.println("4 : exit");
			int insertValue=sce.nextInt();
			
			
			
           while (insertValue!=4) {
				
				if(insertValue==1) {
					
					System.out.println("enter new name");
					String Name=sce.next();
					
					PreparedStatement aaa =con.prepareStatement("select * from student where S_name=? " );
					aaa.setString(1, Name);

			     	ResultSet result=aaa.executeQuery();
			     	if(result.next()) {

			     		throw new StudentException("This is student avilable plz insert other name");
					
			     	}else {
			     		
			     		PreparedStatement pst =con.prepareStatement("update student set S_name=? where S_name=?" );
			    		pst.setString(1, Name);
			    		pst.setString(2, Sname);
			    		
			    		int x=pst.executeUpdate();
			    		
			    		if(x>0) {
			    			return "name updated";
			    		}else {
			    			throw new StudentException("error...!");
			    		}

			     	}
		
				}else if(insertValue==2) {
					
					System.out.println("enter new password");
					String npass=sce.next();
					
			  	
			     		PreparedStatement pst =con.prepareStatement("update student set S_password=? where S_name=?" );
			    		pst.setString(1, npass);
			    		pst.setString(2, Sname);
			    		
			    		int x=pst.executeUpdate();
			    		
			    		if(x>0) {
			    			return "password updated";
			    		}else {
			    			throw new StudentException("error...!");
			    		}				
				}else if(insertValue==3) {
				
					  System.out.println("enter new email");
					  String email=sce.next();
					
			     		PreparedStatement pst =con.prepareStatement("update student set S_email=? where S_name=?" );
			    		pst.setString(1, email);
			    		pst.setString(2, Sname);
			    		
			    		int x=pst.executeUpdate();
			    		
			    		if(x>0) {
			    			return "password updated";
			    		}else {
			    			throw new StudentException("error...!");
			    		}
					
				}
				else {
					
					System.out.println("please select a valid option");
					System.out.println();
					System.out.println("please select a operation you want to perform");
					System.out.println("1 : update username");
					System.out.println("2 : update password");
					System.out.println("3 : update gender");
					System.out.println("4 : exit");
					insertValue=sce.nextInt();
				}
	
			}
	
			
			
		}catch(SQLException e) {
			throw new StudentException(e.getMessage());	
		}
		return Sname;
		
		
	}

	
	
	
	//*****************************************************************************************************************//

	@Override
	public ArrayList<String> SeeAllD() throws StudentException {
		
try(Connection con = DBconnaction.connect()){
			
			ArrayList<String> al = new ArrayList<>();
			
			PreparedStatement pr = con.prepareStatement("select C_id, C_name,C_duration,C_fees,sum(seats) from course inner join batch where C_n2=C_name group by C_name");
			
			ResultSet rs = pr.executeQuery();
			
			boolean flag = true;
			
			while(rs.next()) {
				flag=false;
				
				al.add("course id=>" +rs.getInt("C_id")+"**"+" coursename=> "+rs.getString("C_name")+"** "+" Total Fee=>"+rs.getInt("C_fees")+"**"+" Duration =>"+rs.getString("C_duration")+"**"+" Total Seats==> "+rs.getInt("sum(seats)"));
				
				
			}if(flag) {
				throw new StudentException("data not present");
			}else {
				return al;
			}
			
			
			
			
			
		}catch(SQLException e) {
			throw new StudentException(e.getMessage());
		
	}
	
	}
	

}
