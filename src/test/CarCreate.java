package test;

import factory.DaoFactory;
import vo.Car;

public class CarCreate {
    public static void main(String args[])throws Exception{
        Car c=new Car();
        c.setPlateNumber("9999");
        c.setVehicleType("000");
        c.setInitialTime(new java.util.Date());
        c.setPrice("111");
        c.setVin("");
        c.setSeat("");
        c.setDriLic("001");
        c.setPhNumber("0001");
        c.setEngine("001");
        DaoFactory.getCarInstance().doCreate(c);
    }

}
