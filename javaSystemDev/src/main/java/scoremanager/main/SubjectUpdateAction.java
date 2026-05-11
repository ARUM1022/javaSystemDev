package scoremanager.main;

import org.eclipse.tags.shaded.org.apache.xpath.operations.String;

import bean.Subject;
import bean.Teacher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectUpdateAction extends Action{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");
		Subject subject = new Subject();
		String cd = req.getAttribute("cd").toString();
		String name = req.getParameter("name").toString();
		subject.setName(name);
		subject.setCd(cd);
		
		req.setAttribute("subject", subject);
		req.getRequestDispatcher("/scoremanager/main/subject_update.jsp").forward(req,res);
	}
}