package vo;

public class Survey {
    private int SurveyNumber;//查勘编号
    private  int AccNo;//报案编号
    private String LostMoney;//顾客损失金额
    private String PayMoney;//赔付金额
    private  String empNo;//工作人员

    public void setSurveyNumber(int surveyNumber) {
        SurveyNumber = surveyNumber;
    }

    public void setAccNo(int accNo) {
        AccNo = accNo;
    }

    public void setLostMoney(String lostMoney) {
        LostMoney = lostMoney;
    }

    public void setPayMoney(String payMoney) {
        PayMoney = payMoney;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public int getSurveyNumber() {
        return SurveyNumber;
    }

    public int getAccNo() {
        return AccNo;
    }

    public String getLostMoney() {
        return LostMoney;
    }

    public String getPayMoney() {
        return PayMoney;
    }

    public String getEmpNo() {
        return empNo;
    }
}
