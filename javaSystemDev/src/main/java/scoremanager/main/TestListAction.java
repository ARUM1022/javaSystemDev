package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;
import dao.ClassNumDao;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListAction extends Action {
	
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
//セッション
		HttpSession session = req.getSession();		
		//講師情報
		School school= new School();
		school = (School) session.getAttribute("school");
		//クラス情報
		List<String> classNumSet =new ArrayList<String>();
		ClassNumDao cDao =new ClassNumDao();
		classNumSet=cDao.filter(school);
		//科目情報
		List<Subject> subjectSet= new ArrayList<Subject>();
		SubjectDao sDao=new SubjectDao();
		subjectSet=sDao.filter(school);
		//リストを初期化
		LocalDate todaysDate = LocalDate.now();//LocalDateインスタンスを取得
		int year = todaysDate.getYear();
		List<Integer> entYearSet = new ArrayList<>();
		//10年前　から1年後まで年をリストに追加
		for(int i = year - 10; i < year + 1; i++) {
			entYearSet.add(i);
		}
		req.setAttribute("f1",entYearSet);
		req.setAttribute("f2",classNumSet);
		req.setAttribute("f3",subjectSet);
//フォワード
		req.getRequestDispatcher("/scoremanager/main/test_list.jsp").forward(req, res);
		
	
	}	
}