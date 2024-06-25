package com.myspring.test1;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root",
				"1234"
				)){
			System.out.println(conn+"연결성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
