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
		List<String> classList = cDao.filter(teacher.getSchool());
//		System.out.println(classList);
//		System.out.println(teacher);
//		System.out.println(teacher.getSchool());
		req.setAttribute("classList", classList);
		req.getRequestDispatcher("/scoremanager/main/student_create.jsp").forward(req,res);

		
	}
}