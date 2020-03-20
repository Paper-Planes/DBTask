package Dao.proxy;

import Dao.IInsuranceDao;
import Dao.impl.InsuranceImpl;
import dbc.DatabaseConnection;
import vo.Insurance;
import java.util.List;

public class InsuranceProxy implements IInsuranceDao {
    private DatabaseConnection dbc = null ;
    private IInsuranceDao dao = null ;
    public InsuranceProxy() throws Exception {
        this.dbc = new DatabaseConnection() ;
        this.dao = new InsuranceImpl(this.dbc.getConnection()) ;
    }

    public boolean doCreate(Insurance i) throws Exception{//增
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


    public Insurance findById(int iNo) throws Exception{//查
        Insurance i = null ;
        try{
            i = this.dao.findById(iNo) ;
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return i ;
    }


    public List<Insurance> findByEmp(String phNumber) throws Exception{
        List<Insurance> all = null;
        try{
            all = this.dao.findByEmp(phNumber);
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return all ;
    }


    public boolean doUpdate(Insurance i) throws Exception{//改
        boolean flag = false ;
        try{
            if(this.dao.findById(i.getiNo()) != null){
                flag = this.dao.doUpdate(i) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }
}
