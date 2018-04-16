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

import domain.UserContact;

/**
 * Servlet implementation class Add_contacts
 */
@WebServlet("/Add_contacts")
public class Add_contacts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add_contacts() {
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
		String userName = request.getParameter("userName");
		String telNumber = request.getParameter("telNumber");
		String name = request.getParameter("item.name");
		String idNumber = request.getParameter("idNumber");
		String idType = "二代身份证";
		int userId = 0;
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			Connection conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/railway?useUnicode=true&characterEncoding=utf-8&useSSL=false",
							"root", "123456");
			
			  PreparedStatement	 stmt=conn.prepareStatement("SELECT * FROM userinfo WHERE userName=? " ); 
			  stmt.setString(1, userName); 
			  ResultSet rs=stmt.executeQuery();
			  if(rs.next()){ //response.sendRedirect("login_left.jsp");
			  userId=rs.getInt(1); }
			  PreparedStatement	 stmt2=conn.prepareStatement("SELECT * FROM usercontactinfo WHERE name=? or idNumber=?" ); 
			  stmt2.setString(1, name); 
			  stmt2.setString(2, idNumber);
			  ResultSet rs1=stmt2.executeQuery();
			  if(rs1.next()){ //response.sendRedirect("login_left.jsp");
				  out.write("<script>");
					out.write("alert(\"已存在此联系人！\")");
					out.write("</script>");
					response.setHeader("refresh", "1;url='add_contacts.jsp'");
			  }
			  else {		
			PreparedStatement stmt1 = conn
					.prepareStatement("insert into usercontactinfo(userId,name,idType,idNumber,telNumber) values(?,?,?,?,?)");
			 stmt1.setInt(1, userId);
			stmt1.setString(2, name);
			stmt1.setString(3, idType);
			stmt1.setString(4, idNumber);
			stmt1.setString(5, telNumber);
			if (stmt1.executeUpdate() > 0) {
				UserContact user_contact=new UserContact();
				user_contact.setUserId(userId);
				user_contact.setName(name);
				user_contact.setIdType(idType);
				user_contact.setIdNumber(idNumber);
				user_contact.setTelNumber(telNumber);
				 request.getSession().setAttribute("UserContact", user_contact);
				out.write("<script>");
				out.write("alert(telNumber\"添加成功！\")");
				out.write("</script>");
				response.setHeader("refresh", "1;url='ususal_contacts.jsp'");

			} else {
				out.write("<script>");
				out.write("alert(\"添加失败！\")");
				out.write("</script>");
				response.setHeader("refresh", "1;url='ususal_contacts.jsp'");
			}
			  }
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
