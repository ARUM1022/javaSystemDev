package chapter4;
 
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
// HttpServletクラスをインポートする
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;
 
// 以下のアノテーションでURLに対応するサーブレットを起動する
// URL:http://localhost:8080/book/chapter3/hello
@WebServlet(urlPatterns={"/chapter4/hello4"})
// HttpServlet を継承させる
// クラス名の上に記述すること
public class Hello4 extends HttpServlet {
	// 親クラスであるHttpServletがもつdoGet()メソッドをオーバーロード
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		// 注意！
		response.setContentType("text/html; charset=UTF-8");
		// レスポンスを出力するストリームを生成
		PrintWriter out=response.getWriter();
//		別の場所にあるPageクラスのheader()メソッドを呼び出す
//		header()メソッドはクラス（静的）メソッドであるため、Pageクラスを実体化せずとも呼び出すことができる
		Page.header(out);
		// オブジェクトoutのprintln()メソッドで画面に出力
		out.println("<p>Hello Servlet22222!");
		out.println("<p>こんにちは！");
		// 同じくprintln()メソッドで画面に出力
		out.println(new java.util.Date());
		//英字で自分の名前を出力したスクショを提出
		Page.footer(out);
	}
}