package Dao.proxy;

import Dao.ISurveyDao;
import Dao.impl.SurveyImpl;
import dbc.DatabaseConnection;
import vo.Survey;
import java.util.List;

public class SurveyProxy implements ISurveyDao {
    private DatabaseConnection dbc = null ;
    private ISurveyDao dao = null ;
    public SurveyProxy() throws Exception {
        this.dbc = new DatabaseConnection() ;
        this.dao = new SurveyImpl(this.dbc.getConnection()) ;
    }

    public boolean doCreate(Survey i) throws Exception{//增
        boolean flag = false ;
        try{
            if(this.dao.findById(i.getSurveyNumber()) == null){
                flag = this.dao.doCreate(i) ;
            }
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return flag ;
    }


    public Survey findById(int iNo) throws Exception{//查
        Survey i = null ;
        try{
            i = this.dao.findById(iNo) ;
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return i ;
    }
    public List<Survey> findByEmp(String phNumber) throws Exception{
        List<Survey> all = null;
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
