package test;

import factory.DaoFactory;
import util.Format;
import vo.Insurance;

import java.text.ParseException;
import java.util.Date;

public class IAdd {
    public static void main(String args[])throws Exception{
        Insurance i=new Insurance();
        i.setPlateNumber("豫A01");
        i.setStartDate(new java.util.Date());
        String endDate1="2020-01-09";
        Date endDate = new Date();
        try {
            endDate = Format.StringToDate(endDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        i.setEndDate(endDate);
        i.setInsNo("004");
        i.setEmpNo("待审核");
        DaoFactory.getInsuranceInstance().doCreate(i);
    }
}
