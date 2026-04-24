package scoremanager;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LogoutAction extends Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession user_session = request.getSession(false);
		
		// ⭐ ここを追加
		if(user_session != null) {
			user_session.invalidate();  // セッション削除
		}
		
		// ⭐ ここも追加（ログイン画面に転送）
		request.getRequestDispatcher("logout.jsp")
			.forward(request, response);
	}		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}