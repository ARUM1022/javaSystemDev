package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//ここにまだimportが追加される可能性あり

import org.eclipse.tags.shaded.org.apache.xpath.operations.String;

import bean.Subject;
import bean.Test;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao{
	
	private String baseSql = "select * from test where subject_cd=?";

	
	private List<TestListSubject> postFilter(ResultSet rSet, Test test) throws Exception{
		List<TestListSubject> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				//学生インスタンスを初期化
				TestListSubject tes=new TestListSubject();
				//学生インスタンスに検索結果をセット
				tes.setSubjectCd(rSet.getString("subject_cd"));
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
	public List<TestListSubject> filter(Subject subject) throws Exception{
		//リストを初期化
				List<TestListSubject> list = new ArrayList<>();
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
					statement.setString(1, subject.getCd());
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