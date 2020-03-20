package service;


import factory.DaoFactory;
import vo.policyholder;

public class updatePolicyholder {
    private policyholder ph;
    private String statusMsg;
    public updatePolicyholder(policyholder ph) {
        this.ph= ph;
    }
    public boolean doUpdatePolicyholder() throws Exception {
        boolean flag = false;
        if(DaoFactory.getIpolicyholderDaoInstance().doUpdate(this.ph)) {
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
