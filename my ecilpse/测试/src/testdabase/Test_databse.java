package testdabase;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test_databse {
private String name;
private String password;
public Test_databse() {
	// TODO 自动生成的构造函数存根
	
}
public boolean query(String name,String password) throws SQLException{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode"
				+ "=true&characterEncoding=utf-8&useSSL=false","root","123456");
		PreparedStatement stmt=con.prepareStatement("select * from user where name=? and password=?");
		stmt.setString(1, name);
		stmt.setString(2, password);
		ResultSet rSet=stmt.executeQuery();
		if (rSet.next()) {
			return true;
		}
		
	} catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return false;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
