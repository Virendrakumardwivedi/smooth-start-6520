package com.masai.been;

public class studentDetail {

	private int S_id;
	private String S_name;
	private String S_email;
    private int B_no;
    private String B_n2;
 
 
 studentDetail(){
	 
 }
 
 

public studentDetail(int s_id, String s_name, String s_email, int b_no, String b_n2) {
	super();
	S_id = s_id;
	S_name = s_name;
	S_email = s_email;
	B_no = b_no;
	B_n2 = b_n2;
}









public int getS_id() {
	return S_id;
}
public void setS_id(int s_id) {
	S_id = s_id;
}
public String getS_name() {
	return S_name;
}
public void setS_name(String s_name) {
	S_name = s_name;
}
public String getS_email() {
	return S_email;
}
public void setS_email(String s_email) {
	S_email = s_email;
}
public int getB_no() {
	return B_no;
}
public void setB_no(int b_no) {
	B_no = b_no;
}
public String getB_n2() {
	return B_n2;
}
public void setB_n2(String b_n2) {
	B_n2 = b_n2;
}
@Override
public String toString() {
	return "studentDetail [S_id=" + S_id + ", S_name=" + S_name + ", S_email=" + S_email + ", B_no=" + B_no + ", B_n2="
			+ B_n2 + "]";
}






	
	
}
