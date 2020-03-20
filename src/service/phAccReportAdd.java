package service;

import factory.DaoFactory;
import vo.AccReport;

public class phAccReportAdd {
    private AccReport i;
    private String statusMsg;
    public phAccReportAdd(AccReport i) {
        this.i= i;
    }
    public boolean doAccReport() throws Exception {
        boolean flag = false;
        if(DaoFactory.getIAccReporttance().doCreate(this.i)) {
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
