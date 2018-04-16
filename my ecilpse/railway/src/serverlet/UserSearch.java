package serverlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import domain.Order;
import domain.Route;
import domain.Site;
import domain.Train;
import domain.User;
import domain.UserContact;

public class UserSearch {
	static String strCon = "jdbc:mysql://127.0.0.1:3306/railway";  //连接字符串
	  static String strUser = "root";               //数据库用户名
	  static String strPwd = "123456";                  //口令
	  static Hashtable<String, User> users;
	  static Hashtable<String,Order > orders;
	  static Hashtable<String, Route> routes;
	  static Hashtable<String, Site> course;
	  static Hashtable<String, Train> trains;
	  static Hashtable<String, UserContact> usercontact;	  
	  
	  //根据输入的管理员姓名和密码在admini表中查询是否存在此用户
	  public User searchUser(String name, String password) throws SQLException,IllegalStateException {
			User user = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}  
			Connection con;
			con = DriverManager.getConnection(strCon, strUser, strPwd);//连接数据库
			PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM railway WHERE userName = ?");//预编译语句
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			//存在的话则将之封装成一个user对象，并返回
			if(rs.next()){              
				if(password.equals(rs.getString("password"))){
					user = new User();
					return user;
				}
			}
			rs.close();
			ps.close();
			con.close();
			return null;
		}
}
