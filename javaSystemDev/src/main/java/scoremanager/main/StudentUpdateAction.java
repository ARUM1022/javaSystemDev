package scoremanager.main;

import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateAction extends Action {
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();
		String no= req.getParameter("no");
		StudentDao sDao = new StudentDao();
		ClassNumDao cDao = new ClassNumDao();
		Student student = (Student) sDao.get(no);
		Teacher teacher = (Teacher) session.getAttribute("user");
		String entYear = String.valueOf(student.getEntYear());
		String name = student.getName();
		List<String> class_num = cDao.filter(teacher.getSchool());
		req.setAttribute("ent_year",entYear);
		req.setAttribute("no",no);
		req.setAttribute("name",name);
		req.setAttribute("class_num", class_num);
		req.getRequestDispatcher("/scoremanager/main/student_update.jsp").forward(req,res);
	}
}