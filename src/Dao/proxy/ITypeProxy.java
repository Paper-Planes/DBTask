package Dao.proxy;


import Dao.ITypeDao;
import Dao.impl.ITypeDaoImpl;
import dbc.DatabaseConnection;
import vo.InsuranceType;

public class ITypeProxy implements ITypeDao {
    private DatabaseConnection dbc = null ;
    private ITypeDao dao = null ;
    public ITypeProxy() throws Exception {
        this.dbc = new DatabaseConnection() ;
        this.dao = new ITypeDaoImpl(this.dbc.getConnection()) ;
    }
    public InsuranceType findById(String plateNumber) throws Exception{//查
        InsuranceType i = null ;
        try{
            i = this.dao.findById(plateNumber) ;
        }catch(Exception e){
            throw e ;
        }finally{
            this.dbc.close() ;
        }
        return i ;
    }
}
