package chapter25;

import java.util.List;

import bean.Item;
import dao.PurchaseDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PurchaseAction extends Action {
	@SuppressWarnings("unchecked")
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
//
		HttpSession session=request.getSession();
//		リクエストパラメータを受けとる（名前と住所を受け取る）
		String name=request.getParameter("name");
		String address=request.getParameter("address");
//		名前もしくは住所がからだった場合はerrorページへ遷移させる
		if (name.isEmpty() || address.isEmpty()) {
			return "purchase-error-empty.jsp";
		}
//		PurchaseDAOクラスを実体化する
		PurchaseDAO dao=new PurchaseDAO();
//		セッション属性からカート情報を取得する
		List<Item> cart=(List<Item>)session.getAttribute("cart");
//		カート情報がからもしくはDBへのinsertが失敗した場合、errorページに遷移させる
		if (cart==null || !dao.insert(cart, name, address)) {
//							「!」は、0なら1を返すやつ
//		DBへのinsertが完了したらDBのセッション属性のカート情報を削除する			
			return "purchase-error-insert.jsp";
		}
//		「購入手続きが完了しまいた」ページに遷移する
		request.setAttribute("cart", cart);

		session.removeAttribute("cart");

		return "purchase-out.jsp";
	}
}
