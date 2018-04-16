package severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import domain.User;

/**
 * Servlet implementation class severlet
 */
@WebServlet("/_login")
public class severlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public severlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        boolean flag = false;//
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
			PreparedStatement stmt=conn.prepareStatement("SELECT * FROM user WHERE name=? AND password=?");
			stmt.setString(1, name);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				User u = new User();
			    u.setName(name);
			    u.setPassword(password);
				u.setBeizhu(rs.getString(4));
				u.setTel(rs.getString(5));
				u.setSex(rs.getString(6));
				request.getSession().setAttribute("User", u);
				response.sendRedirect("homepage.jsp");
			}
			else{
				out.write("<script>");
				out.write("alert(\"用户名或密码错误\")");
				out.write("</script>");
				response.setHeader("refresh","1;url='login.jsp'");
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
		doGet(request,response);
	}

}
