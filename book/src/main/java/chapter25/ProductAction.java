package chapter25;

import java.util.List;

import bean.Product;
import dao.ProductDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class ProductAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
//セッション属性を取得
		HttpSession session=request.getSession();
//ユーザーが入力した検索キーワードを「取得する
		String keyword=request.getParameter("keyword");
//		カート情報がからの場合
		if (keyword==null) keyword="";

		ProductDAO dao=new ProductDAO();
		List<Product> list=dao.search(keyword);

		session.setAttribute("list", list);

		return "product.jsp";
	}
}
