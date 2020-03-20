package Dao.proxy;

import Dao.ICarDao;
import Dao.impl.CarImpl;
import dbc.DatabaseConnection;
import vo.Car;
import java.util.List;

public class CarProxy implements ICarDao {
    private DatabaseConnection dbc = null ;
    private ICarDao dao = null ;
    public CarProxy() throws Exception {
        this.dbc = new DatabaseConnection() ;
        this.dao = new CarImpl(this.dbc.getConnection()) ;
    }

    public boolean doCreate(Car car) throws Exception{//增
        boolean flag = false ;
        try{
            if(this.dao.findById(car.getPlateNumber()) == null){
                flag = this.dao.doCreate(car) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }

    public boolean doUpdate(Car car) throws Exception{//改
        boolean flag = false ;
        try{
            if(this.dao.findById(car.getPlateNumber()) != null){
                flag = this.dao.doUpdate(car) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }
//    public List<Car> findByPh(String phNumber) throws Exception{//查
//        List<Car> all = null ;
//        try{
//            all = this.dao.findByPh(phNumber);
//        }catch(Exception e){
//            throw e ;
//        }finally{
//            this.dbc.close() ;
//        }
//        return all ;
//    }
public List<Car> findByEmp(String phNumber) throws Exception{
    List<Car> all = null ;
    try{
        all = this.dao.findByEmp(phNumber);
    }catch(Exception e){
        throw e ;
    }finally{
        this.dbc.close() ;
    }
    return all ;
}


    public boolean doDelete(String plateNumber) throws Exception{//删
        boolean flag = false ;
        try{
            if(this.dao.findById(plateNumber) != null){
                flag = this.dao.doDelete(plateNumber) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }


    public Car findById(String plateNumber) throws Exception{//查
        Car car = null ;
        try{
            car = this.dao.findById(plateNumber) ;
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return car ;
    }



}
