package vo;

import java.util.Date;

public class AccReport {
   private int AccNo;//报案编号
   private int  iNo;//保单号
   private String phNumber;//投保人账号
   private Date reportTime ;//报案时间
   private String riskSpot;//出险地点
   private String riskReason ;//出险原因
   private String Accstate ;//案件状态

    public void setAccNo(int accNo) {
        AccNo = accNo;
    }

    public void setiNo(int iNo) {
        this.iNo = iNo;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public void setRiskSpot(String riskSpot) {
        this.riskSpot = riskSpot;
    }

    public void setRiskReason(String riskReason) {
        this.riskReason = riskReason;
    }

    public void setAccstate(String accstate) {
        Accstate = accstate;
    }

    public int getAccNo() {
        return AccNo;
    }

    public int getiNo() {
        return iNo;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public String getRiskSpot() {
        return riskSpot;
    }

    public String getRiskReason() {
        return riskReason;
    }

    public String getAccstate() {
        return Accstate;
    }
}
