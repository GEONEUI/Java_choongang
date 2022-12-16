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
			System.out.println("DB 접속!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int insert(Article art) {
		String sql = 
			"insert into article(writer, title, content, count)"
			+ " values (?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, art.writer);
			pstm.setString(2, art.title);
			pstm.setString(3, art.content);
			pstm.setInt(4, art.count);
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

	int delete(int id) {
		String sql = "delete from article where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
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
	
	int update(Article art) {
		String sql = "update article "
				+ "set writer = ?, title = ?, content = ?, count = ?"
				+ " where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, art.writer);
			pstm.setString(2, art.title);
			pstm.setString(3, art.content);
			pstm.setInt(4, art.count);
			pstm.setInt(5, art.id);
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
				return new Article(id, writer, title, content, count);
			}
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
		return null;

	}

	List<Article> selectAll() {
		List<Article> lst = new ArrayList<Article>();
		String sql = "select id, writer, title, content, count " + "from article";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
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
		List<Article> lst1 = new ArrayList<Article>();
		for(int i=0; i<10; i++) {
			Article art2 = new Article(0, "정1", "제목1", "내용1", 0);
			lst1.add(art2);
			lst1.stream().forEach((e) -> dao.insert(e));
		}
		
//		for(Article at : lst1) {
//			System.out.println(at);
//		}
//		
		
		

		
		
		List<Article> lst = dao.selectAll();
		lst.stream().forEach(m->System.out.println(m.writer));
		
//		for (Article art : lst) {
//			System.out.println(art);
//		}

	}
}
