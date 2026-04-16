package chapter24;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LogoutAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();
//		セッション属性から顧客Beanがあるかどうかを調べる
//		（ユーザーがログイン中かどうかの判定）
		if (session.getAttribute("customer")!=null) {
//			セッション属性から顧客Beanを削除
			session.removeAttribute("customer");
			return "logout-out.jsp";
		}
		
		return "logout-error.jsp";
	}
}
