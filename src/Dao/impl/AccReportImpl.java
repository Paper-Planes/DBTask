package Dao.impl;

import Dao.IAccReportDao;
import Dao.IInsuranceDao;
import vo.AccReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccReportImpl implements IAccReportDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public AccReportImpl(Connection conn){
        this.conn = conn ;
    }

    public boolean doCreate(AccReport accReport) throws Exception{
        boolean flag = false ;
        this.pstmt = this.conn.prepareStatement("{call proAccReportInsert(?,?,?,?,?,?)}") ;
        this.pstmt.setInt(1,accReport.getiNo());
        this.pstmt.setString(2,accReport.getPhNumber()) ;
        this.pstmt.setDate(3,new java.sql.Date(accReport.getReportTime().getTime())); ;
        this.pstmt.setString(4,accReport.getRiskSpot());
        this.pstmt.setString(5,accReport.getRiskReason()) ;
        this.pstmt.setString(6,accReport.getAccstate()) ;
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }


    public AccReport findById(int AccNo) throws Exception{
        AccReport accReport = null ;
        this.pstmt = this.conn.prepareStatement("{call proAccReportSearch(?)}") ;
        this.pstmt.setInt(1,AccNo); ;
        ResultSet rs = this.pstmt.executeQuery() ;
        if(rs.next()){
            accReport=new AccReport();
            accReport.setAccNo(rs.getInt(1));
            accReport.setiNo(rs.getInt(2));
            accReport.setPhNumber(rs.getString(3));
            accReport.setReportTime(rs.getDate(4));
            accReport.setRiskSpot(rs.getString(5));
            accReport.setRiskReason(rs.getString(6));
            accReport.setAccstate(rs.getString(7));
        }
        this.pstmt.close() ;
        return accReport;
    }
    public List<AccReport> findByEmp(String phNumber) throws Exception {
        List<AccReport> all = new ArrayList<AccReport>();
        this.pstmt = this.conn.prepareStatement("{call proAccReporPhSearch(?)}");
        this.pstmt.setString(1,  phNumber );
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()) {
            AccReport accReport=new AccReport();
            accReport.setAccNo(rs.getInt(1));
            accReport.setiNo(rs.getInt(2));
            accReport.setPhNumber(rs.getString(3));
            accReport.setReportTime(rs.getDate(4));
            accReport.setRiskSpot(rs.getString(5));
            accReport.setRiskReason(rs.getString(6));
            accReport.setAccstate(rs.getString(7));
            all.add(accReport);
        }
        return all;
    }
}
