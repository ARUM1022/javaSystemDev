package bean;

import java.io.Serializable;

public class Test implements Serializable {
	
	private String Student_No;
	
	private String Subject_Cd;
	
	private String School_Cd;
	
	private int no;
	
	private int Point;
	
	private String Class_Num;
	
	public String getStudent_No() {
		return Student_No;
	}
	public void setStudent(String Stundet_No) {
		this.Student_No = Stundet_No;
	}
	
	public String getSubject_Cd() {
		return Subject_Cd;
	}
	public void setSubject_Cd(String Subject_Cd) {
		this.Subject_Cd = Subject_Cd;
	}
	
	public String getSchool_Cd() {
		return School_Cd;
	}
	public void setSchool_Cd(String School_Cd) {
		this.School_Cd = School_Cd;
	}
	
	public int getno() {
		return no;
	}
	public void setno(int no) {
		this.no = no;
	}
	
	public int getPoint() {
		return Point;
	}
	public void setPoint(int Point) {
		this.Point = Point;
	}
	
	public String getClass_Num() {
		return Class_Num;
	}
	public void setClass_Num(String Class_Num) {
		this.Class_Num = Class_Num;
	}
}