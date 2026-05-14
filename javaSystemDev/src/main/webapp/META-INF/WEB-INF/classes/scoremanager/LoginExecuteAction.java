package scoremanager;
 
import bean.Teacher;
import dao.TeacherDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;
 
public class LoginExecuteAction extends Action {
    public void execute(HttpServletRequest req,HttpServletResponse res) throws Exception {
        
        // 1. TeacherDaoでログイン認証
        HttpSession session = req.getSession();
        TeacherDao tdao = new TeacherDao();
        Teacher te=new Teacher();
        String id = (String)req.getAttribute("id");
        String password = (String)req.getAttribute("password");
        try {
        te = tdao.Login(id, password);
        if ( te != null ) {
            // 2. 教師情報を取得
            Teacher teacher =new Teacher();
            teacher =tdao.Get(id);
                       // 3. セッションに格納
                session.setAttribute("user", teacher);
               req.getRequestDispatcher("/menu.jsp").forward(req,res);
               
            }
        }catch (Exception e){
        	req.setAttribute("error", e);
        	req.getRequestDispatcher("main/error.jsp").forward(req,res);
        	}
    }
}