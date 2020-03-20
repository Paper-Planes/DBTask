package Dao.impl;

import Dao.IInsuranceDao;
import vo.Insurance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InsuranceImpl implements IInsuranceDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public InsuranceImpl(Connection conn){
        this.conn = conn ;
    }

    public boolean doCreate(Insurance i) throws Exception{//添加保险信息
        boolean flag = false ;
        this.pstmt = this.conn.prepareStatement("{call proInsuranceInsert(?,?,?,?,?)}") ;
        this.pstmt.setString(1,i.getPlateNumber()) ;
        this.pstmt.setDate(2,new java.sql.Date(i.getStartDate().getTime()));
        this.pstmt.setDate(3,new java.sql.Date(i.getEndDate().getTime()));
        this.pstmt.setString(4,i.getInsNo());
        this.pstmt.setString(5,i.getEmpNo());
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }

    public Insurance findById(int iNo) throws Exception{//通过保险编号查看保险信息
        Insurance i = null ;
        this.pstmt = this.conn.prepareStatement("{call proInsuranceSearch(?)}") ;
        this.pstmt.setInt(1,iNo); ;
        ResultSet rs = this.pstmt.executeQuery() ;
        if(rs.next()){
            i=new Insurance();
            i.setiNo(rs.getInt(1));
            i.setPlateNumber(rs.getString(2));
            i.setStartDate(rs.getDate(3));
            i.setEndDate(rs.getDate(4));
            i.setInsNo(rs.getString(5));
            i.setEmpNo(rs.getString(6));
        }
        this.pstmt.close() ;
        return  i;
    }
    public List<Insurance> findByEmp(String phNumber) throws Exception {//通过用户名查看保险信息
        List<Insurance> all = new ArrayList<Insurance>();
        this.pstmt = this.conn.prepareStatement("{call proInsurancePhSearch(?)}");
        this.pstmt.setString(1,  phNumber );
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()) {
            Insurance i=new Insurance();
            i.setiNo(rs.getInt(1));
            i.setPlateNumber(rs.getString(2));
            i.setStartDate(rs.getDate(3));
            i.setEndDate(rs.getDate(4));
            i.setInsNo(rs.getString(5));
            i.setEmpNo(rs.getString(6));
            all.add(i);
        }
        return all;
    }
    public boolean doUpdate(Insurance i)throws Exception{//修改保险信息
        boolean flag = false ;
        this.pstmt = this.conn.prepareStatement("{call proInsuranceUpdate(?,?,?,?,?,?)}") ;
        this.pstmt.setInt(1,i.getiNo()); ;
        this.pstmt.setString(2,i.getPlateNumber()) ;
        this.pstmt.setDate(3,new java.sql.Date(i.getStartDate().getTime()));
        this.pstmt.setDate(4,new java.sql.Date(i.getEndDate().getTime()));
        this.pstmt.setString(5,i.getInsNo());
        this.pstmt.setString(6,i.getEmpNo());
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }


}
