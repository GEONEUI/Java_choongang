package section13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "mysql");
			System.out.println("연결완료");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	int insert(Users users) {
		String sql = "insert into users(userid, password, name, birth) values(?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, users.userid);
			pstm.setString(2, users.password);
			pstm.setString(3, users.name);
			pstm.setString(4, users.birth);

			return pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return 0;
	}

	List<Users> select() {
		List<Users> lst = new ArrayList<Users>();
		String sql = "select userid, password, name, birth from users";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {

				Users users = new Users(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
				);
				
				lst.add(users);

			}
		
			
			return lst;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		dao.connect();
		List<Users> list = dao.select();
		for(Users usr : list) {
			System.out.println(usr);
		}
		
		
//		int res = dao.insert(new Users("testtest", "1234", "네임", "1565"));
//		System.out.println(res + "건입력");

	}
}
