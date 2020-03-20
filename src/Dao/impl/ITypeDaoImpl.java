package Dao.impl;

import Dao.ITypeDao;
import vo.InsuranceType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ITypeDaoImpl implements ITypeDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public ITypeDaoImpl(Connection conn){
        this.conn = conn ;
    }
    public InsuranceType findById(String plateNumber) throws Exception{//查看保险类型信息
        InsuranceType i = null ;
        this.pstmt = this.conn.prepareStatement("{call proITSearch(?)}") ;
        this.pstmt.setString(1,plateNumber); ;
        ResultSet rs = this.pstmt.executeQuery() ;
        if(rs.next()){
            i=new InsuranceType();
            i.setInsNo(rs.getString(1));
            i.setInsName(rs.getString(2));
            i.setInsPrice(rs.getString(3));
        }
        this.pstmt.close() ;
        return i;
    }
}
