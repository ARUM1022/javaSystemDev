package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//ここにまだimportが追加される可能性あり

import bean.School;
import bean.Teacher;
import bean.ClassNum;
import bean.Test;

public class TestDao extends Dao{

//Get メソッド
	private Test Get(Student student,Subject subject,School school,int no) throws Exception{
		//Test初期化
		Test test = new Test();
		//データベースへのコネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント初期化
		PreparedStatement statement = null;
		try {
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select POINT from test where STUDENT_NO=? and SUBJECT_CD=? and SCHOOL_CD=? and NO=?");
			//プリペアードステートメントにバインド
			statement.setString(1,student.getNo);
			statement.setString(2,subject.getCd());
			statement.setString(3,school.getCd);
			statement.setInt(4,no);
			//プリペアードステートメントを実行
			resultset rs = statement.executeQuery();
			test.setInt(rs.getInt("POINT"));
			//後始末
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw e;
		}
		return test;
	}
	//postFilterメソッド
	private List<Test> postFilter(ResultSet rSet, School school) throws Exception{
		List<Test> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				//成績インスタンスを初期化
				Test test = new test();
				//成績インスタンスに検索結果をセット
				test.setStudent(rSet.getString("student"));
				test.setSubject(rSet.getString("subject"));
				test.setSchool(school);
				test.setInt(rSet.getInt("no"));
				test.setInt(rSet.getInt("point"))
				//リストに追加
				list.add(test);
			}
		}catch (Exception e) {
			throw e;
		}
		return list;
	}
	//Filterメソッド
	public List<Test> filter(int entYear,String classNum,Subject subject,int num,School school) throws Exception{
		//リストを初期化
				List<Test> list = new ArrayList<>();
				//コネクション
				Connection connection = getConnection();
				//プリペアードステートメント
				PreparedStatement statement = null;
				//リザルトセット
				ResultSet rSet = null;
				try {
				//entYearから学生番号特定
					statement = connection.prepareStatement(
							"select NO from student where ent_year=?");
					statement.setString(1,school.getEntYear());
					rSet = statement.executeQuery();
					//学生ごとのデータ出す
					while (rSet.next()) {
						//プリペアードステートメントにSQL文をセット
					statement = connection.prepareStatement(
						"select POINT from test where school_cd=?and class_num=? and subject_cd=? and student_no=?");
					//プリペアードステートメントにバインド
					statement.setString(1,school.getCd());
					statement.setString(2,classNum.getClassNum()));
					statement.setString(3,subject.getCd());
					statement.setInttring(4.rSet.getInt());
					//プライベートステートメントを実行
					rSet = statement.executeQuery();
					//リストへの格納処理を実行
					list = postFilter(rSet,school);	
					}				
					//後始末
					statement.close();
					connection.close();
				} catch (Exception e) {
					throw e;
				}
				return list;
	}
	
	
	
