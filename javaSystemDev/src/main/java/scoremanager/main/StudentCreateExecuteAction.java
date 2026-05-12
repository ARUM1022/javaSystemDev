package scoremanager.main;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentCreateExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		StudentDao sDao = new StudentDao();
		HttpSession session = req.getSession(); 
		Student student = new Student();
		Teacher teacher = (Teacher) session.getAttribute("user");
		School school = teacher.getSchool();
		String no = req.getParameter("no");
		
		
		
		
		String entYearStr = req.getParameter("ent_year");

		if (entYearStr == null || entYearStr.equals("0")) {
		    req.setAttribute("yearError", true);
		    req.getRequestDispatcher("/scoremanager/main/student_create.jsp").forward(req, res);
		    return;
		}

		int entYear = Integer.parseInt(entYearStr);
		String name = req.getParameter("name");
		String classNum = req.getParameter("class_num");
		boolean isAttend = true;
		
		student.setClassNum(classNum);
		student.setEntYear(entYear);
		student.setName(name);
		student.setNo(no);
		student.setSchool(school);
		student.setisAttend(isAttend);
		sDao.save(student);
		req.getRequestDispatcher("/scoremanager/main/student_create_done.jsp").forward(req,res);
	}
}