package bean;
import java.io.Serializable;
//　学生番号・氏名・クラス・入学年度・在学中か・学校名
public class Student implements Serializable{
	private String no;
	private String name;
	private int entYear;
	private String classNum;
	private boolean isAttend;
	private School school;
//ゲッタ・セッタ
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no=no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getEntYear() {
		return entYear;
	}
	public void setEntYear(int entYear) {
		this.entYear=entYear;
	}
	public boolean isAttend() {
		return isAttend;
	}
	public void setisAttend(boolean isAttend) {
		this.isAttend=isAttend;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school){
		this.school=school;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum){
		this.classNum=classNum;
	}
	
}