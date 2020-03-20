package service;

import factory.DaoFactory;
import vo.Car;

public class addCarPh {
    private Car car;
    private String statusMsg;
    public addCarPh(Car car) {
        this.car= car;
    }
    public boolean doaddCarPh() throws Exception {
        boolean flag = false;
        if(DaoFactory.getCarInstance().doCreate(this.car)) {
            this.statusMsg =  "<center><h1>信息添加成功</h1></center>";
            flag = true;
        }
        else {
            this.statusMsg =  "<center><h1>信息添加失败</h1></center>";
        }
        return flag;
    }

    public String getStatusMsg() {
        return statusMsg;
    }
}
