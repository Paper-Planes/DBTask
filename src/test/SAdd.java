package test;

import factory.DaoFactory;
import vo.Survey;

public class SAdd {
    public static void main(String args[])throws Exception{
        Survey survey=new Survey();
        survey.setAccNo(3);
        survey.setLostMoney("1000");
        survey.setPayMoney("800");
        survey.setEmpNo("00004");
        DaoFactory.getISurveytance().doCreate(survey);
    }
}
