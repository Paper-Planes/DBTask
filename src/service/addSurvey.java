package service;

import factory.DaoFactory;
import vo.Survey;

public class addSurvey {
    private Survey i;
    private String statusMsg;
    public addSurvey(Survey i) {
        this.i= i;
    }
    public boolean doaddSurvey() throws Exception {
        boolean flag = false;
        if( DaoFactory.getISurveytance().doCreate(this.i)) {
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
