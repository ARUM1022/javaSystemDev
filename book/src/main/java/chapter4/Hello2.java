package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@ = アノテーション（注釈）でURLに対応するサーブレットを起動する
//URL https://localhost:8080/book/chapter3/hello
@WebServlet(urlPatterns={"/chapter4/hello2"})
//HttpServletを継承させる
//クラス名の上に記述すること
public class Hello2 extends HttpServlet {
//	親クラスであるHttpServletが持つdoGet()メソッドをオーバーロードする
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
//		日本語化の文言
		response.setContentType("text/plain; charset=UTF-8");
//		レスポンスを出力するストリームを生成
		PrintWriter out=response.getWriter();
//		オブジェクトoutのprintln()メソッドで画面に出力
		out.println("hello!");
//		同じくprintln()メソッドで画面に出力
		out.println("こんにちは！");
		out.println(new java.util.Date());
	}
}
