package servlet;

import service.deleteEmp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteEmpServlet")
public class deleteEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String empNo = request.getParameter("delete");
        HttpSession session = request.getSession();
        deleteEmp deleteemp=new deleteEmp(empNo);
        try {
            if(deleteemp.doDeleteEmp()==true) {
                PrintWriter out = response.getWriter();
                out.println("<center><h1>删除成功！</h1><center>");
            }
            else {
                ServletOutHtml.Out(response,deleteemp.getStatusMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
