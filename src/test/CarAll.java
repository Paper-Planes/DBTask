package test;

import factory.DaoFactory;
import vo.Car;
import java.util.Iterator;
import java.util.List;

public class CarAll {
    public static void main(String args[]) throws Exception{
        List<Car> all = DaoFactory.getCarInstance().findByEmp("0001");
        Iterator<Car> iter = all.iterator() ;
        while(iter.hasNext()){
            Car emp = iter.next() ;
            System.out.println(emp.getVin());
        }
    }
}
