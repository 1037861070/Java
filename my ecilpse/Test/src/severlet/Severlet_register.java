package severlet;

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

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Severlet_register
 */
@WebServlet("/register")
public class Severlet_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count=0; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Severlet_register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");//
        String name = request.getParameter("reg_username");
        String password = request.getParameter("reg_pswd");
        String beizhu = request.getParameter("beizhu");
        String tel = request.getParameter("tel");
        String sex=request.getParameter("radio");
        
        
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        //out.println(sex);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
			PreparedStatement stmt=conn.prepareStatement("SELECT * FROM user WHERE name=? ");
			stmt.setString(1, name);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				//response.sendRedirect("login_left.jsp");
				out.write("<script>");
				out.write("alert(\"用户已存在！\")");
				out.write("</script>");
				response.setHeader("refresh","1;url='login.jsp'");
			}
			else{
				//String sql;
			    //sql="insert into user values(a,'name','password')";	   
        PreparedStatement stmt1=conn.prepareStatement("insert into user(name,password,beizhu,tel,sex) values(?,?,?,?,?)");
        stmt1.setString(1, name);
        stmt1.setString(2, password);
        stmt1.setString(3, beizhu);
        stmt1.setString(4, tel);
        stmt1.setString(5, sex);
        if(!stmt1.execute())
        {
        out.write("<script>");
		out.write("alert(\"注册成功！\")");
		out.write("</script>");
		response.setHeader("refresh","1;url='login.jsp'");
		}
        else
        {
        out.write("<script>");
       	out.write("alert(\"注册失败！\")");
       	out.write("</script>");
       	response.setHeader("refresh","1;url='login.jsp'");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
