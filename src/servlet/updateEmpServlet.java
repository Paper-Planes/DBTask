package servlet;

import service.updateEmp;
import vo.Emp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updateEmpServlet")
public class updateEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding ("utf-8");
        HttpSession session = request.getSession();

        Emp em=(Emp) session.getAttribute("em");
        String empNo=em.getEmpNo();
        String empName=request.getParameter("empName");
        String empSex=request.getParameter("empSex");
        String position=request.getParameter("position");
        String empPwd1=request.getParameter("empPwd1");

        Emp e=new Emp();
        e.setEmpNo(empNo);
        e.setEmpName(empName);
        e.setEmpSex(empSex);
        e.setEmp(position);
        e.setEmpPwd(empPwd1);
        updateEmp updateemp=new updateEmp(e);
        try {
            updateemp.doUpdateEmp();
            ServletOutHtml.Out(response, updateemp.getStatusMsg());
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
