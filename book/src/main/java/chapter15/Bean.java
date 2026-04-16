package chapter15;
//BeanにあるProductをインポートする
import java.io.IOException;
import java.io.PrintWriter;

import bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/bean"})
public class Bean extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
//		Productクラスを実体化する
		Product p=new Product();
	//	それぞれのフィールドに値を設定する
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);
//		ゲッターでフィールドの中身を取得する
		out.println(p.getId());
		out.println("：");
		out.println(p.getName());
		out.println("：");
		out.println(p.getPrice());

		Page.footer(out);
	}
}
