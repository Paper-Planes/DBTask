package vo;

public class InsuranceType {
    private String insNo    ;//保险编号
    private String insName  ;//保险名称
    private String insPrice;//保险金额

    public void setInsNo(String insNo) {
        this.insNo = insNo;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public void setInsPrice(String insPrice) {
        this.insPrice = insPrice;
    }

    public String getInsNo() {
        return insNo;
    }

    public String getInsName() {
        return insName;
    }

    public String getInsPrice() {
        return insPrice;
    }
}
