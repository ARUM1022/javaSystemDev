package scoremanager.main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

	
public class SubjectListAction extends Action {	
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();//セッション
		//セッション属性の準備
//		Teacher teacher = (Teacher)session.getAttribute("user");
		//セッション属性のuser情報をTeacherオブジェクト変数に代入
		Teacher teacher = (Teacher)session.getAttribute("user");
		
		//一時的にスクールオブジェクトを実体化する
//		School school =  new School();
		//セッターを使って仮の学校情報を設定する
		
		//一時的に講師オブジェクトを実体化する
//		Teacher teacher = new Teacher();
		//セッターを使って仮の講師情報を設定する

		SubjectDao subjectDao = new SubjectDao();
		
		List<Subject> subjects = null;

		Map<String, String> errors = new HashMap<>();//エラーメッセージ	
			// 所属校の全科目情報を取得
			subjects = subjectDao.filter(teacher.getSchool());
				req.setAttribute("subjects",subjects);
				//JSPへフォワード
				req.getRequestDispatcher("subject_list.jsp").forward(req, res);
			subjects = subjectDao.filter(teacher.getSchool());
			//JSPへフォワード
		    req.getRequestDispatcher("/scoremanager/main/subject_list.jsp").forward(req, res);

	}	
}