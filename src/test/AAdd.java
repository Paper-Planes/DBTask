package test;

import factory.DaoFactory;
import vo.AccReport;

public class AAdd {
    public static void main(String args[])throws Exception{
        AccReport accReport=new AccReport();
        accReport.setiNo(2);
        accReport.setPhNumber("0002");
        accReport.setReportTime(new java.util.Date());
        accReport.setRiskSpot("河南省");
        accReport.setRiskReason("发生意外");
        accReport.setAccstate("处理中");
        DaoFactory.getIAccReporttance().doCreate(accReport);
    }
}
