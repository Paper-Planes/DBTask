package servlet;

import service.addSurvey;
import vo.Survey;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addSurveyServlet")
public class addSurveyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding ("utf-8");
        int AccNo=Integer.parseInt(request.getParameter("AccNo"));
        String LostMoney=request.getParameter("LostMoney");
        String PayMoney=request.getParameter("PayMoney");
        String empNo=request.getParameter("empNo");

        Survey survey=new Survey();
        survey.setAccNo(AccNo);
        survey.setLostMoney(LostMoney);
        survey.setPayMoney(PayMoney);
        survey.setEmpNo(empNo);
        addSurvey add=new addSurvey(survey);
        try {
            add.doaddSurvey();
            ServletOutHtml.Out(response, add.getStatusMsg());
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
