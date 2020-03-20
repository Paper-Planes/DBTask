package servlet;

import service.empLogin;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "empLoginServlet")
public class empLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String phNumber = request.getParameter("phNumber");
        String phPwd = request.getParameter("phPwd");
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String savedCode = (String) session.getAttribute("check_code");

        if(savedCode.isEmpty() || !savedCode.equals(checkCode)) {
            ServletOutHtml.Out(response, "<center><h1>验证码无效！，</h1></center>");//注意这里
            return ;
        }
        else {
            empLogin emplogin=new empLogin(phNumber,phPwd);
            try {
                if(emplogin.doLogin()== true) {
//                    session.setAttribute("self", DaoFactory.getInstance().findById(stuID));
//                    session.setAttribute("self2", DaoFactory.getInstance3().findById(stuID));
                    session.setAttribute("pwd", phPwd);
                    request.getRequestDispatcher("/Task/emp.jsp").forward(request, response);
                }
                else {
                    ServletOutHtml.Out(response,emplogin.getStatusMsg());//注意这里
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
