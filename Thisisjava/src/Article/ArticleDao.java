package Article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArticleDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "mysql");
//			System.out.println("DB 접속!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Article select(int sid) {
		String sql = "select * from article where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, sid);
			rs = pstm.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int count = rs.getInt("count");
				return new Article(id,writer,title, content,count);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	int insert(Article art) {
		///여기
		return 0;
		
	}
	List<Article> selectAll() {
		List<Article> lst = new ArrayList<Article>();
		String sql = "select id, writer, title, content, count " +
				"from article";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String writer = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				int count = rs.getInt(5);
				lst.add(new Article(id, writer, title, content, count));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
		
	}
	public static void main(String[] ars) {
		ArticleDao dao = new ArticleDao();
		Article art = dao.select(2);
		System.out.println(art);
//		List<Article> list = dao.selectAll();
//		for (Article art : list) {
//			System.out.println(art);
//		}
	}
}








