package scoremanager.main;
import bean.Subject;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateExecuteAction  extends Action {
	
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();//セッション
		Subject subject  = (Subject) req.getAttribute("subject");
		SubjectDao subjectDao = new SubjectDao();
		subjectDao.save(subject);
	    req.getRequestDispatcher("/scoremanager/main/subject_update_done.jsp").forward(req, res);
	}	
}