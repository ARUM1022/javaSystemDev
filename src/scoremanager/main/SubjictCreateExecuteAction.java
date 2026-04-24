package scoremanager.main;
//インポート
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.Teacher;
import bean.subject;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjecCreateExecuteAction extends Action {
	
	@Webserblet(/createsubject)
	public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception{
		
		//所属校情報を受け取る
		
		//入力受け取り
		String.subcd=request.getParameter("cd");
		String.name=request.getParameter("name");
		//チェック
		String error=null;
		if (String.length(subcd) !=3){
			error="科目コードは3文字で入力してください";			
			RequestDispatcher rd=request.getRequestDispatcher("subject_create.jsp");
			forward(request,response);
		}
		//DBに問合せ
		else {
			Lis = SubjectDao.filter(Cd,subcd);
			//科目コード重複の場合
			if Lis.contains(subcd){
				error="科目コードが重複しています";
				RequestDispatcher rd=request.getRequestDispatcher("subject_create.jsp");
				forward(request,response);
			}
			//科目コード重複しない場合　書き込んで完了画面へ
			else {
				try{
					SubjectDao.Save(Cd.subcd.name);
					RequestDispatcher rd=request.getRequestDispatcher("subject_create_done.jsp");
					forward(request,response);
				}
				catch (Exception e) {throw e}		
			}
		}
	}	
}