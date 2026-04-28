package scoremanager.main;

import java.util.List;

import bean.Teacher;
import dao.ClassNumDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentCreateAction extends Action{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");
		ClassNumDao cDao = new ClassNumDao();
		List<String> no = cDao.filter(teacher.getSchool());
		req.setAttribute("no", no);
		req.getRequestDispatcher("/scoremanager/main/student_create.jsp").forward(req,res);

		
	}
}