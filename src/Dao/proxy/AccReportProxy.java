package Dao.proxy;

import Dao.IAccReportDao;
import Dao.impl.AccReportImpl;
import dbc.DatabaseConnection;
import vo.AccReport;

import java.util.List;

public class AccReportProxy implements IAccReportDao {
    private DatabaseConnection dbc = null ;
    private IAccReportDao dao = null ;
    public AccReportProxy() throws Exception {
        this.dbc = new DatabaseConnection() ;
        this.dao = new AccReportImpl(this.dbc.getConnection()) ;
    }

    public boolean doCreate(AccReport i) throws Exception{//增
        boolean flag = false ;
        try{
            if(this.dao.findById(i.getiNo()) == null){
                flag = this.dao.doCreate(i) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }


    public AccReport findById(int iNo) throws Exception{//查
        AccReport i = null ;
        try{
            i = this.dao.findById(iNo) ;
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return i ;
    }
    public List<AccReport> findByEmp(String phNumber) throws Exception{
        List<AccReport> all = null;
        try{
            all = this.dao.findByEmp(phNumber);
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return all ;
    }
}
