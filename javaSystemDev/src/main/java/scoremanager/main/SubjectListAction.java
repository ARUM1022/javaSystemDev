//インポート
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.Teacher;
import bean.subject;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjecListAction package scoremanager.main;
extends Action {
	
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();//セッション
		//セッション属性の準備
//		Teacher teacher = (Teacher)session.getAttribute("user");
		//セッション属性のuser情報をTeacherオブジェクト変数に代入
		//Teacher teacher = (Teacheer)session.getAttribute("user")
		
		//一時的にスクールオブジェクトを実体化する
		School school =  new School();
		//セッターを使って仮の学校情報を設定する
		school.setCd("tes");
		school.setName("テスト校");
		
		//一時的に講師オブジェクトを実体化する
		Teacher teacher = new Teacher();
		//セッターを使って仮の講師情報を設定する
		teacher.setId("admin1");
		teacher.setPassword("password");
		teacher.setName("管理者");
		teacher.setSchool(school);

		Map<String, String> errors = new HashMap<>();//エラーメッセージ	
			// 所属校の全科目情報を取得
			subjects = SubjectDao.filter(teacher.getSchool());

	}	
}