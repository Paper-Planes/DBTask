package servlet;

import service.phRegister;
import util.MD5;
import vo.policyholder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "phRegisterServlet")
public class phRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding ("utf-8");
        String phNumber = request.getParameter("phNumber");
        String phName = request.getParameter("phName");
        MD5 getMD5 = new MD5();
        String phPwd =getMD5.GetMD5Code(request.getParameter("phPwd"));
        String phID = request.getParameter("phID");
        String phPhone = request.getParameter("phPhone");
        String phAddr = request.getParameter("phAddr");

        policyholder ph=new policyholder();
        ph.setPhNumber(phNumber);
        ph.setPhPwd(phPwd);
        ph.setPhName(phName);
        ph.setPhID(phID);
        ph.setPhPhone(phPhone);
        ph.setPhAddr(phAddr);

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
            phRegister pR=new phRegister(ph);
            try {
                if(pR.doRegister()==true) {
                    ServletOutHtml.Out(response, pR.getStatus());//注意这里
                //    ServletOutHtml.Out(response, "<center><h1>注册成功</h1></center>");//注意这里
//                    PrintWriter out=response.getWriter();
//                    out.println("<script language=\"javascript\">" +"alert(\'注册成功！\')"+"</script>");
//                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                else {
                    ServletOutHtml.Out(response, pR.getStatus());//注意这里
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
