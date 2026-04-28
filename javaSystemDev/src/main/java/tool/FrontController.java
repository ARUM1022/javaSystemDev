package tool;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *Setvlet implementation class FrontController
 */
@WebServlet(urlPatterns = {"*.action"})
 public class FrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try {
			String path = req.getServletPath().substring(1);
			String name = path.replace(".action","Action").replace("/",".");
			
			System.out.println("★ servlet path ->" + req.getServletPath());
			System.out.println("★ class name ->" + name);
			
			//アクションクラスのインスタンスを返却
			Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();
			
			//遷移先URLを取得
			action.execute(req, res);
			//String url = action.execute(req,res);
			//req.getReqestDispatcher(url).forward(req,res);
			
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e);
			//errorページへリダイレクト
			req.getRequestDispatcher("/scoremanager/main/error.jsp").forward(req,res);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	    doGet(req, res);
	}
}
