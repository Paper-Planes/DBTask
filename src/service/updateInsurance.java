package service;

import factory.DaoFactory;
import vo.Insurance;

public class updateInsurance {
    private Insurance i;
    private String statusMsg;
    public updateInsurance(Insurance i) {
        this.i= i;
    }
    public boolean doUpdateInsurance() throws Exception {
        boolean flag = false;
        if(DaoFactory.getInsuranceInstance().doUpdate(this.i)) {
            this.statusMsg =  "<center><h1>信息修改成功</h1></center>";
            flag = true;
        }
        else {
            this.statusMsg =  "<center><h1>修改失败</h1></center>";
        }
        return flag;
    }

    public String getStatusMsg() {
        return statusMsg;
    }
}
