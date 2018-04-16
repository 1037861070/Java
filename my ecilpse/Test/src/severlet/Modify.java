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

/**
 * Servlet implementation class Modify
 */
@WebServlet("/modify")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//
        String name1 = request.getParameter("username");
        String password1= request.getParameter("password");
        String beizhu1 = request.getParameter("beizhu");
        String tel1 = request.getParameter("tel");
        String sex1=request.getParameter("radio");
        
        
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        //out.println(sex);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
			/*PreparedStatement stmt=conn.prepareStatement("SELECT * FROM user WHERE name=? ");
			stmt.setString(1, name);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){*/
				   
        PreparedStatement stmt1=conn.prepareStatement("update user set password=?,beizhu=?,tel=?,sex=? where name=?");
        //stmt1.setString(1, name1);
        stmt1.setString(1, password1);
        stmt1.setString(2, beizhu1);
        stmt1.setString(3, tel1);
        stmt1.setString(4, sex1);
        stmt1.setString(5, name1);
       /* String sql="update user set name=name1,password=password1,beizhu=beizhu1,tel=tel1,sex=sex1 where name=name1";
		stmt1.executeUpdate(sql);*/
        //response.sendRedirect("修改密码.jsp");
       if(stmt1.executeUpdate()>0)
        {
    	//response.sendRedirect("javascript:alert('修改成功！');");
    	   
    	out.write("<script>");
   		out.write("alert(\"修改成功！\")");
   		out.write("</script>");
    	response.setHeader("refresh","1;url='homepage.jsp'");
    	
       }
       else
       {
        out.write("<script>");
       	out.write("alert(\"修改失败！\")");
       	out.write("</script>");}
       response.setHeader("refresh","1;url='homepage.jsp'");	
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
