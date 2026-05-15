package scoremanager.main;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;
import bean.TestListSubject;
import dao.TestListSubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListSubjectAction extends Action {
	
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();//セッション
//教科情報を取得
		Subject subject=new Subject();
		subject=(Subject) req.getAttribute("subject");
		List<TestListSubject> tests= new ArrayList<TestListSubject>();
		//Daoから成績を引っ張る
		TestListSubjectDao tDao=new TestListSubjectDao();
		try {
			tests=tDao.filter(subject);
			req.setAttribute("tests",tests);
		    req.getRequestDispatcher("/scoremanager/main/test_list.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("error", e);
			req.getRequestDispatcher("error.jsp").forward(req,res);
		}
	}	
}