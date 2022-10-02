package com.masai.utility;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {

		Connection con = DBconnaction.connect();
		
		System.out.print(con);
	}

}
