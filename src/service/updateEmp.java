package service;

import factory.DaoFactory;
import vo.Emp;

public class updateEmp {
    private Emp emp;
    private String statusMsg;
    public updateEmp(Emp emp) {
        this.emp= emp;
    }
    public boolean doUpdateEmp() throws Exception {
        boolean flag = false;
        if(DaoFactory.getEmpInstance().doUpdate(this.emp)) {
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
