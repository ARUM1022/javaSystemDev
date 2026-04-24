package scoremanager.main;

import bean.Student;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentCreateExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		StudentDao sDao = new StudentDao();
		HttpSession session = req.getSession(); 
		Student student = (Student) req.getAttribute("student");
//		sDao.save(student);
	}
}