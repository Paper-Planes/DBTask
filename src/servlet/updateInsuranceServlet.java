package servlet;

import service.updateInsurance;
import util.Format;
import vo.Insurance;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "updateInsuranceServlet")
public class updateInsuranceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding ("utf-8");
        HttpSession session = request.getSession();
        Insurance insurance=(Insurance)session.getAttribute("I");
        int iNo=insurance.getiNo();
        String plateNumber=insurance.getPlateNumber();
        String startDate1=request.getParameter("startDate");
        Date startDate = new Date();
        try {
            startDate = Format.StringToDate(startDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String endDate1=request.getParameter("endDate");
        Date endDate = new Date();
        try {
            endDate = Format.StringToDate(endDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String iType=request.getParameter("iType");
        String empNo=request.getParameter("empNo");


        Insurance i=new Insurance();
        i.setiNo(iNo);
        i.setPlateNumber(plateNumber);
        i.setStartDate(startDate);
        i.setEndDate(endDate);
        i.setInsNo(iType);
        i.setEmpNo(empNo);
        updateInsurance updateinsurance=new updateInsurance(i);

        try {
            updateinsurance.doUpdateInsurance();
            ServletOutHtml.Out(response, updateinsurance.getStatusMsg());
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
