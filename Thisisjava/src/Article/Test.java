package Article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Test {
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	Test() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이브 접속!");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "mysql");
			System.out.println("디비접속완료!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	void insert(){
		try {
			stmt = conn.createStatement();
			rs = stmt.executeUpdate("insert into article(id, title, writer, content, count) values()");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		try {
			new Test();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}








