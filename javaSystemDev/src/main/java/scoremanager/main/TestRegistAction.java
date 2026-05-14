package scoremanager.main;

import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestRegistAction extends Action{
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception {
		
		//一時的にスクールオブジェクトを実体化する
				School school =  new School();
				//セッターを使って仮の学校情報を設定する
				school.setCd("tes");
				school.setName("テスト校");
				//一時的に講師オブジェクトを実体化する
				Teacher teacher = new Teacher();
				//セッターを使って仮の講師情報を設定する
				teacher.setId("admin1");
				teacher.setPassword("password");
				teacher.setName("管理者");
				teacher.setSchool(school);

				HttpSession session = req.getSession();
				session.setAttribute("user",teacher);
		String entYear = req.getParameter("f1");
		String classNum = req.getParameter("f2");
		String subjectCd = req.getParameter("f3");
		String testno = req.getParameter("f4");
//		HttpSession session = req.getSession();
//		Teacher teacher = (Teacher) session.getAttribute("user");
		
		ClassNumDao cDao = new ClassNumDao();
		List<String> classNumSet = cDao.filter(school);
		req.setAttribute("class_num_set",classNumSet);
		
		SubjectDao sDao = new SubjectDao();
		List<Subject> subjectSet = sDao.filter(school);
		req.setAttribute("subject_set", subjectSet);
		
		if (entYear==null||entYear.equals("0") ||classNum==null|| classNum.equals("0") ||subjectCd==null|| subjectCd.equals("0") ||testno==null|| testno.equals("0")) {
		
			req.setAttribute("error", "未選択があります");
			
		}
		req.getRequestDispatcher("test_regist.jsp").forward(req,res);
		
	}
}