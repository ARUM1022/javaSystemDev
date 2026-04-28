package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//ここにまだimportが追加される可能性あり

import org.eclipse.tags.shaded.org.apache.xpath.operations.String;

import bean.Student;
import bean.Test;
import bean.TestListStudent;

public class TestListStudentDao extends Dao{
	
	private String baseSql = "select * from test where student_no=?";

	
	private List<TestListStudent> postFilter(ResultSet rSet, Test test) throws Exception{
		List<TestListStudent> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				//学生インスタンスを初期化
				TestListStudent tes=new TestListStudent();
				//学生インスタンスに検索結果をセット
				tes.setStudentNo(rSet.getString("student_no"));
				tes.setPoint(rSet.getInt("point"));
				//リストに追加
				list.add(tes);
			}
		}catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return list;
	}

//filterメソッド	
	public List<TestListStudent> filter(Student student) throws Exception{
		//リストを初期化
				List<TestListStudent> list = new ArrayList<>();
				//コネクションを確率
				Connection connection = getConnection();
				//プリペアードステートメント
				PreparedStatement statement = null;
				//リザルトセット
				ResultSet rSet = null;
				try {
					//プリペアードステートメントにSQL文をセット
					statement = connection.prepareStatement(baseSql);
					//プリペアードステートメントに学生番号をバインド
					statement.setString(1, student.getNo());
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
}