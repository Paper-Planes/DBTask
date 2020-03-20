package servlet;

import service.addInsurance;
import util.Format;
import vo.Insurance;
import vo.InsuranceType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "buyInsuranceServlet")
public class buyInsuranceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding ("utf-8");
        String plateNumber=request.getParameter("plateNumber");
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
        HttpSession session = request.getSession();
        InsuranceType buy=(InsuranceType)session.getAttribute("buy");
        String insNo=buy.getInsNo();


        Insurance i=new Insurance();
        i.setPlateNumber(plateNumber);
        i.setStartDate(startDate);
        i.setEndDate(endDate);
        i.setInsNo(insNo);
        i.setEmpNo("00001");
        addInsurance addinsurance=new addInsurance(i);
        try {
            addinsurance.doaddInsurance();
            ServletOutHtml.Out(response, addinsurance.getStatusMsg());
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
