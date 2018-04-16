package severlet;

import manage.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

public class Database {
  static String strCon = "jdbc:mysql://127.0.0.1:3306/student";  //连接字符串
  static String strUser = "root";               //数据库用户名
  static String strPwd = "123456";                  //口令
  static Hashtable<String, Classes> classes;
  static Hashtable<String, Student> classStudent;
  static Hashtable<String, Student> allStudent;
  static Hashtable<String, Course> course;
  static Hashtable<String, Score> studentScore;
  static Hashtable<String, Score> courseScore;
  static Hashtable<String, Score> allScore;
  
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
		ps = con.prepareStatement("SELECT * FROM admini WHERE admini_name = ?");//预编译语句
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		//存在的话则将之封装成一个user对象，并返回
		if(rs.next()){              
			if(password.equals(rs.getString("password"))){
				user = new Administer(name,password,"administer");
				return user;
			}
		}
		rs.close();
		ps.close();
		con.close();
		return null;
	}
//根据输入的管理员姓名、密码、新密码在admini表中更新此用户
  public boolean updateUser(String name, String password, String newpassword) throws SQLException {
	  try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps, ps1;
		ps = con.prepareStatement("SELECT * FROM admini WHERE admini_name = ?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		 //查询是否存在此用户，如果存在此用户，则修改成新密码
		if(rs.next()) {      
			if(password.equals(rs.getString("password"))) {
				ps1 = con.prepareStatement("UPDATE admini SET password = ? WHERE admini_name = ?");
				ps1.setString(1, newpassword);
				ps1.setString(2, name);
				int count = ps1.executeUpdate();
				ps1.close();
				if(count > 0) 
					return true;
			}
		}
		rs.close();		
		ps.close();
		con.close();
		return false;
  }
  
//往admini表中新增添一个管理员用户
  public boolean insertUser(String name, String password) throws SQLException {
	  try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps, ps1;
		ps = con.prepareStatement("SELECT * FROM admini WHERE admini_name = ?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		//查询是否存在此管理员用户，如果存在，则返回false，否则执行插入语句
		if(rs.next())   
			return false;
		//预编译语句
		ps1 = con.prepareStatement("INSERT INTO admini (admini_name, password) VALUES (?, ?)");
		ps1.setString(1, name);
		ps1.setString(2, password);
		int count = ps1.executeUpdate();
		ps1.close();
		ps.close();
		con.close();
		//更新结果条数大于0，则返回true，否则false
		if(count > 0)
			return true;
		else
			return false;
  }
  //根据学生ID在student表中查询是否存在此用户
  public Student searchStudent(String studentID) throws SQLException,IllegalStateException {
		Student student = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM student WHERE student_id = ?");
		ps.setString(1, studentID);
		ResultSet rs = ps.executeQuery();
		//如果存在的话，则将它的所有信息封装成一个student对象，并返回
		if(rs.next()){     
			String studentName = rs.getString("student_name");       
			String className = rs.getString("class_name"); 
			Boolean sex = rs.getBoolean("sex");                
		  String birth = rs.getString("birth");
		  String nation = rs.getString("nation");          
		  String entrance = rs.getString("entrance_date");       
		  String specialty = rs.getString("specialty"); 
		  String password = rs.getString("password");
			student = new Student(studentID, studentName, className, 
					sex, birth, nation, entrance, specialty, password);
			return student;
		}
		rs.close();
		ps.close();
		con.close();
		return null;
	}
 //方法重载，根据学生ID和密码在student表中查询是否存在此用户 
  public Student searchStudent(String studentID, String password) throws SQLException {
  	Student student = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM student WHERE student_id = ? AND password = ?");
		ps.setString(1, studentID);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		//如果存在的话，则将它的所有信息封装成一个student对象，并返回
		if(rs.next()){     
			String studentName = rs.getString("student_name");       
			String className = rs.getString("class_name"); 
			Boolean sex = rs.getBoolean("sex");                
		  String birth = rs.getString("birth");
		  String nation = rs.getString("nation");          
		  String entrance = rs.getString("entrance_date");       
		  String specialty = rs.getString("specialty"); 
			student = new Student(studentID, studentName, className, sex, birth, 
					nation, entrance, specialty, password);
			return student;
		}
		rs.close();
		ps.close();
		con.close();
		return null;
  }
  //在student表中添加一个新的学生用户
  public boolean insertStudent(String studentID, String studentName, String className, boolean sex, 
   String birth, String nation, String entrance, String specialty) throws SQLException, IllegalStateException {
		try {Class.forName("com.mysql.jdbc.Driver");} catch (ClassNotFoundException e) {
			e.printStackTrace();} 
		Connection con;
    con = DriverManager.getConnection(strCon, strUser, strPwd);
    PreparedStatement ps, ps1;
    ps1 = con.prepareStatement("SELECT * FROM student WHERE student_id = ?");
    ps1.setString(1, studentID);
    ResultSet rs = ps1.executeQuery();
    //查询是否存在，如果存在的话则返回false，否则进行添加
    if(rs.next())return false;
    ps = con.prepareStatement("INSERT INTO student (student_id, student_name, class_name, "
    + "sex, birth, nation, entrance_date, specialty, password) values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1, studentID);
		ps.setString(2, studentName);
		ps.setString(3, className);
		ps.setBoolean(4, sex);
		ps.setString(5, birth);
		ps.setString(6, nation);
		ps.setString(7, entrance);
		ps.setString(8, specialty);
		ps.setString(9, studentID);
		int count = ps.executeUpdate();
		ps1.close();
		ps.close();
		con.close();
		if(count > 0)return true;else
      return false;
  }
  //更新student表中学生的信息
  public boolean updateStudent(String studentID, String studentName, String className, boolean sex, 
String birth, String nation, String entrance, String specialty) 
		throws SQLException, IllegalStateException {
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		Connection con;
    con = DriverManager.getConnection(strCon, strUser, strPwd);
    PreparedStatement ps;
    ps = con.prepareStatement("UPDATE student SET student_name = ?, class_name = ?, "
    		+ "sex = ?, birth = ?, nation = ?, entrance_date = ?, specialty = ? WHERE student_id = ?");
		ps.setString(1, studentName);
		ps.setString(2, className);
		ps.setBoolean(3, sex);
		ps.setString(4, birth);
		ps.setString(5, nation);
		ps.setString(6, entrance);
		ps.setString(7, specialty);
        ps.setString(8, studentID);
    int count = ps.executeUpdate();
    ps.close();
    con.close();
    if(count > 0)
    	return true;
    else
  	  return false;
  }
  //修改student表中特定用户的密码
  public boolean updateStuPw(String studentName, String password, String newpassword) throws SQLException {
	  try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps, ps1;
		ps = con.prepareStatement("SELECT * FROM student WHERE student_name = ? AND password = ?");
		ps.setString(1, studentName);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		//如果存在此用户，则进行更新操作
		if(rs.next()) {
			ps1 = con.prepareStatement("UPDATE student SET password = ? WHERE student_name = ?");
			ps1.setString(1, newpassword);
			ps1.setString(2, studentName);
			int count = ps1.executeUpdate();
			ps1.close();
			if(count > 0) 
				return true;
		}
		rs.close();		
		ps.close();
		con.close();
		return false;
  }
  //根据学生ID删除student表中的特定用户
  public boolean deleteStudent(String studentID) throws SQLException, IllegalStateException {
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		Connection con;
    con = DriverManager.getConnection(strCon, strUser, strPwd);
    PreparedStatement ps;
    ps = con.prepareStatement("DELETE FROM student WHERE student_id = ?");
		ps.setString(1, studentID);
		int count = ps.executeUpdate();
		ps.close();
		con.close();
		if(count > 0)
			return true;
		else
  	  return false;
  }
  //查询student表中所有的学生并全部封装在Enumaeration对象中
  public Enumeration<Student> searchStudent() throws SQLException {
	  allStudent = new Hashtable<String,Student>();
	  Student student1 = null;
	  	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();}  
			Connection con;
			con = DriverManager.getConnection(strCon, strUser, strPwd);
			PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM student");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String studentName = rs.getString("student_name");       
				String studentID = rs.getString("student_id"); 
				String className = rs.getString("class_name");
				Boolean sex = rs.getBoolean("sex");                
			  String birth = rs.getString("birth");
			  String nation = rs.getString("nation");          
			  String entrance = rs.getString("entrance_date");       
			  String specialty = rs.getString("specialty");
			  String password = rs.getString("password");
			  student1 = new Student(studentID, studentName, className, sex, 
					  birth, nation, entrance, specialty, password);
			  allStudent.put(studentID, student1);}
			rs.close();
			ps.close();
			con.close();
			Enumeration<Student> e  = allStudent.elements();
			return e;
  }
 //根据班级名查询student表中所用学生并全部封装在Enumeration的对象中
  public Enumeration<Student> searchClassStudent(String className) throws SQLException {
  	classStudent = new Hashtable<String,Student>();//定义一个hashtable
  	Student student = null;
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM student WHERE class_name = ?");
		ps.setString(1, className);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String studentName = rs.getString("student_name");       
			String studentID = rs.getString("student_id"); 
			Boolean sex = rs.getBoolean("sex");                
		  String birth = rs.getString("birth");
		  String nation = rs.getString("nation");          
		  String entrance = rs.getString("entrance_date");       
		  String specialty = rs.getString("specialty");
		  String password = rs.getString("password");
		  student = new Student(studentID, studentName, className, sex, birth, nation, entrance, specialty, password);
		  classStudent.put(studentID, student);
		}
		rs.close();
		ps.close();
		con.close();
		Enumeration<Student> e  = classStudent.elements();//得到hashtable中所有值得枚举
		return e;
  }
  //往class表中添加新的数据
  public boolean insertClass(String className, int maxNum, int grade) throws SQLException {
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		Connection con;
    con = DriverManager.getConnection(strCon, strUser, strPwd);
    PreparedStatement ps, ps1;
    ps1 = con.prepareStatement("SELECT * FROM class WHERE class_name = ?");
    ps1.setString(1, className);
    ResultSet rs = ps1.executeQuery();
    if(rs.next())
    	return false;
    ps = con.prepareStatement("INSERT INTO class (class_name, maxNum, grade) values (?,?,?)");
    ps.setString(1, className);
    ps.setInt(2, maxNum);
    ps.setInt(3, grade);
    int count = ps.executeUpdate();
    ps1.close();
		ps.close();
		con.close();
		if(count > 0)
			return true;
		else
  	  return false;
  }
  //得到class表中所有的数据并将之封装在Enumeration对象中
  public Enumeration<Classes> getAllClass() throws SQLException {
  	classes = new Hashtable<String,Classes>();
  	Classes class1 = null;
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM class");
		ResultSet rs = ps.executeQuery();
		//如果class表中有数据，则将所有数据封装成Classes的对象
		while(rs.next()) {
			int classID = rs.getInt("class_id");
			String className = rs.getString("class_name");
			int maxNum = rs.getInt("maxNum");
			int sumNum = rs.getInt("sumNum");
			int grade = rs.getInt("grade");
			class1 = new Classes(classID, className, maxNum, sumNum, grade);
			String ID = Integer.toString(classID);
			classes.put(ID, class1);
		}
		rs.close();
		ps.close();
		con.close();
		Enumeration<Classes> e  = classes.elements();
		return e;
  }
  //在Course表中添加一个新的数据
  public boolean insertCourse(String courseName, float credit) throws SQLException {
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		Connection con;
    con = DriverManager.getConnection(strCon, strUser, strPwd);
    PreparedStatement ps, ps1;
    ps1 = con.prepareStatement("SELECT * FROM course WHERE course_name = ?");
    ps1.setString(1, courseName);
    ResultSet rs = ps1.executeQuery();
    if(rs.next())
    	return false;
    ps = con.prepareStatement("INSERT INTO course (course_name, credit) values (?,?)");
  	ps.setString(1, courseName);
  	ps.setFloat(2, credit);
  	int count = ps.executeUpdate();
    ps1.close();
		ps.close();
		con.close();
		if(count > 0)
			return true;
		else
      return false;
  }
  //根据课程名在Course表中修改特定的数据
  public boolean updateCourse(String courseName, float credit) throws SQLException {
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		Connection con;
    con = DriverManager.getConnection(strCon, strUser, strPwd);
    PreparedStatement ps;
    ps = con.prepareStatement("UPDATE course SET credit = ? WHERE course_name = ?");
		ps.setFloat(1, credit);
    ps.setString(2, courseName);
    int count = ps.executeUpdate();
		ps.close();
		con.close();
		if(count > 0)
			return true;
		else
  	  return false;
  }
  
 //根据课程名在Course中删除特定的 数据
  public boolean deleteCourse(String courseName) throws SQLException {
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		Connection con;
    con = DriverManager.getConnection(strCon, strUser, strPwd);
    PreparedStatement ps, ps1;
    ps = con.prepareStatement("DELETE FROM course WHERE course_name = ?");
		ps.setString(1, courseName);
		ps1 = con.prepareStatement("DELETE FROM score WHERE course_name = ?");
		ps1.setString(1, courseName);
		int count = ps.executeUpdate();
		int count1 = ps1.executeUpdate();
		ps.close();
		con.close();
		if(count > 0 && count1 > 0)
			return true;
		else
  	  return false;
  }
  
  //得到Course表中的所有课程信息，并封装在Enumeration对象中
  public Enumeration<Course> getAllCourse() throws SQLException {
  	course = new Hashtable<String,Course>();
  	Course course1 = null;
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM course");
		ResultSet rs = ps.executeQuery();
		//如果Course表中有数据，则将它的所有信息封装成Course类的对象
		while(rs.next()) {
			int courseID = rs.getInt("course_id");
			String courseName = rs.getString("course_name");
			float credit = rs.getFloat("credit");
			course1 = new Course(courseID, courseName, credit);
			String ID = Integer.toString(courseID);
			course.put(ID, course1);
		}
		rs.close();
		ps.close();
		con.close();
		Enumeration<Course> e  = course.elements();
		return e;
  }
  //在score表中添加一个新的数据
  public boolean insertScore(String studentID, String courseName, 
		  float score, int semester, String year) throws SQLException {
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		Connection con;
    con = DriverManager.getConnection(strCon, strUser, strPwd);
    PreparedStatement ps, ps1;
    ps1 = con.prepareStatement("SELECT * FROM score WHERE course_name = ? AND student_id = ?");
    ps1.setString(1, courseName);
    ps1.setString(2, studentID);
    ResultSet rs = ps1.executeQuery();
    if(rs.next())
    	return false;
    ps = con.prepareStatement("INSERT INTO score (course_name, student_id, score, "
    		+ "semester, year) values (?,?,?,?,?)");
  	ps.setString(1, courseName);
  	ps.setString(2, studentID);
  	ps.setFloat(3, score);
  	ps.setInt(4, semester);
  	ps.setString(5, year);
    int count = ps.executeUpdate();
    ps1.close();
		ps.close();
		con.close();
		if(count > 0)
			return true;
		else
  	 return false;
  }
  //查询score表中所有的数据，并保存在Enumeration对象中
  public Enumeration<Score> searchScore() throws SQLException {
	  allScore = new Hashtable<String, Score>();
	  Score score1 = null;
	  try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	  	Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM score");
		ResultSet rs = ps.executeQuery();
		int index = 0;
		while(rs.next()) {
			String studentID = rs.getString("student_id");
			String courseName = rs.getString("course_name");
			float score = rs.getFloat("score");
			int semester = rs.getInt("semester");
			String year = rs.getString("year");
			score1 = new Score(studentID, courseName, score, semester, year);
			String ID = Integer.toString(index);
			allScore.put(ID, score1);
			index++;
		}
		rs.close();
		ps.close();
		con.close();
		Enumeration<Score> e  = allScore.elements();
		return e;
  }
  //根据学生ID在score表中查询所有特定数据并保存在Enumeration对象中
  public Enumeration<Score> searchStudentScore(String studentID) throws SQLException {
  	studentScore = new Hashtable<String,Score>();
  	Score score1 = null;
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM score WHERE student_id = ?");
		ps.setString(1, studentID);
		ResultSet rs = ps.executeQuery();
		int index = 0;
		while(rs.next()) {
			String courseName = rs.getString("course_name");
			float score = rs.getFloat("score");
			int semester = rs.getInt("semester");
			String year = rs.getString("year");
			score1 = new Score(studentID, courseName, score, semester, year);
			String ID = Integer.toString(index);
			studentScore.put(ID, score1);
			index++;
		}
		rs.close();
		ps.close();
		con.close();
		Enumeration<Score> e  = studentScore.elements();
		return e;
  }
  //根据课程名称在Course表中查询所有符合的课程并保存在 numeration对象中
  public Enumeration<Score> searchCourseScore(String courseName) throws SQLException {
  	courseScore = new Hashtable<String,Score>();
  	Score score1 = null;
  	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		Connection con;
		con = DriverManager.getConnection(strCon, strUser, strPwd);
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT * FROM score WHERE course_name = ?");
		ps.setString(1, courseName);
		ResultSet rs = ps.executeQuery();
		int index = 0;
		while(rs.next()) {
			String studentID = rs.getString("student_id");
			float score = rs.getFloat("score");
			int semester = rs.getInt("semester");
			String year = rs.getString("year");
			score1 = new Score(studentID, courseName, score, semester, year);
			String ID = Integer.toString(index);
			courseScore.put(ID, score1);
			index++;
		}
		rs.close();
		ps.close();
		con.close();
		Enumeration<Score> e  = courseScore.elements();
		return e;
  }
}
