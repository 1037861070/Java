package serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Modify_password
 */
@WebServlet("/Modify_password")
public class Modify_password extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modify_password() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//
		String userpwd1 = request.getParameter("userpwd1");
		String userName= request.getParameter("userName");
		String oldpsw= request.getParameter("userpwd");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/railway?useUnicode=true&characterEncoding=utf-8&useSSL=false",
							"root", "123456");
			 PreparedStatement stmt=conn.prepareStatement("SELECT * FROM userinfo WHERE userName=? and password=?" ); 
			  stmt.setString(1, userName); 
			  stmt.setString(2, oldpsw);
			  ResultSet rs=stmt.executeQuery();
			  if(!rs.next()){ 
				  out.write("<script>");
					out.write("alert(\"原密码输入错误！\")");
					out.write("</script>");
					response.setHeader("refresh", "1;url='modify_password.jsp'");
			  }
			  else {
			PreparedStatement stmt1 = conn
					.prepareStatement("update userinfo set password=? where userName=?");
			// stmt1.setString(1, name1);
			stmt1.setString(1, userpwd1);
			stmt1.setString(2, userName);

			if (stmt1.executeUpdate() > 0) {

				out.write("<script>");
				out.write("alert(\"修改成功！\")");
				out.write("</script>");
				response.setHeader("refresh", "1;url='personal_centre.jsp'");

			} else {
				out.write("<script>");
				out.write("alert(\"修改失败！\")");
				out.write("</script>");
				response.setHeader("refresh", "1;url='modify_password.jsp'");
			}
			  }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
