package scoremanager.main
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.Student;
import bean.Teacher;
import bean.Subject;
import dao.SubjectDao;
import dao.TeacherDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectDeleteExecuteAction  extends Action {
	
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();//セッション
		Subject subject  = (Subject) req.getAttribute("subject");
		if(SubjectDao.delete(subject) == true){
		    req.getRequestDispatcher("subject_delete_done.jsp").forward(req, res);
		}else {
		    req.getRequestDispatcher("subject_delete_done.jsp").forward(req, res);
		}
	}	
}