/*
**************************
@Author: Vishal P
@Lab: Java and J2EE Lab
@Code from : Anisham197
**************************
Ques : Write a JSP and Servlet Program to do the following to buy a T-Shirt online

Note: Procedure to run
->Create dynamic web project
->Add java file
->Add index.html to web contents
->Add display.jsp to webcontents
->Create the table in java database in mysql using the commands present in tables.mysql
->set proper username and password in .java and .jsp file
->then right click on inndex.html then run on server
*/


import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyTShirt
 */
@WebServlet("/BuyTShirt")
public class BuyTShirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver = "com.mysql.jdbc.Driver";
	String host = "jdbc:mysql://localhost:3306/java";
	String user = "root";
	String pass = "12345678";
	Connection con;

    public BuyTShirt() {
        super();
    	try{
    		Class.forName(driver);
    		con = DriverManager.getConnection(host, user, pass);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tag = request.getParameter("tag");
		String colour = request.getParameter("colour");
		String[] accessories = request.getParameterValues("acc");
		int pocket = Integer.parseInt(request.getParameter("pocket"));

		String acc = "";
		for (String x : accessories )
			acc = acc + x + " ";

		try {
			Statement stmt;
			stmt = (Statement) con.createStatement();
			stmt.executeUpdate("insert into tshirt values(" + acc + ",'" + tag + "','" + pocket +"','" + colour +"');");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("display.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
