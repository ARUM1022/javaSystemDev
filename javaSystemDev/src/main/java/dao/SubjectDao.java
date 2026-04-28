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

public class SubjectDao extends Dao{

	private List<Subject> postFilter(ResultSet rSet, School school) throws Exception{
		List<Subject> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				SubjectDao subjectDao = new SubjectDao();
				//科目インスタンスに検索結果をセット
				Subject.setCd(rSet.getString("cd"));
				Subject.setName(rSet.getString("name"));
					//学校フィールドには学校コードで検索した学校インスタンスをセット
				Student.setSchool(SchoolDao.get(rSet.getString("school_cd")));
				//リストに追加
				list.add(student);
			}
		}catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public List<Student> filter(School school,boolean isAttend) throws Exception{
		//リストを初期化
				List<Student> list = new ArrayList<>();
				//コネクションを確率
				Connection connection = getConnection();
				//プリペアードステートメント
				PreparedStatement statement = null;
				//リザルトセット
				ResultSet rSet = null;

				
				try {
					//プリペアードステートメントにSQL文をセット
					statement = connection.prepareStatement(
							"select * from subject where school_cd=?");
					//プリペアードステートメントに学校コードをバインド
					statement.setString(1, school.getCd());
					//プライベートステートメントを実行
					rSet = statement.executeQuery();
					//リストへの格納処理を実行
					list = postFilter(rSet,school);
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
//Saveメソッド
	public boolean save(Subject subject)throws Exception{
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		//実行件数
		int count = 0;
		try {
			//データベースから科目を取得
			Subject old = get(Subject.getCd());
			if (old == null) {
				//科目が存在しなかった場合
				//プリペアードステートメントにINSERT文をセット
				statement = connection.prepareStatement(
						"insert into subject(no,name,school) values(?, ?, ?)");
				//プリペアードステートメントに値をバインド
				statement.setString(1,subject.getCd());
				statement.setString(2,subject.getName());
				statement.setSchool(3,subject.getSchool().getCd());
			} else {
				//科目が存在した場合
				//プリペアードステートメントにUPDATE文をセット
				statement = connection
						.prepareStatement("update student set no=?, name=?, school=?");
				//プリペアードステートメントに値をバインド
				statement.setString(1,subject.getCd());
				statement.setString(2,subject.getName());
				statement.setSchool(3,subject.getSchool().getCd());
			} 
			//プリペアードステートメントを実行
			count = statement.executeUpdate();
		} catch(Exception e) { 
			throw e;
		} finally {
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
//Getメソッド	
	public Subject get(String cd,School school) throws Exception{

		//科目インスタンスを初期化
		Subject subject = new Subject();
		//データベースへのコネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
	
		try {
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement(
					"select * from subject where school_cd=? and cd=?");
			//プリペアードステートメントに学生番号をバインド
			statement.setString(1,school.getCd());
			statement.setString(2,cd);
			//プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();
			
			//学校Daoを初期化
			SubjectDao subjectDao = new SubjectDao();
			
			
			if(rSet.next()) {
				//リザルトセットが存在する場合
				//科目インスタンスに検索結果をセット
				subject.setCd(rSet.getString("cd"));
				subject.setName(rSet.getString("name"));
					//学校フィールドには学校コードで検索した学校インスタンスをセット
				subject.setSchool(SchoolDao.get(rSet.getString("school_cd")));
			} else {
				//リザルトセットが存在しない場合
				//科目インスタンスにnullをセット
				subject = null;
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
		return subject;
	}
//Deleteメソッド
	public boolean delete(Subject subject) throws Exception{
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		//実行件数
		int count = 0;
		try {
			//ステートメント準備
			PreparedStatement statement=(
					"delete * from subject where cd=?");
			statement.setString(1,subject.getCd());
			count = statement.executeUpdate();
		} catch(Exception e) { 
			throw e;
		} finally {
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
}