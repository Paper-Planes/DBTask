package service;

import factory.DaoFactory;
import vo.policyholder;

public class phRegister {
    private policyholder ph;
    public String status;
    public phRegister(policyholder ph) {
        this.ph = ph;
    }
    public boolean doRegister() throws Exception {
        boolean flag = false;
        if(ph== DaoFactory.getIpolicyholderDaoInstance().findById(this.ph.getPhNumber())) {
            this.status =  "<center><h1>该用户已存在！</h1></center>";
        }
        else if(DaoFactory.getIpolicyholderDaoInstance().doCreate(this.ph)) {
            this.status = "<center><h1>注册成功！</h1></center>";
            flag = true;
        }
        else {
            this.status = "<center><h1>系统繁忙，请稍后重试！</h1></center>";
        }
        return flag;
    }
    public String getStatus() {
        return status;
    }
}
