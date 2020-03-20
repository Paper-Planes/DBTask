package Dao.impl;


import Dao.IEmpDao;
import vo.Emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpImpl implements IEmpDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public EmpImpl(Connection conn){
        this.conn = conn ;
    }

    public boolean doCreate(Emp emp) throws Exception{//添加用户信息
        boolean flag = false ;
        //String sql = "INSERT INTO Emp(empNo,empPwd,empName,empSex,emp) VALUES (?,?,?,?,?)" ;
        this.pstmt = this.conn.prepareStatement("{call proEmpInsert(?,?,?,?,?)}") ;
        this.pstmt.setString(1,emp.getEmpNo());
        this.pstmt.setString(2,emp.getEmpPwd()) ;
        this.pstmt.setString(3,emp.getEmpName()) ;
        this.pstmt.setString(4,emp.getEmpSex()) ;
        this.pstmt.setString(5,emp.getEmp()) ;
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }


    public Emp findById(String empNo) throws Exception{//查看用户信息
        Emp emp = null ;
        //String sql = "SELECT empNo,empPwd,empName,empSex,emp FROM Emp WHERE empNo=?" ;
        this.pstmt = this.conn.prepareStatement("{call proEmpSearch(?)}") ;
        this.pstmt.setString(1,empNo); ;
        ResultSet rs = this.pstmt.executeQuery() ;
        if(rs.next()){
            emp=new Emp();
            emp.setEmpNo(rs.getString(1));
            emp.setEmpPwd(rs.getString(2));
            emp.setEmpName(rs.getString(3));
            emp.setEmpSex(rs.getString(4));
            emp.setEmp(rs.getString(5));
        }
        this.pstmt.close() ;
        return emp ;
    }

    public boolean doUpdate(Emp emp)throws Exception{//修改个人信息
        boolean flag = false ;
        //String sql = "update Emp set empName=?,empPwd=?,empSex=?, emp=? where empNo=?" ;
        this.pstmt = this.conn.prepareStatement("{call proEmpUpdate(?,?,?,?,?)}") ;
        this.pstmt.setString(1,emp.getEmpNo());
        this.pstmt.setString(2,emp.getEmpPwd()) ;
        this.pstmt.setString(3,emp.getEmpName()) ;
        this.pstmt.setString(4,emp.getEmpSex()) ;
        this.pstmt.setString(5,emp.getEmp()) ;
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }


    public boolean doDelete(String empNo) throws Exception{//删除用户信息
        boolean flag = false ;
        //String sql = "DELETE FROM Emp where empNo=?" ;
        this.pstmt = this.conn.prepareStatement("{call proEmpDelete(?)}") ;
        this.pstmt.setString(1,empNo);
        if(this.pstmt.executeUpdate() > 0){
            flag = true ;
        }
        this.pstmt.close() ;
        return flag ;
    }




}
