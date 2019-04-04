

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("name");  
		String a=request.getParameter("age");  
		String addr=request.getParameter("address");
		String c=request.getParameter("country");
		String z=request.getParameter("zip");
		String e=request.getParameter("email");
		String g=request.getParameter("gender");
		String abt=request.getParameter("about");
		try {
			
			Class.forName("com.mysql.jdbc.driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","mysql");
			PreparedStatement st = conn.prepareStatement("insert into message values(?, ?,?,?, ?,?,?)"); 
	   
	            st.setString(1, n); 
	            st.setString(2, a); 
	            st.setString(3, addr); 
	            st.setString(4, c);
	            st.setString(5, z);
	            st.setString(6, e);
	            st.setString(7, g);
	            st.setString(8, abt);
	            
	            st.executeUpdate(); 
	            st.close(); 
	            conn.close(); 
		}
		
		catch(Exception e1) {
			
		}
		out.println("message submitted");
	}

}
