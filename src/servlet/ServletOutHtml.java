package servlet;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ServletOutHtml {
    public static void Out(HttpServletResponse response, String name) {
        try  {
            response.setContentType("text/html;charset=utf8");
            PrintWriter out = response.getWriter();
            out.println(name);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}