package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//ここにまだimportが追加される可能性あり

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDao extends Dao{
	
	private String baseSql = "select * from test where school_cd=? and subject_cd=?";

	
	private List<Test> postFilter(ResultSet rSet) throws Exception{
		List<Test> list = new ArrayList<>();
		
		try {
			while (rSet.next()) {
				Test test = new Test();
				Student student = new Student();
				Subject subject = new Subject();
				School school = new School();
				//学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("student_no"));
				subject.setCd(rSet.getString("subject_cd"));
				school.setCd(rSet.getString("school_cd"));
				test.setStudent(student);
				test.setSubject(subject);
				test.setSchool(school);
				test.setNo(rSet.getInt("no"));
				test.setPoint(rSet.getInt("point"));
				test.setClassNum(rSet.getString("class_num"));
				//リストに追加
				list.add(test);
			}
		}catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return list;
	}

//filterメソッド	
	public List<Test> filter(int entYear, String classNum, Subject subject, int no, School school) throws Exception{
		//リストを初期化
				List<Test> list = new ArrayList<>();
				//コネクションを確率
				Connection connection = getConnection();
				//プリペアードステートメント
				PreparedStatement statement = null;
				//リザルトセット
				ResultSet rSet = null;
				//SQL文の条件
				String condition = "and class_num=? and no=? ";	
				
				try {
					//プリペアードステートメントにSQL文をセット
					statement = connection.prepareStatement(baseSql + condition);
					//プリペアードステートメントに学校コードをバインド
					statement.setString(1, school.getCd());
					statement.setString(2, subject.getCd());
					statement.setString(3, classNum);
					statement.setInt(4,no);
					statement.setInt(5, entYear);
					//プライベートステートメントを実行
					rSet = statement.executeQuery();
					//リストへの格納処理を実行
					list = postFilter(rSet);
				} catch (Exception e) {
					throw e;
				} finally {
					//プリペアードステートメントを閉じる
					if (statement != null) {
						try {
							statement.close();
						}catch(SQLException sqle) {
							throw sqle;
						}
					}
				}
				return list;
	}
//saveメソッド
	public boolean save(List<Test> list) throws Exception{
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		//実行件数
		int count = 0;
			try { 
				for (Test test : list) {
				//データベースから学取得
			Test old = get(test.getStudent(),test.getNo());
			if (old == null) {
				//結果が存在しなかった場合
				//プリペアードステートメントにINSERT文をセット
				statement = connection.prepareStatement(
						"insert into test(student_no,subject_cd,school_cd,no,point,class_num) values(?, ?, ?, ?, ?, ?)");
				//プリペアードステートメントに値をバインド
				
				
				
				statement.setString(1,test.getStudent().getNo());
				statement.setString(2,test.getSubject().getCd());
				statement.setString(3,test.getSchool().getCd());
				statement.setInt(4, test.getNo());
				statement.setInt(5,test.getPoint());
				statement.setString(6,test.getClassNum());
			} else {
				//結果が存在した場合
				//プリペアードステートメントにUPDATE文をセット
				statement = connection
						.prepareStatement("update test set student_no=?,subject_cd=?,School_cd=?,no=?,point=?,class_num=? where student_no=? and subject_cd=? and no=? ");
				//プリペアードステートメントに値をバインド
				statement.setString(1,test.getStudent().getNo());
				statement.setString(2,test.getSubject().getCd());
				statement.setString(3,test.getSchool().getCd());
				statement.setInt(4, test.getNo());
				statement.setInt(5,test.getPoint());
				statement.setString(6,test.getClassNum());
				statement.setString(7,test.getStudent().getNo());
				statement.setString(8,test.getSubject().getCd());
				statement.setInt(9,test.getNo());
				}
				count = statement.executeUpdate();
				}
			//プリペアードステートメントを実行
			} catch(Exception e) { 
				throw e;
			}	 finally {
			//プリペアードステートメントを閉じる
				if(statement != null) {
					try { 
						statement.close();
					} catch (SQLException sqle) {
						throw sqle;
					}
				}
			//コネクションを閉じる
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException sqle) {
						throw sqle;
					}
				}
			}
			
			if(count > 0) {
				//実行件数が1件以上ある場合
				return true;
			}else { 
			//実行件数が０件の場合
				return false;
			}
	}
//getメソッド	
	public Test get(Student student,int no) throws Exception{

		//得点インスタンスを初期化
		Test test=new Test();
		//データベースへのコネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		
		Subject subject = new Subject();
		School school = new School();
	
		try {
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from test where student_no=? and no=?");
			//プリペアードステートメントに学生番号をバインド
			statement.setString(1,student.getNo());
			statement.setInt(2,no);
			//プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();
			
			//学校Daoを初期化
			SchoolDao schoolDao = new SchoolDao();
			
			
			if(rSet.next()) {
				//リザルトセットが存在する場合
				//学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("student_no"));
				subject.setCd(rSet.getString("subject_cd"));
				school.setCd(rSet.getString("school_cd"));
				test.setStudent(student);
				test.setSubject(subject);
				test.setSchool(school);
				test.setNo(rSet.getInt("no"));
				test.setPoint(rSet.getInt("point"));
				test.setClassNum(rSet.getString("class_num"));
			} else {
				//リザルトセットが存在しない場合
				//インスタンスにnullをセット
				test = null;
			}
		}catch (Exception e){
			throw e;
		}finally{
			//プリペアードステートメントを閉じる
			if( statement != null) {
				try {
					statement.close();
				}catch (SQLException sqle){
					throw sqle;
				}
			}
		}
		return test;
	}
}