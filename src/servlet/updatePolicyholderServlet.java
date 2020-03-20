package servlet;

import service.updatePolicyholder;
import util.MD5;
import vo.policyholder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updatePolicyholderServlet")
public class updatePolicyholderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding ("utf-8");
        HttpSession session = request.getSession();

        policyholder ph=(policyholder) session.getAttribute("ph");
        String phNumber=ph.getPhNumber();
        String phName=request.getParameter("phName");
        MD5 getMD5 = new MD5();
        String phPwd1 =getMD5.GetMD5Code(request.getParameter("phPwd"));
        String phID=request.getParameter("phID");
        String phPhone=request.getParameter("phPhone");
        String phAddr=request.getParameter("phAddr");

        policyholder p=new policyholder();
        p.setPhNumber(phNumber);
        p.setPhName(phName);
        p.setPhPwd(phPwd1);
        p.setPhID(phID);
        p.setPhPhone(phPhone);
        p.setPhAddr(phAddr);
        updatePolicyholder updatepolicyholder=new updatePolicyholder(p);

        try {
            updatepolicyholder.doUpdatePolicyholder();
            ServletOutHtml.Out(response, updatepolicyholder.getStatusMsg());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
