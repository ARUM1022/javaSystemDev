package scoremanager.main;
import bean.Student;
import bean.Test;
import bean.TestListStudent;
import dao.StudentDao;
import dao.TestListStudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListStudentAction extends Action {
	
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();//セッション
		//セッション属性の準備
//		Teacher teacher = (Teacher)session.getAttribute("user");
		//セッション属性のuser情報をTeacherオブジェクト変数に代入
		//Teacher teacher = (Teacheer)session.getAttribute("user")
		
		//成績オブジェクトを実体化する
		Test test =  new Test();
		//セッターを使って仮の学校情報を設定する
		test.setStudent(req.getStudent());
		test.setNo(0);
		test.setPoint(0);
		//学生番号から生徒を逆引き
		Student st=new Student();
		StudentDao sDao= new StudentDao();
		st=sDao.get(req.getStudent());
		List<TestListStudent> tests= new List<TestListStudent>();
		//Daoから成績を引っ張る
		TestListStudentDao tDao=new TestListStudentDao();
		try {
			tests=tDao.filter(st);
			tests=res.setAttribute("tests");
		    req.getRequestDispatcher("/scoremanager/main/test_list.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			req.getRequestDispatcher("error.jsp").forward(req,res);
		}
	}	
}