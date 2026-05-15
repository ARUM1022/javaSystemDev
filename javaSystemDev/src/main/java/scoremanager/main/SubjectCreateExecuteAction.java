package scoremanager.main;
import org.eclipse.tags.shaded.org.apache.xpath.operations.String;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectCreateExecuteAction  extends Action {
	
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
		
		Subject subject= new Subject();
		String cd = req.getParameter("cd");
		String name = req.getParameter("name");
		subject.setName(name);
		subject.setCd(cd);
		subject.setSchool(teacher.getSchool());
		SubjectDao sDao = new SubjectDao();

		try {
			sDao.save(subject);
		    req.getRequestDispatcher("/scoremanager/main/subject_create_done.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			req.getRequestDispatcher("error.jsp").forward(req,res);
		}
	}	
}