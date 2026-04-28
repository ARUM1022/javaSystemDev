package scoremanager.main;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		StudentDao sDao = new StudentDao();
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");
		Student student = new Student();
		int entYear = Integer.parseInt(req.getParameter("ent_year"));
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String class_num = req.getParameter("class_num");
		boolean isAttend = req.getParameter("is_attend") != null;
		School school = teacher.getSchool();
		student.setClassNum(class_num);
		student.setEntYear(entYear);
		student.setisAttend(isAttend);
		student.setName(name);
		student.setNo(no);
		student.setSchool(school);
		sDao.save(student);
		
		req.getRequestDispatcher("/scoremanager/main/student_create_done.jsp").forward(req,res);
	}
}