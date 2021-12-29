import jakarta.servlet.http.*;  
import jakarta.servlet.*;  
import java.io.*;  
import java.sql.*;
public class Hello extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Name=request.getParameter("userName");
		String password=request.getParameter("userPass"); 
		String email=request.getParameter("userEmail");
		String mobile=request.getParameter("userMobile");
		String dob=request.getParameter("userDOB");  
		String gender=request.getParameter("gender");  
		String country=request.getParameter("userCountry");
		out.print("Hello "+Name);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wp","root","12345");
			PreparedStatement ps=con.prepareStatement("insert into wp.registration values(?,?,?,?,?,?,?)");	
			ps.setString(1,Name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,mobile);
			ps.setString(5,dob);
			ps.setString(6,gender);
			ps.setString(7,country);
			int r=ps.executeUpdate();
			if(r==0)
			out.println("insertion failure");
			else
			out.println(" your registration is successful");
			con.close();
			ps.close();
		}
		catch(Exception e)
		{
			
		}

		out.close();
	}
}