package chapter5;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter5/greeting"})
public class Greeting extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
	//htmlページを日本語化する
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		//リクエストパラメータを日本語化する
		request.setCharacterEncoding("UTF-8");
		//requestオブジェクトのgetParameter("属性")で
		//リクエストパラメータを取り出す
		String user=request.getParameter("user");

		Page.header(out);
		out.println("<p>こんにちは、"+user+"さん！</p>");
		Page.footer(out);
	}
}
