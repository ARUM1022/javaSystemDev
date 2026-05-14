package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.eclipse.tags.shaded.org.apache.xpath.operations.String;

import bean.Teacher;

public class TeacherDao extends Dao{

//Get メソッド
	public Teacher Get(String id) throws Exception{
		//Teacher初期化
		Teacher teacher = new Teacher();
		//データベースへのコネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント初期化
		PreparedStatement statement = null;
		try {
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select NAME from teacher where ID=?");
			//プリペアードステートメントに学生番号をバインド
			statement.setString(1,id);
			//プリペアードステートメントを実行
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
			teacher.setName(rs.getString("name"));
			//後始末
			}
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw e;
		}
		return teacher;
	}
//Loginメソッド
	public Teacher Login(String id, String password) throws Exception{
		Teacher teacher = new Teacher();
		//データベースへのコネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント初期化
		PreparedStatement statement = null;
		try {
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from teacher where ID=? and PASSWORD=?");
			//プリペアードステートメントにIDをバインド
			statement.setString(1,id);
			//プリペアードステートメントにパスをバインド
			statement.setString(2,password);
			//プリペアードステートメントを実行
			ResultSet rs = statement.executeQuery();
			//リザルトセットが存在するならログイン成功
			if (rs.next()){
					teacher.setId(rs.getString(id));
					teacher.setPassword(rs.getString(password));
				} else {
					teacher = null;
				}
			//後始末
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw e;
		}
		return teacher;
	}
}