<%@page import="java.util.Random"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		PrintWriter pout = response.getWriter();
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		int fno = Integer.parseInt(request.getParameter("fno"));
		int sno = new Random().nextInt(500)+1;
		String date = request.getParameter("date");
		//pout.print(name+number+fno+date);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/lab","root","root");
			if(conn!=null){
				Statement stmt = (Statement)conn.createStatement();
				ResultSet rs = null;
				//rs = stmt.executeQuery("select * from Flight where fno="+fno+";");
				try{
					stmt.executeUpdate("insert into SeatReservation values("+fno+",'"+date+"',"+sno+",'"+name+"',"+number+");");
					pout.println(name+" "+number+" "+date+" "+fno+" "+sno);
				}
				catch(Exception e){
					pout.println("Could not make a reservation");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>