package scoremanager.main;
 
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
        String id = (String)req.getParameter("id");// Attribute -> Parameter
//        System.out.println(id);
        String password = (String)req.getParameter("password"); //　〃
//        System.out.println(password);
        try {
        Teacher teacher = tdao.Login(id, password);
        if ( teacher != null ) {
        	Teacher name = (Teacher)tdao.Get(id);
            // 2. 教師情報を取得
//            System.out.println(teacher);
                       // 3. セッションに格納
        	teacher.setAuthenticated(true);
        	teacher.setName(name.getName());
            System.out.println("exeAction" + teacher);
            System.out.println("exeAction" + teacher.getSchool());
                session.setAttribute("user", teacher);
               req.getRequestDispatcher("/scoremanager/main/menu.jsp").forward(req,res);
               
            }else {
            	req.setAttribute("error", "IDまたはパスワードが違います");
            	
            	req.getRequestDispatcher("../login.jsp").forward(req, res);
            }
        }catch (Exception e){
        	req.setAttribute("error", e);
//        	e.printStackTrace();
        	req.getRequestDispatcher("/scoremanager/main/error.jsp").forward(req,res);
        	}
    }
}