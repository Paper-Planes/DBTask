package servlet;

import service.phAccReportAdd;
import vo.AccReport;
import vo.policyholder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "phAccReportAddServlet")
public class phAccReportAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding ("utf-8");
        int iNo=Integer.parseInt(request.getParameter("iNo"));
        HttpSession session = request.getSession();
        policyholder ph=(policyholder)session.getAttribute("ph");
        String phNumber=ph.getPhNumber();
        String riskSpot=request.getParameter("riskSpot");
        String riskReason=request.getParameter("riskReason");

        AccReport accReport=new AccReport();
        accReport.setiNo(iNo);
        accReport.setPhNumber(phNumber);
        accReport.setReportTime(new java.util.Date());
        accReport.setRiskSpot(riskSpot);
        accReport.setRiskReason(riskReason);
        accReport.setAccstate("处理中");

        phAccReportAdd p=new phAccReportAdd(accReport);
        try {
          p.doAccReport();
            ServletOutHtml.Out(response, p.getStatusMsg());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
