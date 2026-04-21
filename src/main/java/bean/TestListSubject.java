package bean;

import java.io.Serializable;
import java.util.Map;

public class TestListSubject implements Serializable {
	
	private int entYear;
	
	private String studentNo;
	
	private String studentName;
	
	private String classNum;
	
	private Map points;	
	
	public int getEntYear() {
		return entYear;
	}
	
	public void setEntYear(int entYear) {
		this.entYear = entYear;
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	
	public void setStudentNo(String stundetNo) {
		this.studentNo = studentNo;
	}
	
	public String getSubjectName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getClassNum() {
		return classNum;
	}
	
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
	public Map getPoints() {
		return point;
	}
	
	public void setPoints(Map points) {
		this.points = points;
	}
	
	public String getPoint() {
		return ;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
	
	
	
}