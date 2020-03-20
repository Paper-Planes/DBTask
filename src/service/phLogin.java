package service;

import factory.DaoFactory;
import vo.policyholder;

public class phLogin {
    private String phNumber;
    private String phPwd;
    private String StatusMsg;

    public phLogin(String phNumber, String phPwd){
        this.phNumber=phNumber;
        this.phPwd=phPwd;
    }

    public boolean doLogin() throws Exception {
        boolean flag = false;

        policyholder ph = new policyholder();
        ph = DaoFactory.getIpolicyholderDaoInstance().findById(this.phNumber);
        if(ph == null) {
            this.StatusMsg = "<center><h1>该用户不存在！</h1></center>";
        }
        else {
            if(!ph.getPhPwd().equals(this.phPwd)) {
                this.StatusMsg =  "<center><h1>密码错误！</h1></center>";
            }
            else {
                flag = true;
                this.StatusMsg =  "<center><h1>登陆成功！</h1></center>";
            }
        }
        return flag;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }
}
