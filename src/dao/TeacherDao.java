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
			teacher = statement.executeQuery();
			//後始末
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw e;
		}
		return teacher;
	}
//Loginメソッド
	public boolean Login(String id, String password) throws Exception{
		//validでidpassの組み合わせあるか返す
		boolean valid = new boolean();
		valid = false;
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
					valid = true;
				} else {
					valid = false;
				}
			//後始末
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw e;
		}
		return valid;
	}	