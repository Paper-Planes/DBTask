package vo;


import java.util.Date;

public class Car {
    private String plateNumber;//车牌号
    private String driLic;//行驶证12位
    private String  engine;//发动机号
    private String vin;//车架号码
    private String vehicleType; //车辆类型
    private String seat; //核定座位
    private Date initialTime;//初次登记时间
    private String price; //新车购置价
    private String phNumber; //车主

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setDriLic(String driLic) {
        this.driLic = driLic;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setInitialTime(Date initialTime) {
        this.initialTime = initialTime;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getDriLic() {
        return driLic;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getSeat() {
        return seat;
    }

    public String getEngine() {
        return engine;
    }

    public String getVin() {
        return vin;
    }

    public Date getInitialTime() {
        return initialTime;
    }

    public String getPrice() {
        return price;
    }

    public String getPhNumber() {
        return phNumber;
    }
}
