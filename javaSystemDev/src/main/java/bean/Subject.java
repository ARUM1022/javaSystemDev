package bean;
 
import java.io.Serializable;

import org.eclipse.tags.shaded.org.apache.xpath.operations.String;
 
public class Subject implements Serializable {
	
	//学校コード String
	private String cd;
	//科目コード String//
	private String name;
	//科目名 String//
	private School school;
	
	public String getCd() {
		return cd;
	}
	
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public School getSchool() {
		return school;
	}
	
	public void setSchool(School school) {
		this.school = school;
	}
}