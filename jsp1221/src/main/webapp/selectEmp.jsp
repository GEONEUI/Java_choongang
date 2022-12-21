<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1" style="width:85%; margin:0 auto; border-collapse:collapse; border-spacing:0;">




<%
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
	int x = Integer.parseInt(request.getParameter("deptno"));
	Class.forName("oracle.jdbc.OracleDriver");
	out.println("드라이버연결");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "SCOTT";
	String password = "tiger";
	conn = DriverManager.getConnection(url, user, password);
	out.println("DB 연결");
	String sql = "select * from emp where deptno = ?";
	

	stmt = conn.prepareStatement(sql);
	stmt.setInt(1, x);
	rs = stmt.executeQuery();
	
	while(rs.next()){ %>
		<tr><td><%= rs.getInt("empno") %></td>
		<td><%= rs.getString("ename") %></td>
		<td><%= rs.getString("job") %></td>
		<td><%= rs.getString("deptno") %></td>
		<td><%= rs.getInt("sal") %></td></tr>
	
<%	
	}
%>



</table>




<script>
console.log("호로로로로롤");
</script>

</body>
</html>