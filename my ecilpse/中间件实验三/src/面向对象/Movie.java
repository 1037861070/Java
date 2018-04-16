package 面向对象;

public class Movie {
private String nameString;
private String pricesString;
private String dateString;
public Movie(){}
public Movie(String nameString,String priString,String dateString) {
	// TODO 自动生成的构造函数存根
	this.nameString=nameString;
	this.pricesString=priString;
	this.dateString=dateString;
}
public String getNameString() {
	return nameString;
}
public void setNameString(String nameString) {
	this.nameString=nameString;
}
public String getPricesString() {
	return pricesString;
}
public void setPricesString(String pricesString) {
	this.pricesString = pricesString;
}
public String getDateString() {
	return dateString;
}
public void setDateString(String dateString) {
	this.dateString = dateString;
}

}
