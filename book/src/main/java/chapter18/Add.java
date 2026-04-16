package chapter18;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter18/add"})
public class Add extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		String name="studentNO";//クッキーのキーワードを設定
		String value="25666666";//クッキーのキーワードに対する値を設定
//	クッキークラスを実体化し、引数にnameとvalueを指定
		Cookie cookie=new Cookie(name, value);
//		クッキー☆の生存期間を設定（秒単位なので２４時間）
		cookie.setMaxAge(60*60*24);
//		クッキーを登録
		response.addCookie(cookie);
	}
}
