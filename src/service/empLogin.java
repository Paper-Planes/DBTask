package service;

import factory.DaoFactory;
import vo.Emp;

public class empLogin {
    private String empNo;
    private String empPwd;
    private String StatusMsg;

    public empLogin(String empNo, String empPwd){
        this.empNo=empNo;
        this.empPwd=empPwd;
    }

    public boolean doLogin() throws Exception {
        boolean flag = false;
        Emp emp=new Emp();
        emp= DaoFactory.getEmpInstance().findById(this.empNo);
        if(emp== null) {
            this.StatusMsg = "<center><h1>该用户不存在！</h1></center>";
        }
        else {
            if(!emp.getEmpPwd().equals(this.empPwd)) {
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
