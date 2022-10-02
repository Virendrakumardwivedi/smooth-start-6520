package com.masai.administratorDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Exception.administratorException;
import com.masai.StudentDao.studentimpl;
import com.masai.been.Course;
import com.masai.been.studentDetail;
import com.masai.utility.DBconnaction;
import java.util.ArrayList;

public class administratorIMP implements administratorInter {

	@Override
	public boolean login(String name, String password) throws administratorException {
		
		
		try(Connection con = DBconnaction.connect()){
			PreparedStatement pr =con.prepareStatement
					("select * from Administrator where username=? and password=?" );
			pr.setString(1, name);
			pr.setString(2, password);

			ResultSet rs=pr.executeQuery();

			if(rs.next()) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			throw new administratorException(e.getMessage());

			
		}
		
		
		
	}

	@Override
	public String feesUpdate(String name, int fees) throws administratorException {
		
	try(Connection con = DBconnaction.connect()){
		
	PreparedStatement pre =	con.prepareStatement("select * from course where C_name=? ");
	pre.setString(1, name);
	
	ResultSet resu = pre.executeQuery();
	
	if(resu.next()) {
		PreparedStatement pr = con.prepareStatement("update course set C_fees=? where C_name=?");
		pr.setInt(1, fees);
		pr.setString(2, name);
		
		
		int x=pr.executeUpdate();
		
		if(x>0){
			System.out.println("course fess updated successfully");
			
		}else {
		throw new administratorException("error...!");
		}
			
	}else {
 		throw new administratorException("no user found with this username");

	}
	
	}catch(Exception e) {
		throw new administratorException(e.getMessage());
	}
	return name;
		
		
		
	}
	
//*********************************************************************************************************************************//
	
	
	@Override
	public String addNewCourse(Course course) throws administratorException {
		String message="not insert";
		
		try(Connection conn = DBconnaction.connect()){
			
			PreparedStatement precd = conn.prepareStatement("insert into course (C_name, C_fees,C_duration) values(?,?,?)");
			precd.setString(1, course.getC_name());
			precd.setInt(2, course.getC_fees());
			precd.setString(3, course.getC_duration());
			
			int x=precd.executeUpdate();
			
			if(x>0) {
				message ="course inserted successful";
			}
	
		}catch(SQLException e) {
			throw new administratorException(e.getMessage());
		}
		return message;
	

	}
	
	
	

	
//**********************************************************************************************************************************************************//

	
	@Override
	public String deleteCourse(int batchNum) throws administratorException {
		String message="not deleted";
		try(Connection con =  DBconnaction.connect()){
			
			PreparedStatement pr = con.prepareStatement("delete from batch where B_no=?");
			
			pr.setInt(1, batchNum);
			
			int result = pr.executeUpdate();
			
			
				
				if(result>0) {
					message= "course deleted of traning session";
				}else {
					throw new administratorException("error....!");
				}
				
			}
			
		catch(SQLException e) {
			throw new administratorException(e.getMessage());
			
		}
		return message;
		
}
	
//**********************************************************************************************************************************************************//


	@Override
	public String SearchInfoCourse(String name) throws administratorException {
		
		
		try(Connection con =  DBconnaction.connect()){
			
			PreparedStatement pr = con.prepareStatement("select * from course where C_name = ?");
			pr.setString(1, name);
			
			ResultSet result = pr.executeQuery();
			
			if(result.next()) {
		 		return"course id : " +result.getInt("C_id")+"/"+" coursename : "+result.getString("C_name")+"/"+" Total-Fee : "+result.getInt("C_fees")+"/"+" Duration : "+result.getString("C_duration");

			}else {
				throw new administratorException("error....!");
			}
			
		}catch(Exception e) {
			throw new administratorException(e.getMessage());
	
		}
	}
	
//**********************************************************************************************************************************************************//


	@Override
	public String CreateBatchUnderC(String name, int seats) throws administratorException {

     try(Connection con =  DBconnaction.connect()){
    	 PreparedStatement pr = con.prepareStatement("select * from course where C_name=?");
    	 pr.setString(1, name);
    	
    	 
    	 ResultSet result = pr.executeQuery();
    	 
    	 if(result.next()) {
    		 PreparedStatement pre = con.prepareStatement("insert into batch (C_n2,seats) values(?,?)");
    		 pre.setString(1, name);
    		 pre.setInt(2, seats);
    		 
    		 
    		 int x = pre.executeUpdate();
    		 
    		 if(x>0) {
    			 return "New batch created successfully ";
    		 }else {
    			 throw new administratorException("error...!");
    		 }
    		 
    	 }else {
    		 throw new administratorException("error....!");
    	 }
    	 
    	 
     }catch(Exception e) {
    	 throw new administratorException(e.getMessage());
     }
	

	}

	
//**********************************************************************************************************************************************************//
	
	
	
	
	
	//@Override
//	public String AllocateBatch(int batchNum, int seats) throws administratorException {
		
//		try( Connection con = DBconnaction.connect()){
//			PreparedStatement pr = con.prepareStatement("select * from batch where B_no= ?");
//			pr.setInt(1, batchNum);
//			
//			ResultSet result = pr.executeQuery();
//
//			if(result.next()) {
//					
//				PreparedStatement pr = con.prepareStatement("");
//					
//			}else {
//				throw new administratorException("error....!");
//			}
//			
	
//		}catch(Exception e) {
//			throw new administratorException(e.getMessage());
//		}
		
//		return null;
//	}
//	
	
//***************************************************************************************************************************//

	@Override
	public String UpdateSeats(int batchNum, int Seats) throws administratorException {
String message="Not updated";
		try(Connection con =  DBconnaction.connect()){
			
			PreparedStatement pr = con.prepareStatement("update batch set seats=? where B_no=?");
			pr.setInt(2, batchNum);
			pr.setInt(1, Seats);
			
			int x = pr.executeUpdate();
				
				if(x>0) {
					message=  "Seats updated successfuly -->";
				}else {
					throw new administratorException("error....!");
				}	
				
			
		}catch(SQLException e) {
			throw new administratorException(e.getMessage());
			
		}
		
		return message;
	
	}

@Override
public List<studentDetail> allStudentEveryB() throws administratorException {

	List<studentDetail> stu = new ArrayList<>();
	try(Connection con =  DBconnaction.connect()){
		PreparedStatement pr  = con.prepareStatement("select student.S_id,student.S_name,student.S_email, batch.B_no,batch.C_n2 from (student inner join batch on student.S_id = batch.B_no)");
		
	ResultSet result = 	pr.executeQuery();
	
	while(result.next()){
		
	int s1 = 	result.getInt("S_id");
	String s2=	result.getString("S_name");
	String s3 =	result.getString("S_email");
	int s4 = 	result.getInt("B_no");
	String s5 = result.getString("C_n2");
		
     studentDetail stu1  = new studentDetail(s1, s2, s3, s4, s5);	
		stu.add(stu1);
	}
		
	
	}catch(SQLException e) {
		throw new administratorException(e.getMessage());
	}
	
	return stu;	
}

}
//	
//*************************************************************************************************************************************//	
	

//	@Override
//	public ArrayList<String> allStudentEveryB() throws administratorException {
//		
//		
//		try(Connection con =  DBconnaction.connect()){
//			
//			ArrayList<String> aSEB = new ArrayList<>();
//
//			
//PreparedStatement pr = con.prepareStatement(" select B_no,seats,S_id,S_name,C_name,C_duration,C_fees,C_id from batch inner join student inner join student_batch inner join course on B_no=B_no2 and S_id = S_id2 and C_n2=C_name");	
//
//boolean flag = true;
//
//ResultSet result = pr.executeQuery();
//
//while(result.next()) {
//	flag=false;
//	
//	aSEB.add
//	(result.getInt("S_id")+"---"+result.getString("S_name")+"--"+result.getInt("C_id")+"--"+
//			result.getString("C_name")+"--"+result.getInt("C_fees")+"--"+result.getString("C_duration")+"--"+
//			result.getInt("B_no"));
//	
//}
//
//if(flag) {
//	throw new administratorException("error...!");
//}else {
//	return aSEB ;
//}
//		
//			
//		}catch(SQLException e) {
//			throw new administratorException(e.getMessage());
//		}
//		
//	}
//
//}
//	
//	
	
	//------------------------------------------------------------------------------------------------------------
	
	
	
//	@Override
//	public String allocate(String name, String Course) throws administratorException {
//
//		try(Connection con =  DBconnaction.connect()){
//			
//			
//			PreparedStatement pr = con.prepareStatement("select * from course inner join batch where C_no2=C_name and C_name=?");
//            pr.setString(1,Course);
//            
//            ResultSet result = pr.executeQuery();
//            
//            if(result.next()) {
//            	PreparedStatement pr1  = con.prepareStatement("select * from student where name =?");
//            	pr1.setString(1,name);
//            	
//            	 ResultSet result1 = pr.executeQuery();
//            	 
//            	 if(result1.next()) {
//            		 PreparedStatement pr2 = con.prepareStatement("select * from Student_batch inner join batch where B_no2=B_no and S_id2=? and C_no2");
//            		 pr2.setInt(1,result1.getInt("S_id") );
// 					pr2.setString(2,result.getString("C_name"));
// 				 	ResultSet result3=pr2.executeQuery();
//            		
// 				 	 boolean flag=true;
// 				 	flag=false;
//		 	        break;
// 				 	 
// 				 	 while(result3.next()) {
// 				 		 PreparedStatement pr3  = con.prepareStatement("insert int student_batch values(?,?)");
// 				 		pr3.setInt(1,result1.getInt("S_id") );
//						pr3.setInt(2,result.getInt("B_no"));
// 				 		 
//						
//		                  int x = pr3.executeUpdate();
//		                  if(x>0) {
//		                	  return "Student alocated";
//		                  }else {
//		                	  throw new administratorException("error...!");
//		                  }
// 				 	 }else {
// 				 		throw new administratorException("error accured ");
// 				 	 }
//            	 }
//            	 else {
//            		 throw new administratorException("error accured ");
//            	 }
//            }
//			
//			
//			
//			
//			
//			
//			
//			
//		}catch(Exception e) {
//			throw new administratorException(e.getMessage());
//		}
//		
//		
//		
//	}


//}
