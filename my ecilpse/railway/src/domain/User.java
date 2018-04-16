package domain;

import java.io.Serializable;

public class User implements Serializable{
private int userId;
private String userName;
private String password;
private String name;
private int role;
private String idType;
private String idNumber;
private String telNumber;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
public String getIdType() {
	return idType;
}
public void setIdType(String idType) {
	this.idType = idType;
}
public String getIdNumber() {
	return idNumber;
}
public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
}
public String getTelNumber() {
	return telNumber;
}
public void setTelNumber(String telNumber) {
	this.telNumber = telNumber;
}
}
