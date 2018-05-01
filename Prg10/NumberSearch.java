
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NumberSearch
 */
@WebServlet("/NumberSearch")
public class NumberSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String host = "jdbc:mysql://localhost:3306/java";
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String pass = "12345678";
    Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberSearch() {
        super();

        try {
   		 Class.forName(driver);
			con = DriverManager.getConnection(host, user, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long number = Long.parseLong(request.getParameter("number"));
		String query = "SELECT * FROM phonebook WHERE phno=" + number;

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if ( rs.isBeforeFirst() ){
				response.getWriter().append("Name\tNumber\tAddress\tCompany\tZipcode\n");
				while(rs.next()){
					response.getWriter()
						.append("\n" + rs.getString("name"))
						.append("\t" + rs.getLong("phno"))
						.append("\t" + rs.getString("address"))
						.append("\t" + rs.getString("company"))
						.append("\t" +rs.getInt("zipcode"));
				}
			}
			else
				response.getWriter().append("No entry in phonebook for given Number\n");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
