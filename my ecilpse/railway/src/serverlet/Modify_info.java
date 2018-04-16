package serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Modify_info
 */
@WebServlet("/Modify_info")
public class Modify_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modify_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");//
		String userName = request.getParameter("userName");
		String telNumber = request.getParameter("user.address");
		String name= request.getParameter("user.realname");
		String idNumber= request.getParameter("user.idNumber");
		String idType="二代身份证";
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
					.prepareStatement("update userinfo set name=?,idType=?,idNumber=?,telNumber=? where userName=?");
			// stmt1.setString(1, name1);
			stmt1.setString(1, name);
			stmt1.setString(2, idType);
			stmt1.setString(3, idNumber);
			stmt1.setString(4, telNumber);
			stmt1.setString(5, userName);

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
