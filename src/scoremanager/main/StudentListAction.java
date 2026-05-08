package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentListAction extends Action {
	
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();//セッション
		//セッション属性の準備
//		Teacher teacher = (Teacher)session.getAttribute("user");
		//セッション属性のuser情報をTeacherオブジェクト変数に代入
		//Teacher teacher = (Teacheer)session.getAttribute("user")
		
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
		
		//ローカル変数の指定
		String entYearStr = "";//入力された入学年度
		String classNum = "";//入力されたクラス番号
		String isAttendStr = "";//入力された在学フラグ
		int entYear = 0;//入学年度
		boolean isAttend = false;//在学フラグ
		List<Student> students = null;//学生リスト
		LocalDate todaysDate = LocalDate.now();//LocalDateインスタンスを取得
		int year = todaysDate.getYear();//現在の年を取得
		StudentDao sDao = new StudentDao();//学生Dao
		ClassNumDao cNumDao = new ClassNumDao();//クラス番号Daoを初期化
		Map<String, String> errors = new HashMap<>();//エラーメッセージ	
		
		//リクエストパラメータの取得２
		entYearStr = req.getParameter("f1");//入力された入学年度
		classNum = req.getParameter("f2");//入力されたクラス番号
		isAttendStr = req.getParameter("f3");//入力された在学フラグ
		
		//ビジネスロック４
		if (entYearStr != null) {
			//数値に変換
			entYear = Integer.parseInt(entYearStr);
		}
		if (isAttendStr != null) {
			//在学フラグをtruenに変更
			isAttend = true;
		}
		//リストを初期化
		List<Integer> entYearSet = new ArrayList<>();
		//10年前　から1年後まで年をリストに追加
		for(int i = year - 10; i < year + 1; i++) {
			entYearSet.add(i);
		}
		
		//DBからデータ取得 3
		//ログインユーザーの学校コードをもとにクラス番号の一覧を崇徳
		List<String> list= cNumDao.filter(teacher.getSchool());
		
		if (entYear != 0 && !classNum.equals("0")) {
			//入学年度とクラス番号を指定
			students=sDao.filter(teacher.getSchool(), entYear,classNum,isAttend);	
			} else if (entYear != 0 && classNum.equals("0")) {
				//入学年度のみ指定
			students = sDao.filter(teacher.getSchool(),entYear,classNum, isAttend);
		} else if(entYear == 0 && classNum == null || entYear == 0 && classNum.equals("0")) {
			// 指定なしの場合
			// 全学生情報を取得
			students = sDao.filter(teacher.getSchool(),isAttend);
		} else {
			errors.put("f1","クラスを指定する場合は入学年度も指定してください");
			req.setAttribute("errors",errors);
			// 全学年情報を取得
			students = sDao.filter(teacher.getSchool(),isAttend);
		}
	}	
}