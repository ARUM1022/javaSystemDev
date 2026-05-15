package scoremanager.main;
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
		Teacher teacher = (Teacher)session.getAttribute("user");
		

		
		Subject subject= new Subject();
		String cd = req.getParameter("cd");
		String name = req.getParameter("name");
		subject.setName(name);
		subject.setCd(cd);
		subject.setSchool(teacher.getSchool());
		SubjectDao sDao = new SubjectDao();

		try {
			sDao.save(subject);
		    req.getRequestDispatcher("subject_create_done.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			req.getRequestDispatcher("error.jsp").forward(req,res);
		}
	}	
}