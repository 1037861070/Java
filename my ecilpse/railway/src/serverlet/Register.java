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

import domain.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//
		
		  String userid = request.getParameter("userid");
		  String psw = request.getParameter("userpwd");
		  String phone = request.getParameter("phone");
		  String idcard2 = request.getParameter("idcard");
		  String true_name = request.getParameter("true_name");
		  
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/railway?useUnicode=true&characterEncoding=utf-8&useSSL=false",
							"root", "123456");
            PreparedStatement statement=conn.prepareStatement("select * from userinfo where userName=? ");
            statement.setString(1, userid);
            //statement.setString(2, idcard2);
            ResultSet rs=statement.executeQuery();
			  if(rs.next()){ 
				  out.write("<script>");
					out.write("alert(\"已存在此用户！\")");
					out.write("</script>");
					response.setHeader("refresh", "1;url='register.jsp'");
					}
			  else{
				  PreparedStatement stmt1 = conn
							.prepareStatement("insert into userinfo(userName,password,name,idNumber,telNumber) values(?,?,?,?,?)");
					// stmt1.setString(1, name1);
					stmt1.setString(1, userid);
					stmt1.setString(2, psw);
					stmt1.setString(3, true_name);
					stmt1.setString(4, idcard2);
					stmt1.setString(5, phone);

					if (stmt1.executeUpdate() > 0) {
						//序列化一个对象
		             User user=new User();
		             user.setUserName(userid);
		             user.setName(true_name);
		             user.setPassword(psw);
		             user.setTelNumber(phone);
		             user.setIdNumber(idcard2);
		             request.getSession().setAttribute("User", user);
						out.write("<script>");
						out.write("alert(\"注册成功！\")");
						out.write("</script>");
						response.setHeader("refresh", "1;url='personal_centre.jsp'");

					} else {
						out.write("<script>");
						out.write("alert(\"注册失败！\")");
						out.write("</script>");
					}
					//放在登录界面的servlet中
					
					
					response.setHeader("refresh", "1;url='ususal_contacts.jsp'");}
	
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
