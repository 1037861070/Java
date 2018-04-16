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
	static String strCon = "jdbc:mysql://127.0.0.1:3306/railway";  //�����ַ���
	  static String strUser = "root";               //���ݿ��û���
	  static String strPwd = "123456";                  //����
	  static Hashtable<String, User> users;
	  static Hashtable<String,Order > orders;
	  static Hashtable<String, Route> routes;
	  static Hashtable<String, Site> course;
	  static Hashtable<String, Train> trains;
	  static Hashtable<String, UserContact> usercontact;	  
	  
	  //��������Ĺ���Ա������������admini���в�ѯ�Ƿ���ڴ��û�
	  public User searchUser(String name, String password) throws SQLException,IllegalStateException {
			User user = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");//�������ݿ�����
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}  
			Connection con;
			con = DriverManager.getConnection(strCon, strUser, strPwd);//�������ݿ�
			PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM railway WHERE userName = ?");//Ԥ�������
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			//���ڵĻ���֮��װ��һ��user���󣬲�����
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
