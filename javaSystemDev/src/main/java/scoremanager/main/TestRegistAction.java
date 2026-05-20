package scoremanager.main;

import java.util.List;

import bean.School;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.ClassNumDao;
import dao.SubjectDao;
import dao.TestDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestRegistAction extends Action{
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception {
		
		//一時的にスクールオブジェクトを実体化する
//				School school =  new School();
//				//セッターを使って仮の学校情報を設定する
//				school.setCd("tes");
//				school.setName("テスト校");
//				//一時的に講師オブジェクトを実体化する
//				Teacher teacher = new Teacher();
//				//セッターを使って仮の講師情報を設定する
//				teacher.setId("admin1");
//				teacher.setPassword("password");
//				teacher.setName("管理者");
//				teacher.setSchool(school);
		//↓
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");
		session.setAttribute("user",teacher);
		//↑ここはどこのjavaに行っても入ってないといけない。
		
		
		//↓検索された条件を受け取る
		System.out.println("1");
		String entYear = req.getParameter("f1");

		System.out.println("2");
		String classNum = req.getParameter("f2");

		System.out.println("3");
		String subjectCd = req.getParameter("f3");

		System.out.println("4");
		String testno = req.getParameter("f4");

		System.out.println("5");
//		HttpSession session = req.getSession();
		//↓ログイン中のteacherメソッドから学校コード、学校名を引き出し、ClassDaoのfilterを呼び出し、結果をlistに格納
		School school = (School) teacher.getSchool();
		ClassNumDao cDao = new ClassNumDao();
		System.out.println("59行ClassNumDao");
		List<String> classNumSet = cDao.filter(school);
		//↓setAttributeで、ページへデータを送信する
		req.setAttribute("class_num_set",classNumSet);
		
		//↓SubjectDaoで科目を取得、Listに格納
		SubjectDao sDao = new SubjectDao();
		System.out.println("66行SubjectDao");
		Subject subject = sDao.get(subjectCd, school);
		System.out.println("68行SubjectDao");
		List<Subject> subjectSet = sDao.filter(school);
		req.setAttribute("subject_set", subjectSet);
		
		//↓全てデータが入力されているかを調べるだけ。気にしなくてよい
		if (entYear==null||entYear.equals("0") ||classNum==null|| classNum.equals("0") ||subjectCd==null|| subjectCd.equals("0") ||testno==null|| testno.equals("0")) {
			req.setAttribute("error", "未選択があります");
		}else {
			TestDao tDao = new TestDao();
			System.out.println("77行TestDao");
			List<Test> test = tDao.filter(Integer.parseInt(entYear), classNum,subject , Integer.parseInt(testno), school);
			req.setAttribute("c", test);			
		}
		//（　＾ω＾）・・・
		req.getRequestDispatcher("/scoremanager/main/test_regist.jsp").forward(req,res);
		
	}
}