package servlet;

import service.addEmp;
import vo.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addEmpServlet")
public class addEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding ("utf-8");
        String empNo=request.getParameter("empNo");
        String empPwd1=request.getParameter("empPwd");
        String empName=request.getParameter("empName");
        String empSex=request.getParameter("empSex");
        String emp=request.getParameter("emp");


        Emp em=new Emp();
        em.setEmpNo(empNo);
        em.setEmpPwd(empPwd1);
        em.setEmpName(empName);
        em.setEmpSex(empSex);
        em.setEmp(emp);
        addEmp addemp=new addEmp(em);
        try {
            addemp.doaddEmp();
            ServletOutHtml.Out(response, addemp.getStatusMsg());
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
