package service;

import factory.DaoFactory;
import vo.Emp;

public class addEmp {
    private Emp emp;
    private String statusMsg;
    public addEmp(Emp emp) {
        this.emp= emp;
    }
    public boolean doaddEmp() throws Exception {
        boolean flag = false;
        if(DaoFactory.getEmpInstance().doCreate(this.emp)) {
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
