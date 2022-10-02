package MainUSe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.Exception.StudentException;
import com.masai.Exception.administratorException;
import com.masai.StudentDao.studentimpl;
import com.masai.administratorDao.administratorIMP;
import com.masai.been.Course;
import com.masai.been.studentDetail;

public class Main {
	
	
	public static void main (String[] args) {
		
		
	    System.out.println(" --welcome to automatic Student registration System--");
	    System.out.println("@*****@*****@*****@*****@*****@*****@*****@*****@*****@");
	    System.out.println();
		System.out.println("     please select an option to  continue");
		System.out.println("------------------------------------------------------");
		System.out.println("1 : login as a Administrator");
		System.out.println("2 : login as a Student");
		System.out.println("3 : signup as a student");	
		
		administratorIMP adNew =new  administratorIMP();
		studentimpl stNew = new studentimpl();
		
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		
		
		
//******************************************************************************************************************************************//
		if(option==1) {
			System.out.println("enter administrator name");
			String name=sc.next();
			System.out.println("enter password");
			String pass=sc.next();
			
			
			try{
				
				boolean result = adNew.login(name, pass);
				if(result) {
					System.out.println("welcome YOu are now in adminsitrator database");
					System.out.println("please select an option according to the operation you want to perform");

					System.out.println("1-> update fees of course");
					System.out.println("2-> add a new course");
					System.out.println("3-> delete a course from any training session");
					System.out.println("4-> Create Batch under a course");
					System.out.println("5-> Search information about a course.");
					System.out.println("6-> Update total seats of a batch");
					System.out.println("7-> View the students of every batch");
					System.out.println("8 : Exit");
					
					int next= sc.nextInt();
					
					while(next!=8) {
						try {
							if(next==1) {
								System.out.println("Enater Course Name");
								String Cn = sc.next();
								System.out.println("Enter New Fee ");
								int fees = sc.nextInt();
								
								String res2=adNew.feesUpdate(Cn, fees);
								System.out.println(res2);		
								
							}else if(next==2) {
								
								System.out.println("Enter New Course Name");
								String Newcn=sc.next();
								System.out.println("Enter Fees For course");
								int Newfee=sc.nextInt();
								System.out.println("Enter Time duration");
								String dur=sc.next();
								Course cr = new Course();
								cr.setC_name(Newcn);
								cr.setC_fees(Newfee);
								cr.setC_duration(dur);
								
							 
							String result2 = adNew.addNewCourse(cr);
							System.out.println(result2);
								
								
							}else if(next==3) {
								System.out.println("enter batch Number");
								int BNum=sc.nextInt();
								String str4=adNew.deleteCourse(BNum);
								System.out.println(str4);
								
							}else if(next==4) {
								System.out.println("enter course name");
								String Cname=sc.next();
								System.out.println("enter Number of seats");
								int Bname=sc.nextInt();
								String str4=adNew.CreateBatchUnderC(Cname, Bname);
								System.out.println(str4);	
							}
							else if(next==5) {
								System.out.println("Enter Course Name");
								String Cname=sc.next();
								String str5=adNew.SearchInfoCourse(Cname);
								System.out.println(str5);
							}
							else if(next==6) {
								System.out.println("Enter Batch Number");
								int Bnum=sc.nextInt();
								System.out.println("Enter New Seats Number");
								int NewSeats=sc.nextInt();
								String stre6=adNew.UpdateSeats(Bnum, NewSeats);
								System.out.println(stre6);
							}
							else if(next==7) {
							List<studentDetail> std = adNew.allStudentEveryB();
							std.forEach(s-> System.out.println(s));
								
								
							
							
							
							}else {
								System.out.println("Oops..! select right option");
							}
							System.out.println();
							
							System.out.println("please select an option according to the operation you want to perform");
							System.out.println("1-> update fees of course");
							System.out.println("2-> add a new course");
							System.out.println("3-> delete a course from any training session");
							System.out.println("4-> Create Batch under a course");
							System.out.println("5-> Search information about a course.");
							System.out.println("6-> Update total seats of a batch");
							System.out.println("7-> View the students of every batch");
							System.out.println("8 : Exit");
							
							next=sc.nextInt();
							
						}catch(administratorException ad) {
							System.out.println(ad.getMessage());
							  System.out.println("please select an option according to the operation you want to perform");
							  System.out.println("1-> update fees of course");
								System.out.println("2-> add a new course");
								System.out.println("3-> delete a course from any training session");
								System.out.println("4-> Create Batch under a course");
								System.out.println("5-> Search information about a course.");
								System.out.println("6-> Update total seats of a batch");
								System.out.println("7-> View the students of every batch");
								System.out.println("8 : Exit");
								
			  					
			  				    next= sc.nextInt();
							
						}
						
					}
					
					
				}else {
					System.out.println("incorrect username or password");
				}
		
				
			}catch(administratorException e) {
				System.out.println(e.getMessage());
			}
		//if yaha khatm	//
			
		}
//******************************************************************************************************************************************//

		else if(option==2) {
			System.out.println("enter username");
			String urname=sc.next();
			System.out.println("enter password");
			String pass=sc.next();
			
			
			try {
				boolean str=stNew.login(urname, pass);
				
				if(str) {
					System.out.println();
					System.out.println("please select a operation you want to perform");
					System.out.println("1 : update credentials");
					System.out.println("2 : see all available course list and their seat availability.");
					System.out.println("3 : exit");
					int num=sc.nextInt();
					
					
					while(num!=3) {
						if(num==1) {
							String st1 = stNew.update(urname);
							System.out.println(st1);
						}else if(num==2) {
							ArrayList<String> al2 = stNew.SeeAllD();
							for(String i:al2) {
								System.out.println(i);
							}
						}
						else {
							System.out.println("You are not selecting a valid option");	
						
						}
						System.out.println();
						System.out.println("please select a operation you want to perform");
						System.out.println("1 : update credentials");
						System.out.println("2 : see all available course list and their seat availability.");
						System.out.println("3 : exit");
						 num=sc.nextInt();
						///////////////////////////////////}
					}if(num==3) {
						System.out.println("welcome YOu are now in adminsitrator database");
						System.out.println("please select an option according to the operation you want to perform");

						
						System.out.println("1-> update fees of course");
						System.out.println("2-> add a new course");
						System.out.println("3-> delete a course from any training session");
						System.out.println("4-> Create Batch under a course");
						System.out.println("5-> Search information about a course.");
						System.out.println("6-> Update total seats of a batch");
						System.out.println("7-> View the students of every batch");
						System.out.println("8 : Exit");
						int next= sc.nextInt();
					}
				}
				else {
					System.out.println("incorrect username or password ");
				}
				
	
			}catch(StudentException e) {
			System.out.println(e.getMessage());
			}
			
			
		}
//******************************************************************************************************************************************//

		else if(option==3) {
			System.out.println("enter username ");
		String userName=sc.next();
			System.out.println("create password");
			String Userpass=sc.next();
			System.out.println("Enter Student email");
			String email=sc.next();
		
		try {
			studentimpl sd = new studentimpl();
			String stdetails= stNew.SingUpfun(userName, Userpass, email);
			
		System.out.println(stdetails);
			
			
			
		}catch(StudentException e) {
			System.out.println(e.getMessage());
		}

		

	}else {
		System.out.println("Not Valid option");
	}
	
}
//******************************************************************************************************************************************//

	
	
	
	
	
	
	
	
	
	
	
	
	
//	System.out.println("||*Welcom to Automatic Student Registration System*||");
//	System.out.println("Select an option to continue");
//	 System.out.println("1 :- login as a Administrator");
//     System.out.println("2 :- login as a Student");
//     System.out.println("3 :- signup as a student");
 
   //  Scanner sc= new Scanner(System.in);
		
//		System.out.println("Enter Username:");
//		String uname = sc.next();
//		
//		System.out.println("Enter Password:");
//		String pass = sc.next();
     
		
//	     administratorIMP ads = new  administratorIMP();
	     
	     
//	     try {
//	    	boolean result =  ads.login(uname, pass); 
//	    	System.out.println(result);
//	     }catch(Exception e) {
//	    	 e.getMessage();
//	     }
//*******************************************************************8
//	     System.out.println("enter course name");
//			String cname=sc.next();
//			System.out.println("enter updated  fees of course");
//			int fees=sc.nextInt();
//			
//			administratorInter adsi = new administratorIMP();
//			
//			try {
//				String str = adsi.feesUpdate(cname, fees);
//				System.out.println(str);
//			} catch (administratorException e) {
//				System.out.println(e.getMessage());
//			}
//		
	   //*******************************************************************8
	     
	     
//	     System.out.println("enter course name");
//			String ncn=sc.next();
//		
//			administratorInter adsi = new administratorIMP();
//			
//			try {
//				String str = adsi.SearchInfoCourse(ncn);
//				System.out.println(str);
//			} catch (administratorException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	     
	     
	     
			//*******************************************************************	
	     
	     
//	     
//	 	System.out.println("enter course name");
//		String cname=sc.next();
//		System.out.println("enter Number of seats");
//		int bno=sc.nextInt();
//		
//		administratorInter adsie = new administratorIMP();
//		
//		try {
//			String str = adsie.CreateBatchUnderC(cname, bno);
//			System.out.println(str);
//		} catch (administratorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	     administratorInter adsio = new administratorIMP();
//	     
//	 	System.out.println("enter Batch Number");
//		int bn=sc.nextInt();
//		System.out.println("enter new Number of seats");
//		int seats=sc.nextInt();
//		
//		try {
//		String	str = adsio.UpdateSeats(bn, seats);
//		System.out.println(str);
//		} catch (administratorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		//******************************************************************* 
//	     
//
//			
//			
//			
//			administratorInter adv = new administratorIMP();
//			
//			try {
//				ArrayList<String> AL = adv.allStudentEveryB();
//				
//				for(String r : AL) {
//					System.out.println(r);
//				}
//			} catch (administratorException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			
//	     
//	     
//	}

}
