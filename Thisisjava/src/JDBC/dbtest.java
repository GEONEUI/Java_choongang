package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbtest {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	
	
	public dbtest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이브 연결");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "mysql");
			System.out.println("디비연결");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

	public static void main(String[] args) {
		new dbtest();
		
	}

}
