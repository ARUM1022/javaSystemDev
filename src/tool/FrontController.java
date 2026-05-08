package tool;
import java.io.IOException;
import jakarta.servlet.http.HttpServletResponse;

@Webservlet("/FrontController")
public class FrontController extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletExeption,IOException{
		try {
			String path=req.getServletPath().substring(1);
			String name=path.replace("a", "A").replace("/", ".");
			System.out.println("★ servlet path→"+req.getServletPath());
			System.out.println("★ class name→"+name);
			Action action=(Action) Class.forName(name).getDeclaredConstructor().newInstance();
			action.execute(req.res);
			}
		catch(Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/error.jsp").forward(req.res);
			}
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletExeption,IOException{
		doGet(request,response);
	}
}
