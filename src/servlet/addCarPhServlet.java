package servlet;

import service.addCarPh;
import util.Format;
import vo.Car;
import vo.policyholder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "addCarPhServlet")
public class addCarPhServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding ("utf-8");
        String plateNumber=request.getParameter("plateNumber");
        String driLic=request.getParameter("driLic");
        String vehicleType=request.getParameter("vehicleType");
        String seat=request.getParameter("seat");
        String engine=request.getParameter("engine");
        String vinNo=request.getParameter("vinNo");
        String initialTime1=request.getParameter("initialTime");
        Date initialTime = new Date();
        try {
            initialTime = Format.StringToDate(initialTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String price=request.getParameter("price");//价格
        HttpSession session = request.getSession();
        policyholder ph=(policyholder)session.getAttribute("ph");
        String phNumber=ph.getPhNumber();


        Car car=new Car();
        car.setPlateNumber(plateNumber);
        car.setDriLic(driLic);
        car.setVehicleType(vehicleType);
        car.setSeat(seat);
        car.setEngine(engine);
        car.setVin(vinNo);
        car.setInitialTime(initialTime);
        car.setPrice(price);
        car.setPhNumber(phNumber);
        addCarPh addcarPh=new addCarPh(car);
        try {
            addcarPh.doaddCarPh();
            ServletOutHtml.Out(response, addcarPh.getStatusMsg());
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
