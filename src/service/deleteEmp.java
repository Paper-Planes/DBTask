package service;

import factory.DaoFactory;

public class deleteEmp {
    private String empNo;
    private String statusMsg;
    public deleteEmp(String empNo) {
        this.empNo= empNo;
    }
    public boolean doDeleteEmp() throws Exception {
        boolean flag = false;
        if(DaoFactory.getEmpInstance().doDelete(empNo)) {
            this.statusMsg =  "<center><h1>信息删除成功</h1></center>";
            flag = true;
        }
        else {
            this.statusMsg =  "<center><h1>删除失败</h1></center>";
        }
        return flag;
    }
    public String getStatusMsg() {
        return statusMsg;
    }
}
