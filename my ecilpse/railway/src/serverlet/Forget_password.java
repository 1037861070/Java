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

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Servlet implementation class Forget_password
 */
@WebServlet("/Forget_password")
public class Forget_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forget_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//
		String userName = request.getParameter("userid");
		String telNumber = request.getParameter("phone");
		String idNumber= request.getParameter("idcard");
		String userpwd1 = request.getParameter("userpwd1");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/railway?useUnicode=true&characterEncoding=utf-8&useSSL=false",
							"root", "123456");

			PreparedStatement stmt1 = conn
					.prepareStatement("select * from userinfo where userName=? and idNumber=? and telNumber=?");
			// stmt1.setString(1, name1);
			stmt1.setString(1, userName);
			stmt1.setString(2, idNumber);
			stmt1.setString(3, telNumber);
			ResultSet rs=stmt1.executeQuery();
			
			if (rs.next()) {
				PreparedStatement stmt = conn
						.prepareStatement("update userinfo set password=? where userName=?");
			
				stmt.setString(1, userpwd1);
				stmt.setString(2, userName);
				if (stmt.executeUpdate()> 0) {
					out.write("<script>");
					out.write("alert(\"修改密码成功！\")");
					out.write("</script>");
					response.setHeader("refresh", "1;url='personal_centre.jsp'");
				}
				
			}
			else {
				out.write("<script>");
				out.write("alert(\"用户信息输入错误！\")");
				out.write("</script>");
				response.setHeader("refresh", "1;url='forget_password.jsp'");
			}
			response.setHeader("refresh", "1;url='login.jsp'");
			//response.setHeader("refresh", "1;url='forget_password.jsp'");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
