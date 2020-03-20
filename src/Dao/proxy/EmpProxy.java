package Dao.proxy;

import Dao.IEmpDao;
import Dao.impl.EmpImpl;
import dbc.DatabaseConnection;
import vo.Emp;

public class EmpProxy implements IEmpDao {
    private DatabaseConnection dbc = null ;
    private IEmpDao dao = null ;
    public EmpProxy() throws Exception {
        this.dbc = new DatabaseConnection() ;
        this.dao = new EmpImpl(this.dbc.getConnection()) ;
    }

    public boolean doCreate(Emp emp) throws Exception{//增
        boolean flag = false ;
        try{
            if(this.dao.findById(emp.getEmpNo()) == null){
                flag = this.dao.doCreate(emp) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }


    public Emp findById(String empNo) throws Exception{//查
        Emp emp = null ;
        try{
            emp = this.dao.findById(empNo) ;
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return emp ;
    }
    public boolean doUpdate(Emp emp) throws Exception{//改
        boolean flag = false ;
        try{
            if(this.dao.findById(emp.getEmpNo()) != null){
                flag = this.dao.doUpdate(emp) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }

    public boolean doDelete(String empNo) throws Exception{//删
        boolean flag = false ;
        try{
            if(this.dao.findById(empNo) != null){
                flag = this.dao.doDelete(empNo) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }

}
