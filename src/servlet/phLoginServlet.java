package servlet;

import factory.DaoFactory;
import service.phLogin;
import util.MD5;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "phLoginServlet")
public class phLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String phNumber = request.getParameter("phNumber");
        MD5 getMD5 = new MD5();
        String phPwd =getMD5.GetMD5Code(request.getParameter("phPwd"));
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String savedCode = (String) session.getAttribute("check_code");

        if(savedCode.isEmpty() || !savedCode.equals(checkCode)) {
            session.removeAttribute("check_code");//加
            ServletOutHtml.Out(response, "<center><h1>验证码无效！</h1></center>");//注意这里
            return ;
        }
        else {
            session.removeAttribute("check_code");//加
            phLogin phlogin=new phLogin(phNumber,phPwd);
            try {
                if(phlogin.doLogin()== true) {
                    session.setAttribute("ph", DaoFactory.getIpolicyholderDaoInstance().findById(phNumber));
//                    session.setAttribute("PI",DaoFactory.getInsuranceInstance().findByEmp(phNumber));
                    session.setAttribute("PI",phNumber);
                    session.setAttribute("pwd", phPwd);
//                    session.setAttribute("self2", DaoFactory.getInstance3().findById(stuID));
                    request.getRequestDispatcher("/Task/ph.jsp").forward(request, response);
                }
                else {
                    ServletOutHtml.Out(response, phlogin.getStatusMsg());//注意这里
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
