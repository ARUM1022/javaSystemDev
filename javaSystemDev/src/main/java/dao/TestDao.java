package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//ここにまだimportが追加される可能性あり

import org.eclipse.tags.shaded.org.apache.xpath.operations.String;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDao extends Dao{
	
	private String baseSql = "select * from test where school_cd=? and subject_cd=?";

	
	private List<Test> postFilter(ResultSet rSet, Test test) throws Exception{
		List<Test> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				//学生インスタンスを初期化
				Test test=new Test();
				//学生インスタンスに検索結果をセット
				test.setStudentNo(rSet.getString("student_no"));
				test.setSubjectCd(rSet.getString("subject_cd"));
				test.setSchoolCd(rSet.getString("school_cd"));
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
				String condition = "and class_num=? and no=?";	
				try {
					//プリペアードステートメントにSQL文をセット
					statement = connection.prepareStatement(baseSql + condition);
					//プリペアードステートメントに学校コードをバインド
					statement.setString(1, school.getCd());
					statement.setString(2, subject.getCd());
					statement.setString(3, classNum);
					statement.setString(4,no);
					//プライベートステートメントを実行
					rSet = statement.executeQuery();
					//リストへの格納処理を実行
					list = postFilter(rSet,test);
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
			//データベースから学取得
			Test old = get(test.getSubject());
			if (old == null) {
				//結果が存在しなかった場合
				//プリペアードステートメントにINSERT文をセット
				statement = connection.prepareStatement(
						"insert into test(student_no,subject_cd,school_cd,no,point,class_num) values(?, ?, ?, ?, ?, ?)");
				//プリペアードステートメントに値をバインド
				statement.setString(1,test.getStudentNo());
				statement.setString(2,test.getSubjectCd());
				statement.setString(3,test.getSchoolCd());
				statement.setInt(4, test.getNo());
				statement.setInt(5,test.getPoint());
				statement.setString(6,test.getClassNum());
			} else {
				//結果が存在した場合
				//プリペアードステートメントにUPDATE文をセット
				statement = connection
						.prepareStatement("update stest set student_no=?,subject_cd=?,School_cd=?,no=?,point=?,class_num=?");
				//プリペアードステートメントに値をバインド
				statement.setString(1,test.getStudentNo());
				statement.setString(2,test.getSubjectCd());
				statement.setString(3,test.getSchoolCd());
				statement.setInt(4, test.getNo());
				statement.setInt(5,test.getPoint());
				statement.setString(6,test.getClassNum());
			}
			//プリペアードステートメントを実行
			count = statement.executeUpdate();
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
	
		try {
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement(baseSql+"and student_no=?+ no=?");
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
				test.setStudentNo(rSet.getString("student_no"));
				test.setSubjectCd(rSet.getString("subject_cd"));
				test.setSchoolCd(rSet.getString("school_cd"));
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
			if( connection != null) {
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