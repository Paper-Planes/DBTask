package Dao.impl;

import Dao.ICarDao;
import vo.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarImpl implements ICarDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public CarImpl(Connection conn){
        this.conn = conn ;
    }

    public boolean doCreate(Car car) throws Exception{//添加车辆信息
        boolean flag = false ;
        this.pstmt = this.conn.prepareStatement("{call proCarCreate(?,?,?,?,?,?,?,?,?)}") ;
        this.pstmt.setString(1,car.getPlateNumber());
        this.pstmt.setString(2,car.getDriLic()) ;
        this.pstmt.setString(3,car.getEngine()) ;
        this.pstmt.setString(4,car.getVin());
        this.pstmt.setString(5,car.getVehicleType()) ;
        this.pstmt.setString(6,car.getSeat()) ;
        this.pstmt.setDate(7,new java.sql.Date(car.getInitialTime().getTime())); ;
        this.pstmt.setString(8,car.getPrice()); ;
        this.pstmt.setString(9,car.getPhNumber()) ;
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }


    public boolean doUpdate(Car car)throws Exception{//修改车辆信息
        boolean flag = false ;
        //String sql = "update Car set driLic=?,vehicleType=?, seat=?, engine=?, vin=?,initialTime=?, price=?,phNumber=? where plateNumber=?" ;
        this.pstmt = this.conn.prepareStatement("{call proCarUpdate(?,?,?,?,?,?,?,?,?)}") ;
        this.pstmt.setString(1,car.getPlateNumber());
        this.pstmt.setString(2,car.getDriLic()) ;
        this.pstmt.setString(3,car.getEngine()) ;
        this.pstmt.setString(4,car.getVin());
        this.pstmt.setString(5,car.getVehicleType()) ;
        this.pstmt.setString(6,car.getSeat()) ;
        this.pstmt.setDate(7,new java.sql.Date(car.getInitialTime().getTime())); ;
        this.pstmt.setString(8,car.getPrice());
        this.pstmt.setString(9,car.getPhNumber()) ;
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }


    public boolean doDelete(String plateNumber) throws Exception{//删除车辆信息
        boolean flag = false ;
        //String sql = "DELETE FROM Car where plateNumber=?" ;
        this.pstmt = this.conn.prepareStatement("{call proCarDelete(?)}") ;
        this.pstmt.setString(1,plateNumber);
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }


    public Car findById(String plateNumber) throws Exception{//通过车牌照，查看车辆信息
        Car car = null ;
        this.pstmt = this.conn.prepareStatement("{call proCarSearch(?)}") ;
        this.pstmt.setString(1,plateNumber); ;
        ResultSet rs = this.pstmt.executeQuery() ;
        if(rs.next()){
            car=new Car();
            car.setPlateNumber(rs.getString(1));
            car.setDriLic(rs.getString(2));
            car.setEngine(rs.getString(3));
            car.setVin(rs.getString(4));
            car.setVehicleType(rs.getString(5));
            car.setSeat(rs.getString(6));
            car.setInitialTime(rs.getDate(7));
            car.setPrice(rs.getString(8));
            car.setPhNumber(rs.getString(9));
        }
        this.pstmt.close() ;
        return car ;
    }

//    public List<Car> findByPh(String phNumber) throws Exception{//查看车辆信息
//        List<Car> all = new ArrayList<Car>();
////        String sql = "SELECT plateNumber,driLic,engine, vin,vehicleType, seat, initialTime, price,phNumber FROM Car WHERE phNumber= ?  ";
////        this.pstmt = this.conn.prepareStatement(sql) ;
//        this.pstmt = this.conn.prepareStatement("{call prophCarSearch(?)}") ;
//        this.pstmt.setString(1,phNumber); ;
//        ResultSet rs = this.pstmt.executeQuery() ;
//        if(rs.next()){
//            Car car=new Car();
//            car.setPlateNumber(rs.getString(1));
//            car.setDriLic(rs.getString(2));
//            car.setEngine(rs.getString(3));
//            car.setVin(rs.getString(4));
//            car.setVehicleType(rs.getString(5));
//            car.setSeat(rs.getString(6));
//            car.setInitialTime(rs.getDate(7));
//            car.setPrice(rs.getString(8));
//            car.setPhNumber(rs.getString(9));
//            all.add(car);
//        }
//        return all;
//    }

    public List<Car> findByEmp(String phNumber) throws Exception {
        List<Car> all = new ArrayList<Car>();
        //String sql = "SELECT iNo, plateNumber, phNumber, startDate, endDate, iType, empNo FROM Insurance WHERE phNumber=?" ;
        this.pstmt = this.conn.prepareStatement("{call prophCarSearch(?)}");
        this.pstmt.setString(1,  phNumber );
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()) {
            Car car=new Car();
            car.setPlateNumber(rs.getString(1));
            car.setDriLic(rs.getString(2));
            car.setEngine(rs.getString(3));
            car.setVin(rs.getString(4));
            car.setVehicleType(rs.getString(5));
            car.setSeat(rs.getString(6));
            car.setInitialTime(rs.getDate(7));
            car.setPrice(rs.getString(8));
            car.setPhNumber(rs.getString(9));
            all.add(car);
        }
        return all;
    }
}
