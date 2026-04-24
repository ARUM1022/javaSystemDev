package scoremanager.main;

import java.util.List;

import bean.Student;
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
		Student student = new Student();
		req.setAttribute("classList", classList);
		
		student.setClassNum(req.getParameter("class_num"));
		int entYear = Integer.parseInt(req.getParameter("ent_year"));
		String name = req.getParameter("name").toString();
		student.setEntYear(entYear);
		String no = req.getParameter("no").toString();
		student.setName(name);
		student.setNo(no);
		student.setisAttend(true);
		student.setSchool(teacher.getSchool());
		
		req.setAttribute("student", student);
		req.getRequestDispatcher("/scoremanager/main/student_create.jsp").forward(req,res);
	}
}