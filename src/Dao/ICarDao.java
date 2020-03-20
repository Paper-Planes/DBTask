package Dao;

import vo.Car;
import java.util.List;

public interface ICarDao extends IDao<Car,String>{
    //继承IDao接口就可以，提高了代码的复用性，也可以自己定义功能方法
    public boolean doUpdate(Car car)throws Exception;
    public boolean doDelete(String plateNumber) throws Exception;
    public List<Car> findByEmp(String phNumber) throws Exception;
}
