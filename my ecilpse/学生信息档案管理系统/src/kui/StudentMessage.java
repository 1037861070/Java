package kui;

public class StudentMessage {
	private String name;
	private String number;
	private String classname;
	private String grade;
	public StudentMessage(){}
	public StudentMessage(String name,String number,String classname,
			String grade){
		this.name=name;
		this.number=number;
		this.classname=classname;
		this.grade=grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
