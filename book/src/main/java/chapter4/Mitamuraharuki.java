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
@WebServlet(urlPatterns={"/chapter4/mitamuraharuki"})
//HttpServletを継承させる
//クラス名の上に記述すること
public class Mitamuraharuki extends HttpServlet {
//	親クラスであるHttpServletが持つdoGet()メソッドをオーバーロードする
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
//		レスポンスを出力するストリームを生成
		PrintWriter out=response.getWriter();
//		オブジェクトoutのprintln()メソッドで画面に出力
		out.println("mitamura haruki");
	}
}
