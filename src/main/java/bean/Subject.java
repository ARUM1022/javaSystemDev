package bean;

import java.io.Serializable;

public class Subject implements Serializable {
	
	//学校コード String
	private String School_Cd;
	//科目コード String//
	private String cd;
	//科目名 String//
	private String name;
	
	public String getSchool_Cd() {
		return School_Cd;
	}
	
	public void setSchool_Cd(String School_Cd) {
		this.School_Cd = School_Cd;
	}
	public String getcd() {
		return cd;
	}
	
	public void setcd(String cd) {
		this.cd = cd;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
}
