package Dao.impl;

import Dao.ISurveyDao;
import vo.Survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SurveyImpl implements ISurveyDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public SurveyImpl(Connection conn){
        this.conn = conn ;
    }

    public boolean doCreate(Survey survey) throws Exception{//添加理赔信息
        boolean flag = false ;
        this.pstmt = this.conn.prepareStatement("{call proSurveyInsert(?,?,?,?)}") ;
        this.pstmt.setInt(1,survey.getAccNo());
        this.pstmt.setString(2,survey.getLostMoney());
        this.pstmt.setString(3,survey.getPayMoney()); ;
        this.pstmt.setString(4,survey.getEmpNo());
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }


    public Survey findById(int AccNo) throws Exception{//通过理赔编号，查看车辆信息
        Survey survey= null ;
        this.pstmt = this.conn.prepareStatement("{call proSurveySearch(?)}") ;
        this.pstmt.setInt(1,AccNo); ;
        ResultSet rs = this.pstmt.executeQuery() ;
        if(rs.next()){
            survey=new Survey();
            survey.setSurveyNumber(rs.getInt(1));
            survey.setAccNo(rs.getInt(2));
            survey.setLostMoney(rs.getString(3));
            survey.setPayMoney(rs.getString(4));
            survey.setEmpNo(rs.getString(5));
        }
        this.pstmt.close() ;
        return survey;
    }
    public List<Survey> findByEmp(String phNumber) throws Exception {//通过用户名查看保险信息
        List<Survey> all = new ArrayList<Survey>();
        this.pstmt = this.conn.prepareStatement("{call proSurveyPhSearch(?)}");
        this.pstmt.setString(1,  phNumber );
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()) {
            Survey survey=new Survey();
            survey.setSurveyNumber(rs.getInt(1));
            survey.setAccNo(rs.getInt(2));
            survey.setLostMoney(rs.getString(3));
            survey.setPayMoney(rs.getString(4));
            survey.setEmpNo(rs.getString(5));
            all.add(survey);
        }
        return all;
    }
}
