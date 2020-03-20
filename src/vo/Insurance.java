package vo;

import java.util.Date;

public class Insurance {
    private  int iNo;//保单编号
    private String plateNumber;//车
    private Date startDate;//保险开始时间
    private Date endDate;//保险截至时间

    private String insNo;//保险类型
    private String empNo;//工作人员

    public String getInsNo() {
        return insNo;
    }
    public void setInsNo(String insNo) {
        this.insNo = insNo;
    }

    public int getiNo() {
        return iNo;
    }

    public void setiNo(int iNo) {
        this.iNo = iNo;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }


    public String getPlateNumber() {
        return plateNumber;
    }


    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }


    public String getEmpNo() {
        return empNo;
    }
}
