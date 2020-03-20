package Dao.impl;

import Dao.IpolicyholderDao;
import vo.policyholder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class policyholderImpl implements IpolicyholderDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public policyholderImpl(Connection conn){
        this.conn = conn ;
    }

    public boolean doCreate(policyholder ph) throws Exception{//添加用户信息
        boolean flag = false ;
        this.pstmt = this.conn.prepareStatement("{call proPhCreate(?,?,?,?,?,?)}") ;
        this.pstmt.setString(1,ph.getPhNumber());
        this.pstmt.setString(2,ph.getPhPwd()) ;
        this.pstmt.setString(3,ph.getPhName()) ;
        this.pstmt.setString(4,ph.getPhID()) ;
        this.pstmt.setString(5,ph.getPhPhone());
        this.pstmt.setString(6,ph.getPhAddr());
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }
    public policyholder findById(String phNumber) throws Exception{//通过输入ID查看用户信息
        policyholder ph = null ;
        this.pstmt = this.conn.prepareStatement("{call proPhSearch(?)}") ;
        this.pstmt.setString(1,phNumber); ;
        ResultSet rs = this.pstmt.executeQuery() ;
        if(rs.next()){
            ph=new policyholder();
            ph.setPhNumber(rs.getString(1));
            ph.setPhPwd(rs.getString(2));
            ph.setPhName(rs.getString(3));
            ph.setPhID(rs.getString(4));
            ph.setPhPhone(rs.getString(5));
            ph.setPhAddr(rs.getString(6));
        }
        this.pstmt.close() ;
        return ph ;
    }

    public boolean doUpdate(policyholder ph)throws Exception{//修改全部信息
        boolean flag = false ;
        this.pstmt = this.conn.prepareStatement("{call proPhUpdate(?,?,?,?,?,?)}") ;
        this.pstmt.setString(1,ph.getPhNumber());
        this.pstmt.setString(2,ph.getPhPwd()) ;
        this.pstmt.setString(3,ph.getPhName()) ;
        this.pstmt.setString(4,ph.getPhID()) ;
        this.pstmt.setString(5,ph.getPhPhone());
        this.pstmt.setString(6,ph.getPhAddr());
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }


//    public boolean doDelete(String phNumber) throws Exception{//删除用户信息
//        boolean flag = false ;
//        String sql = "DELETE FROM policyholder where phNumber=?" ;
//        this.pstmt = this.conn.prepareStatement(sql) ;
//        this.pstmt.setString(1,phNumber);
//        if(this.pstmt.executeUpdate() > 0){
//            flag = true ;
//        }
//        this.pstmt.close() ;
//        return flag ;
//    }


//    public List<policyholder> findAll(String keyWord) throws Exception {
//        List<policyholder> all = new ArrayList<policyholder>();
//        String sql = "SELECT phNumber,phName,phPwd1,phPwd2,phID,phPhone,phAddr FROM policyholder WHERE phNumber LIKE ?  ";
//        this.pstmt = this.conn.prepareStatement(sql);
//        this.pstmt.setString(1, "%" + keyWord + "%");
//        ResultSet rs = this.pstmt.executeQuery();
//        while (rs.next()) {
//            policyholder ph = new policyholder();
//            ph.setPhNumber(rs.getString(1));
//            ph.setPhPwd(rs.getString(3));
//            ph.setPhName(rs.getString(2));
//            ph.setPhID(rs.getString(5));
//            ph.setPhPhone(rs.getString(6));
//            ph.setPhAddr(rs.getString(7));
//            all.add(ph);
//        }
//        return all;
//    }

}
