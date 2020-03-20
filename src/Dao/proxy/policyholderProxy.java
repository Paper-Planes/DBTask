package Dao.proxy;

import Dao.IpolicyholderDao;
import Dao.impl.policyholderImpl;
import dbc.DatabaseConnection;
import vo.policyholder;


public class policyholderProxy implements IpolicyholderDao {
    private DatabaseConnection dbc = null ;
    private IpolicyholderDao dao = null ;
    public policyholderProxy() throws Exception {
        this.dbc = new DatabaseConnection() ;
        this.dao = new policyholderImpl(this.dbc.getConnection()) ;
    }

    public boolean doCreate(policyholder ph) throws Exception{//增
        boolean flag = false ;
        try{
            if(this.dao.findById(ph.getPhNumber()) == null){
                flag = this.dao.doCreate(ph) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }


    public policyholder findById(String phNumber) throws Exception{//查
        policyholder ph = null ;
        try{
            ph = this.dao.findById(phNumber) ;
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return ph ;
    }

    public boolean doUpdate(policyholder ph) throws Exception{//改
        boolean flag = false ;
        try{
            if(this.dao.findById(ph.getPhNumber()) != null){
                flag = this.dao.doUpdate(ph) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }

//    public boolean doDelete(String phNumber) throws Exception{//删
//        boolean flag = false ;
//        try{
//            if(this.dao.findById(phNumber) != null){
//                flag = this.dao.doDelete(phNumber) ;
//            }
//        }catch(Exception e){
//            throw e ;
//        }finally{
//            this.dbc.close() ;
//        }
//        return flag ;
//    }


//    public List<policyholder> findAll(String keyWord) throws Exception{
//        List<policyholder> all = null ;
//        try{
//            all = this.dao.findAll(keyWord) ;
//        }catch(Exception e){
//            throw e ;
//        }finally{
//            this.dbc.close() ;
//        }
//        return all ;
//    }

}
