package factory;

import Dao.*;
import Dao.proxy.*;

public class DaoFactory {
    public static IpolicyholderDao getIpolicyholderDaoInstance() {
        IpolicyholderDao dao = null;
        try{
            dao = new policyholderProxy();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dao;
    }
    public static IEmpDao getEmpInstance() {
        IEmpDao dao = null;
        try{
            dao = new EmpProxy();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dao;
    }
    public static ICarDao getCarInstance() {
        ICarDao dao = null;
        try{
            dao = new CarProxy();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dao;
    }
    public static IInsuranceDao getInsuranceInstance() {
        IInsuranceDao dao = null;
        try{
            dao = new InsuranceProxy();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dao;
    }
    public static ITypeDao getITypeInstance() {
        ITypeDao dao = null;
        try{
            dao = new ITypeProxy();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dao;
    }

    public static IAccReportDao getIAccReporttance() {
        IAccReportDao dao = null;
        try{
            dao = new AccReportProxy();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dao;
    }
    public static ISurveyDao getISurveytance() {
        ISurveyDao dao = null;
        try{
            dao = new SurveyProxy();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dao;
    }
}
