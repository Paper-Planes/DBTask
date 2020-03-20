package vo;

import java.util.List;

public class Emp {
    private String empNo;//职工编号
    private String empPwd;//职工密码
    private String empName;//职工姓名
    private String empSex;//职工性别
    private String emp;//职工职位


    private List data;

    public void setData(List data) {
        this.data = data;
    }

    public List getData() {
        return data;
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getEmp() {
        return emp;
    }

}
