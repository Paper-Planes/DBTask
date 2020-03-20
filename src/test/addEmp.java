package test;

import factory.DaoFactory;
import util.MD5;
import vo.Emp;

public class addEmp {
    public static void main(String args[])throws Exception{
        Emp emp=new Emp();
        emp.setEmpNo("00002");
        emp.setEmpPwd("00002");
        emp.setEmpName("单二");
        emp.setEmpSex("女");
        emp.setEmp("保险业务员");
        DaoFactory.getEmpInstance().doCreate(emp);
        }
}
