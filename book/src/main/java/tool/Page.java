package tool;

import java.io.PrintWriter;


//共通している個所は1か所にまとめて記載する
//修正時にその箇所だけを直せばよいので楽
public class Page{

public static void header(PrintWriter out) {
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<meta charset='UTF-8'>");
out.println("<title>Servlet/JSP Sample Program</title>");
out.println("</head>");
out.println("<body>");;
}
public static void footer(PrintWriter out) {
out.println("</body>");
out.println("</html>");;

}

}

