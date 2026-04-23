package scoremanager;

import bean.School;
import dao.SchoolDao;
import dao.TeacherDao;
import 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LoginAction extends Action {
	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String login=request.getParameter("login");
		String password=request.getParameter("password");

		School dao=new SchoolDao();
		School school=dao.search(login, password);
		
		if (customer!=null) {
			session.setAttribute("customer", customer);
			return "login-out.jsp";
		}
		
		return "error.jsp";
	}
}
